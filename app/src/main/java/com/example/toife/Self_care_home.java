package com.example.toife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Self_care_home extends AppCompatActivity {

    public ImageView music;

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

    }

    private void openselfcaremusic() {

        Intent m=new Intent(this, Selfcare_Music.class);
        startActivity(m);

    }
}