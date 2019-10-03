package com.rishabh.concetto2019.Contactus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rishabh.concetto2019.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TechTeamAdapter extends RecyclerView.Adapter<TechTeamAdapter.ViewHolder> {

    Context context;
    List<TechTeamModel> list;

    public TechTeamAdapter(Context context, List<TechTeamModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TechTeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_tech_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TechTeamModel model = list.get(position);
        holder.name.setText(model.getName());
        holder.position.setText(model.getPosition());
        Picasso.get().load(model.getImgResource()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name,position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tech_team);
            position = itemView.findViewById(R.id.tech_tech_team);
            img = itemView.findViewById(R.id.image_tech_team);


        }
    }
}