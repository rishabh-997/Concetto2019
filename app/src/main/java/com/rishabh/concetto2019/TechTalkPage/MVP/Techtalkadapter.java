package com.rishabh.concetto2019.TechTalkPage.MVP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rishabh.concetto2019.R;

import java.nio.channels.ReadableByteChannel;
import java.util.List;

public class Techtalkadapter extends RecyclerView.Adapter<Techtalkadapter.ViewHolder> {

    List<TechtalkModel> list;
    Context context;

    public Techtalkadapter(List<TechtalkModel> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.card_techtalk,parent,false);
     return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.about.setText(list.get(position).getAboutSpeaker());
        holder.field.setText(list.get(position).getField());
        holder.time.setText(list.get(position).getTime());
        holder.date.setText(list.get(position).getDate());
        holder.location.setText(list.get(position).getLocation());
        holder.name.setText(list.get(position).getName());




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView about,field,time,date,location,name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //findviewbyid work

        }
    }
}
