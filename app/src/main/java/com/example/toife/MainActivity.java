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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    private TextView su;
    private Button log_in;
    EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //connecting variables to their XML counterparts
        su =(TextView) findViewById(R.id.opensignup);
        log_in = findViewById(R.id.signin);

        emailEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        //get current instance
        mAuth = FirebaseAuth.getInstance();

        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }

        });

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString();
                if (email.isEmpty()) {
                    emailEditText.setError("Please enter email id");
                    emailEditText.requestFocus();
                } else if (pass.isEmpty()) {
                    passwordEditText.setError("Please enter your password");
                    passwordEditText.requestFocus();
                }else{
                    mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                openHomepage();
                                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }


    private void openHomepage() {

        Intent OSign = new Intent(this, homepage.class);
        OSign.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(OSign);
        this.finish();
    }

    private void openSignup() {

        Intent i = new Intent(this, signup.class);
        startActivity(i);

    }
}