package com.rishabh.concetto2019.EventPage.MVP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rishabh.concetto2019.EventDetail.Model.EventDetailList;
import com.rishabh.concetto2019.EventPage.Model.EventPageList;
import com.rishabh.concetto2019.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    Context context;
    List<EventPageList> list;
    OnNoteListener onNoteListener;

    public EventAdapter(Context context, List<EventPageList> list, OnNoteListener onNoteListener) {
        this.context = context;
        this.list = list;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_event_page,parent,false);
        return new ViewHolder(view, onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        OnNoteListener listener;
        public ViewHolder(@NonNull View itemView, OnNoteListener listener)
        {
            super(itemView);
            this.listener = listener;
        }
    }

    public interface OnNoteListener{

    }
}
