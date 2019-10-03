package com.rishabh.concetto2019.HomePage.MVP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rishabh.concetto2019.HomePage.Model.ScheduleModel;
import com.rishabh.concetto2019.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScheduleAdapter2 extends RecyclerView.Adapter<ScheduleAdapter2.ViewHolder> {

    List<ScheduleModel> list;
    Context context;

    public ScheduleAdapter2(List<ScheduleModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ScheduleAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_schedule,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter2.ViewHolder holder, int position) {
        ScheduleModel model = list.get(position);
        holder.name.setText(model.getName());
        holder.time.setText(model.getTime());
        holder.place.setText(model.getLocation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,place,time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.schedule_name);
            place = itemView.findViewById(R.id.schedule_place);
            time = itemView.findViewById(R.id.schedule_time);
        }
    }
}
