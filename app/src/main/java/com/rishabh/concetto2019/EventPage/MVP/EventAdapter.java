package com.rishabh.concetto2019.EventPage.MVP;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.rishabh.concetto2019.EventPage.Model.EventPageList;
import com.rishabh.concetto2019.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.http.HEAD;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    Context context;
    List<EventPageList> list;
    OnNoteListener onNoteListener;
    Animation up, down, rotate;

    public EventAdapter(Context context, List<EventPageList> list, OnNoteListener onNoteListener, Animation up, Animation down, Animation rotate) {
        this.context = context;
        this.list = list;
        this.onNoteListener = onNoteListener;
        this.up = up;
        this.down = down;
        this.rotate = rotate;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_event_page,parent,false);
        return new ViewHolder(view, onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {
        EventPageList model = list.get(position);

        holder.event_name.setText(model.getEvent_name());
        holder.organizer_name1.setText(model.getOrganizer_name1());
        holder.organizer_name2.setText(model.getOrganizer_name2());
        holder.organizer_phone1.setText(model.getOrganizer_phone1());
        holder.organizer_phone2.setText(model.getOrganizer_phone2());
        holder.prize.setText(model.getPrize());
        Picasso.get().load(model.getUrl()).into(holder.cover_pic);




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

        holder.cover_pic.setOnClickListener(v -> {

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

        holder.event_name.setOnClickListener(v -> {

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

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        OnNoteListener listener;

        TextView event_name, rule_book, about;
        TextView organizer_name1,organizer_name2;
        TextView organizer_phone1, organizer_phone2;
        TextView prize;
        TextView register_url;
        ImageView arrow;
        ImageView cover_pic;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView, OnNoteListener listener)
        {
            super(itemView);
            this.listener = listener;
            event_name = itemView.findViewById(R.id.event_name);
            rule_book = itemView.findViewById(R.id.rule_book);
            about = itemView.findViewById(R.id.event_about);
            arrow = itemView.findViewById(R.id.event_arrow);
            organizer_name1 = itemView.findViewById(R.id.event_contact_name1);
            organizer_name2 = itemView.findViewById(R.id.event_contact_name2);
            organizer_phone1 = itemView.findViewById(R.id.event_contact_phone1);
            organizer_phone2 = itemView.findViewById(R.id.event_contact_phone2);
            prize = itemView.findViewById(R.id.event_prize);
            register_url = itemView.findViewById(R.id.event_register);
            cover_pic = itemView.findViewById(R.id.event_cover);
            constraintLayout = itemView.findViewById(R.id.collapsable_layout);

            rule_book.setOnClickListener(v -> listener.onRuleClick(getAdapterPosition()));
            about.setOnClickListener(v -> listener.onAboutClick(getAdapterPosition()));
            register_url.setOnClickListener(v -> listener.onRegisterClick(getAdapterPosition()));
        }
    }

    public interface OnNoteListener{

        void onRuleClick(int position);
        void onAboutClick(int position);
        void onRegisterClick(int position);

    }
}
