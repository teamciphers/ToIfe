package com.example.toife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup_page2 extends AppCompatActivity {

    private Button sing_up;

    String Name1,email1,pass1,type,bio_user;
    EditText Bio;

    FirebaseDatabase rootnode;
    DatabaseReference reference;
    FirebaseAuth mAuth;

    private UserHelperClass uhc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page2);

        Name1 = getIntent().getStringExtra("name");
        email1 = getIntent().getStringExtra("email");
        pass1 = getIntent().getStringExtra("pass");
        type = getIntent().getStringExtra("type");

        Bio = findViewById(R.id.bio_user);



        //Connecting button to variable
        sing_up=findViewById(R.id.sign_up_final);
        //Firebase connections
        rootnode = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();


        sing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference = rootnode.getReference("Users");
                bio_user = Bio.getText().toString();

                mAuth.createUserWithEmailAndPassword(email1,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup_page2.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                            String uid = mAuth.getUid();
                            uhc = new UserHelperClass(Name1, email1, pass1,uid,type,bio_user);

                            openUserPage();



                        } else {
                            Toast.makeText(signup_page2.this, "Could Not sign you Up", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

    private void openUserPage() {
        Intent intent10 = new Intent(this, MainActivity.class);
        reference.child(mAuth.getUid()).setValue(uhc);
        FirebaseAuth.getInstance().signOut();
        startActivity(intent10);

    }
}