package com.rishabh.concetto2019.WorkshopPage.MVP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.WorkshopPage.Model.WorkshopModel;

import java.util.List;

public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.ViewHolder> {

    List<WorkshopModel> list;
    Context context;

    public WorkshopAdapter(List<WorkshopModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public WorkshopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_workshop,parent,false);
        return new WorkshopAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull WorkshopAdapter.ViewHolder holder, int position) {
//        holder.about.setText(list.get(position).getAbout());
//        holder.link.setText(list.get(position).getRegistration());
//        holder.time.setText(list.get(position).getTime());
//        holder.date.setText(list.get(position).getDate());
//        holder.location.setText(list.get(position).getLocation());
//        holder.name.setText(list.get(position).getName());
//        holder.eventname.setText(list.get(position).getEventname());




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView about,date,eventname,name,time,location,link;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
