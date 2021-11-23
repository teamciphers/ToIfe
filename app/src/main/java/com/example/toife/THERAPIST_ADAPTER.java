package com.example.toife;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class THERAPIST_ADAPTER extends RecyclerView.Adapter<THERAPIST_ADAPTER.Viewholder> {

    Context therapist_chat;
    ArrayList<UserHelperClass> usersArrayList;

    public THERAPIST_ADAPTER(therapist_chat Therapist_Chat, ArrayList<UserHelperClass> usersArrayList) {
        this.therapist_chat = Therapist_Chat;
        this.usersArrayList = usersArrayList;
    }


    @NonNull
    @Override
    public THERAPIST_ADAPTER.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(therapist_chat).inflate(R.layout.item_user_row,parent,false);
        return new THERAPIST_ADAPTER.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull THERAPIST_ADAPTER.Viewholder holder, int position) {
        UserHelperClass users = usersArrayList.get(position);

        if(FirebaseAuth.getInstance().getCurrentUser() != null)
            if(usersArrayList.get(position).equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                usersArrayList.remove(usersArrayList.get(position));
            }

        holder.user_name.setText(users.Name1);
        holder.user_status.setText(users.bio_user);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent therapist_chat_start = new Intent(therapist_chat,Therapist_Chat_Activity.class);
                therapist_chat_start.putExtra("name",users.getName1());
                therapist_chat_start.putExtra("uid",users.getuid());
                therapist_chat_start.putExtra("type",users.gettype());
                therapist_chat.startActivity(therapist_chat_start);

            }
        });

    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();

    }

    class Viewholder extends RecyclerView.ViewHolder {
        TextView user_name;
        TextView user_status;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            user_name = itemView.findViewById(R.id.user_name_chat);
            user_status = itemView.findViewById(R.id.user_stat_chat);
        }
    }
}
