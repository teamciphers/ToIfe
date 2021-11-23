package com.example.toife;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.toife.Adaptr.putPDF;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Therapist_signup extends AppCompatActivity {

    String Name1,email1,pass1,type,Bio,degrees;;

    private Button sing_up;

    FirebaseDatabase rootnode;
    DatabaseReference reference,reference_alldata, updr;
    FirebaseAuth mAuth;
    StorageReference storageReference;
    EditText uploaded,bio_th;

    private UserHelperClass uhc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist_signup);

        Name1 = getIntent().getStringExtra("name");
        email1 = getIntent().getStringExtra("email");
        pass1 = getIntent().getStringExtra("pass");
        type = getIntent().getStringExtra("type");
        Bio = "";
        degrees = "none";
        bio_th = findViewById(R.id.th_bio);

        uploaded = findViewById(R.id.uploaddoc);

        storageReference = FirebaseStorage.getInstance().getReference();

        updr = FirebaseDatabase.getInstance().getReference("uploadDOC");
        uploaded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPDF();
            }
        });

        //Connecting button to variable
        sing_up=findViewById(R.id.therapist_signup);
        sing_up.setEnabled(false);     //Firebase connections
        rootnode = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();



    }

    private void selectPDF() {
        Intent u = new Intent();
        u.setType("application/pdf");
        u.setAction(u.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(u, "PDF FILE SELECTED"), 12);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==12 && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            sing_up.setEnabled(true);
            uploaded.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            sing_up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    uplodedPDFFileFirebase(data.getData());



                        reference = rootnode.getReference("Therapist");
                        reference_alldata = rootnode.getReference("All_data");
                        Bio = bio_th.getText().toString();

                        mAuth.createUserWithEmailAndPassword(email1, pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Therapist_signup.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                                    String uid = mAuth.getUid();
                                    uhc = new UserHelperClass(Name1, email1, pass1, uid, type, Bio, degrees);

                                    openTherapistPage();


                                } else {
                                    Toast.makeText(Therapist_signup.this, "Could Not sign you Up", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }


            });
        }


    }

    private void uplodedPDFFileFirebase(Uri data) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("File is uploading");
        progressDialog.show();

        StorageReference reference= storageReference.child("uploadDOC"+System.currentTimeMillis()+".pdf");

        reference.putFile(data).
                addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete());
                        Uri uri=uriTask.getResult();

                        putPDF ob = new putPDF(uploaded.getText().toString(), uri.toString());
                        updr.child(updr.push().getKey()).setValue(ob);
                        Toast.makeText(Therapist_signup.this, "File uploaded", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();


                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

                double progress = (100* snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                progressDialog.setMessage("File Uploaded..."+(int)progress+"%");

            }
        });

    }

    private void openTherapistPage() {
        Intent intent45 = new Intent(this, MainActivity.class);
        reference.child(mAuth.getUid()).setValue(uhc);
        reference_alldata.child(mAuth.getUid()).setValue(uhc);
        FirebaseAuth.getInstance().signOut();
        startActivity(intent45);

    }
}
