package com.example.toife;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class homepage extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    TextView sc,chat,therapy, stor;
    String type;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        Intent intent69 = getIntent();
        String check = intent69.getStringExtra("from_cl");

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("All_data");
        Query checkUser = reference.orderByChild("uid").equalTo(firebaseAuth.getUid());
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    type = dataSnapshot.child(firebaseAuth.getUid()).child("type").getValue(String.class);
                    System.out.println(type);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        sc = (TextView) findViewById(R.id.selfcare);
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSCHome();
            }
        });

        chat = (TextView) findViewById(R.id.friends);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("therapist")){
                    Toast.makeText(homepage.this, "Sorry this feature is unavailable", Toast.LENGTH_SHORT).show();

                }else{
                openChatHome();}
            }
        });

        therapy = (TextView) findViewById(R.id.therapist);
        therapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentherapistHome();
            }
        });

        stor = (TextView)  findViewById(R.id.stories);
        stor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStories();
            }
        });



    }

    private void openStories() {
        Intent st = new Intent(this, stories.class);
        startActivity(st);
    }

    private void openSCHome() {

        Intent secahome =  new Intent(this, Selfcare_homepage.class);
        startActivity(secahome);

    }

    private void openChatHome() {

        Intent chathome =  new Intent(this, Chat_toLife.class);
        startActivity(chathome);

    }

    private void opentherapistHome() {

        Intent chat_therapy =  new Intent(this, therapist_chat.class);
        startActivity(chat_therapy);

    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popupenu_homepage);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent profile_intent = new Intent(homepage.this,User_profile.class);
                startActivity(profile_intent);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                FirebaseAuth.getInstance().signOut();
                Intent signout_intent = new Intent(homepage.this,MainActivity.class);
                signout_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                signout_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(signout_intent);
                return true;
            default:
                return false;
        }
    }

    public void onBackPressed(){
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }






}