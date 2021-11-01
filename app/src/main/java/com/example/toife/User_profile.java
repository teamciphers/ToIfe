package com.example.toife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class User_profile extends AppCompatActivity {
    EditText username,Email,Bio;
    Button save;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        db = FirebaseFirestore.getInstance();
        username = findViewById(R.id.uname_edittext);
        Email = findViewById(R.id.email_up_edittext);
        Bio = findViewById(R.id.bio_up_edittext);
        save = findViewById(R.id.save_button);
        mAuth = FirebaseAuth.getInstance();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString();
                String bio = Bio.getText().toString();
                String Email_id = Email.getText().toString();

                Map<String,Object> user = new HashMap<>();
                user.put("Username",Username);
                user.put("Bio",bio);

                db.collection("user").document(mAuth.getUid()).set(user);


            }
        });

    }
}