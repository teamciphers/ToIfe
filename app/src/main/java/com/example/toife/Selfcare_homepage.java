package com.example.toife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Selfcare_homepage extends AppCompatActivity {

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfcare_homepage);

        b = (Button) findViewById(R.id.selfcare_start);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmusic();
            }
        });
    }

    private void openmusic() {

        Intent i1=new Intent(this, Self_care_home.class);
        startActivity(i1);
        this.finish();
    }
}