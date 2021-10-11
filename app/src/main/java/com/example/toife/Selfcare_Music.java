package com.example.toife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.InetAddresses;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InlineSuggestionsRequest;
import android.widget.ImageView;

public class Selfcare_Music extends AppCompatActivity {


    public ImageView s1;
    public ImageView s2;
    public ImageView s3;
    public ImageView s4;
    public ImageView s5;
    public ImageView s6;
    public ImageView s7;
    public ImageView s8;
    public ImageView s9;
    public ImageView s10;
    public ImageView s11;
    public ImageView s12;
    public ImageView y1;
    public ImageView y2;
    public ImageView y3;
    public ImageView y4;
    public ImageView y5;
    public ImageView y6;
    public ImageView y7;
    public ImageView y8;
    public ImageView y9;
    public ImageView y10;
    public ImageView y11;
    public ImageView y12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfcare_music);

        s1 = (ImageView) findViewById(R.id.image_spotify1);
        s2 = (ImageView) findViewById(R.id.image_spotify2);
        s3 = (ImageView) findViewById(R.id.image_spotify3);
        s4 = (ImageView) findViewById(R.id.image_spotify4);
        s5 = (ImageView) findViewById(R.id.image_spotify5);
        s6 = (ImageView) findViewById(R.id.image_spotify6);
        s7 = (ImageView) findViewById(R.id.image_spotify7);
        s8 = (ImageView) findViewById(R.id.image_spotify8);
        s9 = (ImageView) findViewById(R.id.image_spotify9);
        s10 = (ImageView) findViewById(R.id.image_spotify10);
        s11 = (ImageView) findViewById(R.id.image_spotify11);
        s12 = (ImageView) findViewById(R.id.image_spotify12);

        y1 = (ImageView) findViewById(R.id.image_youtube1);
        y2 = (ImageView) findViewById(R.id.image_youtube2);
        y3 = (ImageView) findViewById(R.id.image_youtube3);
        y4 = (ImageView) findViewById(R.id.image_youtube4);
        y5 = (ImageView) findViewById(R.id.image_youtube5);
        y6 = (ImageView) findViewById(R.id.image_youtube6);
        y7 = (ImageView) findViewById(R.id.image_youtube7);
        y8 = (ImageView) findViewById(R.id.image_youtube8);
        y9 = (ImageView) findViewById(R.id.image_youtube9);
        y10 = (ImageView) findViewById(R.id.image_youtube10);
        y11 = (ImageView) findViewById(R.id.image_youtube11);
        y12 = (ImageView) findViewById(R.id.image_youtube12);

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urls1 = "https://open.spotify.com/track/0xyEZc2ntQg5ss0i8vJ8PF?si=fbf4f8974db540bc";
                Intent us1 =new Intent(Intent.ACTION_VIEW);
                us1.setData(Uri.parse(urls1));
                startActivity(us1);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls2 = "https://open.spotify.com/track/6L8tXG8hFllYNNjnyrbuOF?si=ec0b0a4db9cc49f6";
                Intent us2 =  new Intent(Intent.ACTION_VIEW);
                us2.setData(Uri.parse(urls2));
                startActivity(us2);
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls3="https://open.spotify.com/track/6f3ZH4XvAOZV5nNKGy3mHw?si=4d7fd94a7d774625";
                Intent us3 = new Intent(Intent.ACTION_VIEW);
                us3.setData(Uri.parse(urls3));
                startActivity(us3);
            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls4="https://open.spotify.com/track/1nOoKEifkt9NUz25Sug2iU?si=3b4ae4ac5b7d4a16";
                Intent us4=new Intent(Intent.ACTION_VIEW);
                us4.setData(Uri.parse(urls4));
                startActivity(us4);
            }
        });

        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls5="https://open.spotify.com/track/0YspvfElhYOLWUE4de64LZ?si=54c3895de5e34e2c";
                Intent us5=new Intent(Intent.ACTION_VIEW);
                us5.setData(Uri.parse(urls5));
                startActivity(us5);
            }
        });

        s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls6="https://open.spotify.com/track/1SqaUI3VIgVSlG8WqL7HvS?si=2befcee29a1c4a7d";
                Intent us6 = new Intent(Intent.ACTION_VIEW);
                us6.setData(Uri.parse(urls6));
                startActivity(us6);
            }
        });

        s7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls7="https://open.spotify.com/track/4KZ2JPQlYG5FCfmmq7dfvx?si=2acf9850f3284abf";
                Intent us7 = new Intent(Intent.ACTION_VIEW);
                us7.setData(Uri.parse(urls7));
                startActivity(us7);
            }
        });

        s8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls8="https://open.spotify.com/track/5YZwuVLjC4PTNvSD8D3AJM?si=388f9f17cf3a42ea";
                Intent us8=new Intent(Intent.ACTION_VIEW);
                us8.setData(Uri.parse(urls8));
                startActivity(us8);
            }
        });

        s9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls9 = "https://open.spotify.com/track/1KmRQPYJW7kdZD8zc42ZSj?si=d3652f01ea644b9d";
                Intent us9=new Intent(Intent.ACTION_VIEW);
                us9.setData(Uri.parse(urls9));
                startActivity(us9);
            }
        });

        s10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls10="https://open.spotify.com/track/1kmbKbSfSiZW2241Gi5UFL?si=d52677d56f8f4684";
                Intent us10=new Intent(Intent.ACTION_VIEW);
                us10.setData(Uri.parse(urls10));
                startActivity(us10);
            }
        });

        s11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls11="https://open.spotify.com/track/4FqJCQ2ORbfr0BCluuceYV?si=37fa638616bd41fb";
                Intent us11=new Intent(Intent.ACTION_VIEW);
                us11.setData(Uri.parse(urls11));
                startActivity(us11);
            }
        });

        s12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls12="https://open.spotify.com/track/2Fk74jeHsoSmSM9o4PgUTO?si=3978bf98384841b9";
                Intent us12=new Intent(Intent.ACTION_VIEW);
                us12.setData(Uri.parse(urls12));
                startActivity(us12);
            }
        });

        y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urly1 = "https://youtu.be/wioUZhifTs4";
                Intent uy1 =new Intent(Intent.ACTION_VIEW);
                uy1.setData(Uri.parse(urly1));
                startActivity(uy1);
            }
        });

        y2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urly2 = "https://www.youtube.com/watch?v=y7KH-VJvbt8";
                Intent uy2 =  new Intent(Intent.ACTION_VIEW);
                uy2.setData(Uri.parse(urly2));
                startActivity(uy2);
            }
        });

        y3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urly3="https://www.youtube.com/watch?v=-Lq-UNoKXOo";
                Intent uy3 = new Intent(Intent.ACTION_VIEW);
                uy3.setData(Uri.parse(urly3));
                startActivity(uy3);
            }
        });

        y4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urly4="https://www.youtube.com/watch?v=9A2i6cVYq7g";
                Intent uy4=new Intent(Intent.ACTION_VIEW);
                uy4.setData(Uri.parse(urly4));
                startActivity(uy4);
            }
        });

        y5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urly5="https://www.youtube.com/watch?v=U8TzqhdZkGU";
                Intent uy5=new Intent(Intent.ACTION_VIEW);
                uy5.setData(Uri.parse(urly5));
                startActivity(uy5);
            }
        });

        y6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urly6="https://www.youtube.com/watch?v=bgFIRlZMzNE";
                Intent uy6 = new Intent(Intent.ACTION_VIEW);
                uy6.setData(Uri.parse(urly6));
                startActivity(uy6);
            }
        });

        y7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urly7="https://www.youtube.com/watch?v=WLYXzJTFPmI";
                Intent uy7 = new Intent(Intent.ACTION_VIEW);
                uy7.setData(Uri.parse(urly7));
                startActivity(uy7);
            }
        });

        y8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urly8="https://www.youtube.com/watch?v=V3CrHR4ui5I";
                Intent uy8=new Intent(Intent.ACTION_VIEW);
                uy8.setData(Uri.parse(urly8));
                startActivity(uy8);
            }
        });

        y9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urly9 = "https://www.youtube.com/watch?v=i4Jsy8_gCvQ";
                Intent uy9=new Intent(Intent.ACTION_VIEW);
                uy9.setData(Uri.parse(urly9));
                startActivity(uy9);
            }
        });

        y10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urly10="https://www.youtube.com/watch?v=4cJGELPdwW0";
                Intent uy10=new Intent(Intent.ACTION_VIEW);
                uy10.setData(Uri.parse(urly10));
                startActivity(uy10);
            }
        });

        y11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urly11="https://youtu.be/S0ioBZItZ2A";
                Intent uy11=new Intent(Intent.ACTION_VIEW);
                uy11.setData(Uri.parse(urly11));
                startActivity(uy11);
            }
        });

        y12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urly12="https://youtu.be/kz5t_3wR9k8";
                Intent uy12=new Intent(Intent.ACTION_VIEW);
                uy12.setData(Uri.parse(urly12));
                startActivity(uy12);
            }
        });
    }
}