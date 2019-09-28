package com.rishabh.concetto2019.Developers.MVP;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rishabh.concetto2019.Developers.Model.Developers;
import com.rishabh.concetto2019.R;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {

    Context context;
    List<Developers> list;

    public DeveloperAdapter(Context context, List<Developers> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DeveloperAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_developer,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeveloperAdapter.ViewHolder holder, int position)
    {
        Developers model = list.get(position);
        holder.dev_name.setText(model.getName());
        holder.dev_branch.setText(model.getBranch());
        holder.dev_image.setImageResource(model.getId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView dev_image,dev_git, dev_linkedin;
        TextView dev_name,dev_branch;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            dev_name = itemView.findViewById(R.id.dev_name);
            dev_branch = itemView.findViewById(R.id.dev_branch);
            dev_git = itemView.findViewById(R.id.dev_github);
            dev_linkedin = itemView.findViewById(R.id.dev_linkedin);
            dev_image = itemView.findViewById(R.id.dev_image);
        }
    }
}
