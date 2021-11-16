package com.example.toife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {
    private Button sing_up_page2;
    EditText sign_up_username, email_id, new_password, confirm_password;
    String Name1,email1,pass1,type;
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

        String cpass1 = confirm_password.getText().toString();

        sing_up_page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name1 = sign_up_username.getText().toString();
                email1 = email_id.getText().toString();
                pass1 = new_password.getText().toString();

                if(radioNoButton.isChecked()) {
                    type = "user";
                    openNextPage();

                }else if (radioYesButton.isChecked()){
                    type = "therapist";
                    openTheSignPage();

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