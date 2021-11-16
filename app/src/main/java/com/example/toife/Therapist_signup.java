package com.example.toife;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Therapist_signup extends AppCompatActivity {

    String Name1,email1,pass1,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist_signup);

        Name1 = getIntent().getStringExtra("name");
        email1 = getIntent().getStringExtra("email");
        pass1 = getIntent().getStringExtra("pass");
        type = getIntent().getStringExtra("type");

        System.out.println(type);



    }
}