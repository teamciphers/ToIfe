package com.example.toife;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class check_login extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser != null){
            Intent intent69=new Intent(check_login.this,homepage.class);
            intent69.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent69.putExtra("from_cl","true");
            startActivity(intent69);

        }
    }
}
