package com.example.toife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView su;
    private Button log_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connecting variables to their XML counterparts
        su =(TextView) findViewById(R.id.opensignup);
        log_in = findViewById(R.id.signin);


        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }
        });

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomepage();
            }
        });
    }


    private void openHomepage() {

        Intent OSign = new Intent(this, homepage.class);
        startActivity(OSign);

    }

    private void openSignup() {

        Intent i = new Intent(this, signup.class);
        startActivity(i);

    }
}