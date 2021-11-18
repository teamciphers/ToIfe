package com.example.toife;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toife.Adaptr.MessageAdaptr;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends AppCompatActivity {

    String ReciverName,ReciverUid,SenderUid,degree,Name1,email1,pass1;
    TextView Reciver_name;
    CardView sendbtn;
    EditText editmesg;
    FirebaseAuth mAuth;
    FirebaseDatabase database;

    String senderRoom,reciverRoom;

    RecyclerView msgAdapter;

    ArrayList<Messages> msgArrayList ;

    MessageAdaptr Adaptr;
    private UserHelperClass uhc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ReciverName = getIntent().getStringExtra("name");
        ReciverUid = getIntent().getStringExtra("uid");
        degree = getIntent().getStringExtra("degrees");


        Reciver_name = findViewById(R.id.Reciver_name);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        sendbtn= findViewById(R.id.sendbtn);
        editmesg= findViewById(R.id.edtMessage);

        Reciver_name.setText("" + ReciverName);

        SenderUid = mAuth.getUid();
        senderRoom = SenderUid + ReciverUid;
        reciverRoom = ReciverUid + SenderUid;

        msgArrayList = new ArrayList<>();


        DatabaseReference chatReference = database.getReference().child("chats").child(senderRoom).child("messages");


        chatReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                msgArrayList.clear();


                for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Messages messages = dataSnapshot.getValue(Messages.class);
                    msgArrayList.add(messages);
                    System.out.println(msgArrayList);

                }
                Adaptr.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        msgAdapter = findViewById(R.id.messageAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChatActivity.this);
        linearLayoutManager.setStackFromEnd(true);
        msgAdapter.setLayoutManager(linearLayoutManager);
        Adaptr = new MessageAdaptr(ChatActivity.this,msgArrayList);
        msgAdapter.setAdapter(Adaptr);
        System.out.println(msgArrayList);




        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editmesg.getText().toString();

                if(message.isEmpty()){

                    Toast.makeText(ChatActivity.this,"Please enter a message to send",Toast.LENGTH_SHORT).show();
                    return;
                }

                //new
                System.out.println(degree);
                if(degree.equals("None-minimal")) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
                    Query checkUser = reference.orderByChild("uid").equalTo(mAuth.getUid());
                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                Name1 = dataSnapshot.child(mAuth.getUid()).child("name1").getValue(String.class);
                                email1 = dataSnapshot.child(mAuth.getUid()).child("email1").getValue(String.class);
                                pass1 = dataSnapshot.child(mAuth.getUid()).child("pass1").getValue(String.class);


                            }
                            DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("User_chat2").child(ReciverUid);
                            String bio = "";
                            String type = "";
                            uhc = new UserHelperClass(Name1, email1, pass1, SenderUid,type,bio,degree);
                            reference1.child(mAuth.getUid()).setValue(uhc);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

                //end
                editmesg.setText("");
                Date date = new Date();

                Messages messages = new Messages(message,SenderUid,date.getTime());
                database = FirebaseDatabase.getInstance();

                database.getReference().child("chats").child(senderRoom).child("messages").push().setValue(messages)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                database.getReference().child("chats").child(reciverRoom).child("messages").push().setValue(messages)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                    }
                                });
                            }
                        });
            }
        });
    }
}