package com.example.toife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Self_care_home extends AppCompatActivity {

    public ImageView music;
    public ImageView clrt;
    public ImageView bk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_care_home);

        music = (ImageView) findViewById(R.id.music_play);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openselfcaremusic();
            }
        });
        clrt = (ImageView) findViewById(R.id.ct);
        clrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencolortherapy();
            }
        });

        bk=findViewById(R.id.book);
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReadBook();
            }
        });


    }

    private void openReadBook() {
        Intent b= new Intent(this, selfcare_book.class);
        startActivity(b);
    }


    private void opencolortherapy() {

        Intent c=new Intent(this, Selfcare_colortherapy.class);
        startActivity(c);

    }

    private void openselfcaremusic() {

        Intent m=new Intent(this, Selfcare_Music.class);
        startActivity(m);

    }

}