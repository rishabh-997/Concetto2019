package com.rishabh.concetto2019.TechTalkPage.MVP;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
