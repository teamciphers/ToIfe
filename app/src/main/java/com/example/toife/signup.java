package com.example.toife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {
    private Button sing_up_page2;
    EditText sign_up_username, email_id, new_password, confirm_password;
    String Name1,email1,pass1,type,cpass1;
    RadioButton radioYesButton,radioNoButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//All edit text connected to variables
        sign_up_username = findViewById(R.id.signup_username);
        email_id = findViewById(R.id.emailid);
        new_password = findViewById(R.id.new_pass);
        confirm_password = findViewById(R.id.confirmpass);
        radioYesButton = findViewById(R.id.therapist_yes);
        radioNoButton = findViewById(R.id.therapist_no);

//Connecting button to variable
        sing_up_page2 = findViewById(R.id.singup);
        //Firebase connections



        sing_up_page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name1 = sign_up_username.getText().toString();
                email1 = email_id.getText().toString();
                pass1 = new_password.getText().toString();
                cpass1  = confirm_password.getText().toString();

                if (Name1.isEmpty()) {
                    sign_up_username.setError("Please set a user name");
                    sign_up_username.requestFocus();
                } else if (email1.isEmpty()) {
                    email_id.setError("Please enter an email id");
                    email_id.requestFocus();
                }else if(pass1.isEmpty()) {
                    new_password.setError("Please set an password");
                    new_password.requestFocus();
                } else if(cpass1.isEmpty()) {
                    confirm_password.setError("Please set an password");
                    confirm_password.requestFocus();
                }else if(cpass1.equals(pass1)){

                    if (radioNoButton.isChecked()) {
                        type = "user";
                        openNextPage();

                    } else if (radioYesButton.isChecked()) {
                        type = "therapist";
                        openTheSignPage();

                    }
                }else{
                    Toast.makeText(signup.this, "Password's don't match.", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }


    private void openNextPage(){
        Intent intent3 = new Intent(this, signup_page2.class);
        intent3.putExtra("name",Name1);
        intent3.putExtra("email",email1);
        intent3.putExtra("pass",pass1);
        intent3.putExtra("type",type);

        startActivity(intent3);

    }

    private void openTheSignPage(){
        Intent intent3 = new Intent(this, Therapist_signup.class);
        intent3.putExtra("name",Name1);
        intent3.putExtra("email",email1);
        intent3.putExtra("pass",pass1);
        intent3.putExtra("type",type);

        startActivity(intent3);

    }
}