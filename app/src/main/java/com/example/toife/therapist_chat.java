package com.example.toife;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class therapist_chat extends AppCompatActivity {

    TextView username;
    RecyclerView chat_r_view;
    THERAPIST_ADAPTER adapter;
    FirebaseDatabase database;
    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    DatabaseReference reference;
    ArrayList<UserHelperClass> usersArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist_chat);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Therapist");

        usersArrayList = new ArrayList<>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserHelperClass user = dataSnapshot.getValue(UserHelperClass.class);
                    usersArrayList.add(user);
                    if(FirebaseAuth.getInstance().getCurrentUser() != null)
                        if(user.getuid().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())){
                            usersArrayList.remove(user);}
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        adapter = new THERAPIST_ADAPTER(therapist_chat.this,usersArrayList);
        chat_r_view = findViewById(R.id.therapist_chat_r_view);
        chat_r_view.setLayoutManager(new LinearLayoutManager(this));
        chat_r_view.setAdapter(adapter);
    }
}