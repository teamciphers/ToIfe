package com.example.toife;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class homepage extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    TextView sc;
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