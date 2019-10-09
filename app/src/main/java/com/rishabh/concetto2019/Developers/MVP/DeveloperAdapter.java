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
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {

    Context context;
    List<Developers> list;
    onNoteClickListener onNoteClickListener;


    public DeveloperAdapter(Context context, List<Developers> list, onNoteClickListener listener) {
        this.context = context;
        this.list = list;
        this.onNoteClickListener = listener;
    }

    @NonNull
    @Override
    public DeveloperAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_developer,parent,false);
        return new ViewHolder(view, onNoteClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DeveloperAdapter.ViewHolder holder, int position)
    {
        Developers model = list.get(position);
        holder.dev_name.setText(model.getName());
        holder.dev_branch.setText(model.getBranch());
        Picasso.get()
                .load(model.getId())
                .resizeDimen(R.dimen.resize_image,R.dimen.resize_image)
                .centerCrop()
                .into(holder.dev_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView dev_image,dev_git, dev_linkedin;
        TextView dev_name,dev_branch;
        onNoteClickListener listener;

        public ViewHolder(@NonNull View itemView, onNoteClickListener listener)
        {
            super(itemView);
            this.listener = listener;
            dev_name = itemView.findViewById(R.id.dev_name);
            dev_branch = itemView.findViewById(R.id.dev_branch);
            dev_git = itemView.findViewById(R.id.dev_github);
            dev_linkedin = itemView.findViewById(R.id.dev_linkedin);
            dev_image = itemView.findViewById(R.id.dev_image);

            dev_git.setOnClickListener(v -> listener.onGitClick(getAdapterPosition()));
            dev_linkedin.setOnClickListener(v -> listener.onLinkedClick(getAdapterPosition()));
        }
    }

    public interface onNoteClickListener
    {
        void onGitClick(int position);
        void onLinkedClick(int position);
    }
}
