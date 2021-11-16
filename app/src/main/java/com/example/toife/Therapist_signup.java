package com.example.toife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Therapist_signup extends AppCompatActivity {

    String Name1,email1,pass1,type,Bio,degrees;;

    private Button sing_up;

    FirebaseDatabase rootnode;
    DatabaseReference reference,reference_alldata;
    FirebaseAuth mAuth;

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


        //Connecting button to variable
        sing_up=findViewById(R.id.therapist_signup);
        //Firebase connections
        rootnode = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        sing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference = rootnode.getReference("Therapist");
                reference_alldata = rootnode.getReference("All_data");

                mAuth.createUserWithEmailAndPassword(email1,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Therapist_signup.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                            String uid = mAuth.getUid();
                            uhc = new UserHelperClass(Name1, email1, pass1,uid,type,Bio,degrees);

                            openTherapistPage();



                        } else {
                            Toast.makeText(Therapist_signup.this, "Could Not sign you Up", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

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