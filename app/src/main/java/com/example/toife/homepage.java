package com.example.toife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    TextView sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        sc = (TextView) findViewById(R.id.selfcare);
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSCHome();
            }
        });
    }

    private void openSCHome() {

        Intent secahome =  new Intent(this, Selfcare_homepage.class);
        startActivity(secahome);

    }
}