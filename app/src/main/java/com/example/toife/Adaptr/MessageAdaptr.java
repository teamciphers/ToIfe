package com.example.toife.Adaptr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toife.Messages;
import com.example.toife.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MessageAdaptr extends RecyclerView.Adapter {

    Context context;
    ArrayList<Messages> msgArrayList;
    int Item_Send = 1;
    int Item_Recive = 2;

    public MessageAdaptr(Context context, ArrayList<Messages> msgArrayList) {
        this.context = context;
        this.msgArrayList = msgArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==Item_Send){

            View view = LayoutInflater.from(context).inflate(R.layout.sender_layout_item,parent,false);
            return new SenderViewHolder(view);
        }else{
            View view = LayoutInflater.from(context).inflate(R.layout.reciver_layout_item,parent,false);
            return new ReciverViewHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Messages messages = msgArrayList.get(position);

        if (holder.getClass() == SenderViewHolder.class){

            SenderViewHolder viewHolder = (SenderViewHolder) holder;

            viewHolder.txtmessage.setText(messages.getMessage());

        }else{

            ReciverViewHolder viewHolder = (ReciverViewHolder) holder;

            viewHolder.txtmessage.setText(messages.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return msgArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Messages messages = msgArrayList.get(position);
        if(FirebaseAuth.getInstance().getCurrentUser().getUid().equals(messages.getSendrid())){

            return Item_Send;
        }else{
            return Item_Recive;
        }
    }

    class SenderViewHolder extends RecyclerView.ViewHolder {
        TextView txtmessage;
        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);

            txtmessage = itemView.findViewById(R.id.txtMessages);
        }
    }

    class ReciverViewHolder extends RecyclerView.ViewHolder {
        TextView txtmessage;
        public ReciverViewHolder(@NonNull View itemView) {
            super(itemView);

            txtmessage = itemView.findViewById(R.id.txtMessages);


        }
    }
}
