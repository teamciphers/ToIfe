package com.example.toife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class signup extends AppCompatActivity {
    private Button sing_up;
    EditText sign_up_username, email_id, new_password, confirm_password;

    FirebaseDatabase rootnode;
    DatabaseReference reference;
    FirebaseAuth mAuth;

    private UserHelperClass uhc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//All edit text connected to variables
        sign_up_username = findViewById(R.id.signup_username);
        email_id = findViewById(R.id.emailid);
        new_password = findViewById(R.id.new_pass);
        confirm_password = findViewById(R.id.confirmpass);

//Connecting button to variable
        sing_up=findViewById(R.id.singup);
        //Firebase connections
        rootnode = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();


        sing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference = rootnode.getReference("P_d");

                String Name1 = sign_up_username.getText().toString();
                String email1 = email_id.getText().toString();
                String pass1 = new_password.getText().toString();
                String cpass1 = confirm_password.getText().toString();
                mAuth.createUserWithEmailAndPassword(email1,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                            uhc = new UserHelperClass(Name1, email1, pass1);
                            openPatPage();





                        } else {
                            Toast.makeText(signup.this, "Could Not sign you Up", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

    private void openPatPage() {
        Intent intent3 = new Intent(this, MainActivity.class);
        reference.child(mAuth.getUid()).setValue(uhc);
        startActivity(intent3);
    }
}