package com.example.toife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    String Name1,email1,pass1;

    FirebaseDatabase rootnode;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    RadioGroup q1, q2, q3, q4, q5, q6, q7, q8, q9;
    RadioButton selectedrb;

    private UserHelperClass uhc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page2);

        Name1 = getIntent().getStringExtra("name");
        email1 = getIntent().getStringExtra("email");
        pass1 = getIntent().getStringExtra("pass");


        //Connecting button to variable
        sing_up=findViewById(R.id.sign_up_final);
        //Firebase connections
        rootnode = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        //Radio Groups
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
        q6 = findViewById(R.id.q6);
        q7 = findViewById(R.id.q7);
        q8 = findViewById(R.id.q8);
        q9 = findViewById(R.id.q9);


        sing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int srbid;
                String srbtext;
                int severity=0;
                String degrees="";
                srbid = q1.getCheckedRadioButtonId();
                if(srbid != -1)
                {
                    selectedrb = findViewById(srbid);
                    srbtext = selectedrb.getText().toString();
                    System.out.println(srbtext);
                    if(srbtext.equalsIgnoreCase("Several days"))
                    {
                        severity+=1;
                    }
                    if(srbtext.equalsIgnoreCase("More than half the days"))
                    {
                        severity+=2;
                    }
                    if(srbtext.equalsIgnoreCase("Nearly everday"))
                    {
                        severity+=3;
                    }

                }
                else
                {
                    Toast.makeText(signup_page2.this, "Please select an answer for QUESTION 1", Toast.LENGTH_LONG).show();
                }
                srbid = q2.getCheckedRadioButtonId();
                if(srbid != -1)
                {
                    selectedrb = findViewById(srbid);
                    srbtext = selectedrb.getText().toString();
                    System.out.println(srbtext);
                    if(srbtext.equalsIgnoreCase("Several days"))
                    {
                        severity+=1;
                    }
                    if(srbtext.equalsIgnoreCase("More than half the days"))
                    {
                        severity+=2;
                    }
                    if(srbtext.equalsIgnoreCase("Nearly everday"))
                    {
                        severity+=3;
                    }

                }
                else
                {
                    Toast.makeText(signup_page2.this, "Please select an answer for QUESTION 2", Toast.LENGTH_LONG).show();
                }
                srbid = q3.getCheckedRadioButtonId();
                if(srbid != -1)
                {
                    selectedrb = findViewById(srbid);
                    srbtext = selectedrb.getText().toString();
                    System.out.println(srbtext);
                    if(srbtext.equalsIgnoreCase("Several days"))
                    {
                        severity+=1;
                    }
                    if(srbtext.equalsIgnoreCase("More than half the days"))
                    {
                        severity+=2;
                    }
                    if(srbtext.equalsIgnoreCase("Nearly everday"))
                    {
                        severity+=3;
                    }

                }
                else
                {
                    Toast.makeText(signup_page2.this, "Please Select an answer for QUESTION 3", Toast.LENGTH_LONG).show();
                }
                srbid = q4.getCheckedRadioButtonId();
                if(srbid != -1)
                {
                    selectedrb = findViewById(srbid);
                    srbtext = selectedrb.getText().toString();
                    System.out.println(srbtext);
                    if(srbtext.equalsIgnoreCase("Several days"))
                    {
                        severity+=1;
                    }
                    if(srbtext.equalsIgnoreCase("More than half the days"))
                    {
                        severity+=2;
                    }
                    if(srbtext.equalsIgnoreCase("Nearly everday"))
                    {
                        severity+=3;
                    }

                }
                else
                {
                    Toast.makeText(signup_page2.this, "Please Select an answer for QUESTION 4", Toast.LENGTH_LONG).show();
                }
                srbid = q5.getCheckedRadioButtonId();
                if(srbid != -1)
                {
                    selectedrb = findViewById(srbid);
                    srbtext = selectedrb.getText().toString();
                    System.out.println(srbtext);
                    if(srbtext.equalsIgnoreCase("Several days"))
                    {
                        severity+=1;
                    }
                    if(srbtext.equalsIgnoreCase("More than half the days"))
                    {
                        severity+=2;
                    }
                    if(srbtext.equalsIgnoreCase("Nearly everday"))
                    {
                        severity+=3;
                    }

                }
                else
                {
                    Toast.makeText(signup_page2.this, "Please Select an answer for QUESTION 5", Toast.LENGTH_LONG).show();
                }
                srbid = q6.getCheckedRadioButtonId();
                if(srbid != -1)
                {
                    selectedrb = findViewById(srbid);
                    srbtext = selectedrb.getText().toString();
                    System.out.println(srbtext);
                    if(srbtext.equalsIgnoreCase("Several days"))
                    {
                        severity+=1;
                    }
                    if(srbtext.equalsIgnoreCase("More than half the days"))
                    {
                        severity+=2;
                    }
                    if(srbtext.equalsIgnoreCase("Nearly everday"))
                    {
                        severity+=3;
                    }
                }
                else
                {
                    Toast.makeText(signup_page2.this, "Please Select an answer for QUESTION 6", Toast.LENGTH_LONG).show();
                }
                srbid = q7.getCheckedRadioButtonId();
                if(srbid != -1)
                {
                    selectedrb = findViewById(srbid);
                    srbtext = selectedrb.getText().toString();
                    System.out.println(srbtext);
                    if(srbtext.equalsIgnoreCase("Several days"))
                    {
                        severity+=1;
                    }
                    if(srbtext.equalsIgnoreCase("More than half the days"))
                    {
                        severity+=2;
                    }
                    if(srbtext.equalsIgnoreCase("Nearly everday"))
                    {
                        severity+=3;
                    }

                }
                else
                {
                    Toast.makeText(signup_page2.this, "Please Select an answer for QUESTION 7", Toast.LENGTH_LONG).show();
                }
                srbid = q8.getCheckedRadioButtonId();
                if(srbid != -1)
                {
                    selectedrb = findViewById(srbid);
                    srbtext = selectedrb.getText().toString();
                    System.out.println(srbtext);
                    if(srbtext.equalsIgnoreCase("Several days"))
                    {
                        severity+=1;
                    }
                    if(srbtext.equalsIgnoreCase("More than half the days"))
                    {
                        severity+=2;
                    }
                    if(srbtext.equalsIgnoreCase("Nearly everday"))
                    {
                        severity+=3;
                    }

                }
                else
                {
                    Toast.makeText(signup_page2.this, "Please Select an answer for QUESTION 8", Toast.LENGTH_LONG).show();
                }
                srbid = q9.getCheckedRadioButtonId();
                if(srbid != -1)
                {
                    selectedrb = findViewById(srbid);
                    srbtext = selectedrb.getText().toString();
                    System.out.println(srbtext);
                    if(srbtext.equalsIgnoreCase("Several days"))
                    {
                        severity+=1;
                    }
                    if(srbtext.equalsIgnoreCase("More than half the days"))
                    {
                        severity+=2;
                    }
                    if(srbtext.equalsIgnoreCase("Nearly everday"))
                    {
                        severity+=3;
                    }

                }
                else
                {
                    Toast.makeText(signup_page2.this, "Please Select an answer for QUESTION 9", Toast.LENGTH_LONG).show();
                }
                System.out.println(severity);
                if(severity>=0 && severity<=4)
                    degrees = "None-minimal";
                if(severity>=5 && severity<=9)
                    degrees = "Mild";
                if(severity>=10 && severity<=14)
                    degrees = "Moderate";
                if(severity>=15 && severity<=19)
                    degrees = "Moderately Severe";
                if(severity>=20)
                    degrees="Severe";
                System.out.println(degrees);

                reference = rootnode.getReference("Users");

                mAuth.createUserWithEmailAndPassword(email1,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup_page2.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                            String uid = mAuth.getUid();
                            uhc = new UserHelperClass(Name1, email1, pass1,uid);

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