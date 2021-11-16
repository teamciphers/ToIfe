package com.example.toife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class User_profile extends AppCompatActivity {
    EditText username,Email,Bio;
    Button save;
    FirebaseFirestore db;
    FirebaseAuth mAuth;
    String Username_og,Email_id,Bio_display;
    int counter = 0;

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
        Email_id = mAuth.getCurrentUser().getEmail();



        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        Query checkUser = reference.orderByChild("uid").equalTo(mAuth.getUid());
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Username_og = dataSnapshot.child(mAuth.getUid()).child("name1").getValue(String.class);
                    Bio_display = dataSnapshot.child(mAuth.getUid()).child("bio_user").getValue(String.class);
                    username.setText(Username_og);
                    Email.setText(Email_id);
                    Bio.setText(Bio_display);
                    System.out.println(Username_og);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });







        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString();
                String bio = Bio.getText().toString();
                String check_email = Email.getText().toString();

                if(check_email.equals(Email_id)) {
                    counter+=1;
                }else{
                    Email.setError("This field can't be changed");
                    Email.requestFocus();}

                if(Username.equals(Username_og)){
                        counter+=1;
                }else {

                    username.setError("This field can't be changed");
                    username.requestFocus();}

                if(counter ==2) {
                    Map<String, Object> user = new HashMap<>();
                    user.put("Username", Username);
                    user.put("Bio", bio);
                    user.put("Email", Email_id);

                    db.collection("user").document(mAuth.getUid()).set(user);
                    
                }

            }
        });

    }
}