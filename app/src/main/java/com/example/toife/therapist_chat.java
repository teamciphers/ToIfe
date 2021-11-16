package com.example.toife;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class therapist_chat extends AppCompatActivity {

    TextView username;
    String type;
    RecyclerView chat_r_view;
    THERAPIST_ADAPTER adapter;
    FirebaseDatabase database;
    FirebaseAuth auth;
    DatabaseReference reference_forUseres,reference_forTherapist,reference;
    ArrayList<UserHelperClass> usersArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist_chat);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        //to get type of user

        reference = FirebaseDatabase.getInstance().getReference("All_data");
        Query checkUser = reference.orderByChild("uid").equalTo(auth.getUid());

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    type = dataSnapshot.child(auth.getUid()).child("type").getValue(String.class);
                    System.out.println("hello1 " + type);
                    reference_forTherapist = database.getReference().child("Therapy").child(auth.getUid());
                    reference_forUseres = database.getReference().child("Therapist");

                    usersArrayList = new ArrayList<>();

                    if(type.equals("therapist")){

                        reference_forTherapist.addValueEventListener(new ValueEventListener() {
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


                    }else{

                        reference_forUseres.addValueEventListener(new ValueEventListener() {
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


                    }



                    adapter = new THERAPIST_ADAPTER(therapist_chat.this,usersArrayList);
                    chat_r_view = findViewById(R.id.therapist_chat_r_view);
                    chat_r_view.setLayoutManager(new LinearLayoutManager(therapist_chat.this));
                    chat_r_view.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        System.out.println("hello "+type);

        //end



    }
}