package com.rishabh.concetto2019.Informals.MVP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rishabh.concetto2019.Informals.Model.InformalModel;
import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.WorkshopPage.MVP.WorkshopAdapter;

import java.util.List;

public class InformalAdapter extends RecyclerView.Adapter<InformalAdapter.ViewHolder>
{
    List<InformalModel> list;
    Context context;
    Animation up,down,rotate;

    public InformalAdapter(List<InformalModel> list, Context context, Animation up, Animation down, Animation rotate) {
        this.list = list;
        this.context = context;
        this.up = up;
        this.down = down;
        this.rotate = rotate;
    }

    @NonNull
    @Override
    public InformalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_informal,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InformalAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
