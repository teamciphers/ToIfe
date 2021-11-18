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

public class USER_ADAPTER extends RecyclerView.Adapter<USER_ADAPTER.Viewholder> {

    Context Chat_toLife;
    ArrayList<UserHelperClass> usersArrayList;

    public USER_ADAPTER(Chat_toLife chat_toLife, ArrayList<UserHelperClass> usersArrayList) {
        this.Chat_toLife = chat_toLife;
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Chat_toLife).inflate(R.layout.item_user_row,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        UserHelperClass users = usersArrayList.get(position);

        if(FirebaseAuth.getInstance().getCurrentUser() != null)
            if(usersArrayList.get(position).equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                usersArrayList.remove(usersArrayList.get(position));
            }
        //new
        if (FirebaseAuth.getInstance().getCurrentUser() != null){
            if(users.degrees.equals("Mild") || users.degrees.equals("Moderate") || users.degrees.equals("Moderately Severe")) {
                usersArrayList.remove(usersArrayList.get(position));

            }

        }//end

        holder.user_name.setText(users.Name1);
        holder.user_status.setText(users.bio_user);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent chat_start = new Intent(Chat_toLife,ChatActivity.class);
                chat_start.putExtra("name",users.getName1());
                chat_start.putExtra("uid",users.getuid());
                chat_start.putExtra("degrees",users.getdegrees());
                Chat_toLife.startActivity(chat_start);

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
