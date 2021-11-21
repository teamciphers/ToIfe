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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Chat_toLife extends AppCompatActivity {

        TextView username;
        RecyclerView chat_r_view;
        USER_ADAPTER adapter;
        FirebaseDatabase database;
        FirebaseAuth auth;
        FirebaseUser firebaseUser;
        DatabaseReference reference,reference_Check1,reference_Check2;
        ArrayList<UserHelperClass> usersArrayList;
        String degree;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chat_to_life);
            auth = FirebaseAuth.getInstance();
            database = FirebaseDatabase.getInstance();





            reference = FirebaseDatabase.getInstance().getReference("All_data");
            Query checkUser = reference.orderByChild("uid").equalTo(auth.getUid());

            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        degree = dataSnapshot.child(auth.getUid()).child("degrees").getValue(String.class);
                        System.out.println("hello1 " + degree);
                        reference_Check1 = database.getReference().child("User_chat2").child(auth.getUid());
                        reference_Check2 = database.getReference().child("Users");

                        usersArrayList = new ArrayList<>();

                        if (degree.equals("None-minimal")) {
                            reference_Check1.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                        UserHelperClass user = dataSnapshot.getValue(UserHelperClass.class);
                                        usersArrayList.add(user);
                                        if (FirebaseAuth.getInstance().getCurrentUser() != null)
                                            if (user.getuid().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                                                usersArrayList.remove(user);
                                            }

                                    }
                                    adapter.notifyDataSetChanged();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


                        }else{


                            reference_Check2.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                        UserHelperClass user = dataSnapshot.getValue(UserHelperClass.class);
                                        usersArrayList.add(user);
                                        if(FirebaseAuth.getInstance().getCurrentUser() != null)
                                            if(user.getuid().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())){
                                                usersArrayList.remove(user);}
                                        //new
                                        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                                            if (user.getdegrees().equals("Mild") || user.getdegrees().equals("Moderate") || user.getdegrees().equals("Moderately Severe")) {
                                                usersArrayList.remove(user);
                                            }

                                        }
                                        //end

                                    }
                                    adapter.notifyDataSetChanged();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });



                        }

                        adapter = new USER_ADAPTER(Chat_toLife.this,usersArrayList);
                        chat_r_view = findViewById(R.id.chat_r_view);
                        chat_r_view.setLayoutManager(new LinearLayoutManager(Chat_toLife.this));
                        chat_r_view.setAdapter(adapter);
                    }
                }

                        @Override
                        public void onCancelled (@NonNull DatabaseError error){

                        }
                    });
                }
            }