package com.rishabh.concetto2019.TechTalkPage.MVP;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.TechTalkPage.Model.TechtalkModel;

import java.util.List;

import static com.rishabh.concetto2019.R.id.field;

public class Techtalkadapter extends RecyclerView.Adapter<Techtalkadapter.ViewHolder> {

    List<TechtalkModel> list;
    Context context;

    Animation up, down, rotate;
    public Techtalkadapter(List<TechtalkModel> list, Context context, Animation up, Animation down, Animation rotate) {

        this.list = list;
        this.context = context;
        this.up=up;
        this.down = down;
        this.rotate=rotate;
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
        holder.date.setText(list.get(position).getDate());
        holder.date.append("\n" + list.get(position).getTime());
        holder.location.setText(list.get(position).getLocation());
        holder.name.setText(list.get(position).getName());

        holder.arrow.setOnClickListener(v -> {

            if (holder.constraintLayout.isShown()) {
                holder.constraintLayout.startAnimation(up);

                CountDownTimer countDownTimerStatic = new CountDownTimer(500, 16) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        holder.constraintLayout.setVisibility(View.GONE);
                        holder.arrow.startAnimation(rotate);
                    }
                };
                countDownTimerStatic.start();

            } else {
                holder.constraintLayout.setVisibility(View.VISIBLE);
                holder.arrow.startAnimation(rotate);
                holder.constraintLayout.startAnimation(down);
            }

        });






    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView about,field,time,date,location,name;
         ImageView arrow;
         ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            about =itemView.findViewById(R.id.event_about);

            field = itemView.findViewById(R.id.field);
            date = itemView.findViewById(R.id.time);
            location = itemView.findViewById(R.id.location);
            name = itemView.findViewById(R.id.event_name);
            arrow = itemView.findViewById(R.id.event_arrow);
            constraintLayout = itemView.findViewById(R.id.collapsable_layout);



        }
    }
}
