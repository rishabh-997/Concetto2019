package com.rishabh.concetto2019.Contactus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.rishabh.concetto2019.Contactus.ContactusModel;
import com.rishabh.concetto2019.R;
import java.util.List;

public class ContactusAdapter extends RecyclerView.Adapter<ContactusAdapter.ViewHolder>
{

    Context context;
    List<ContactusModel> list;

    public ContactusAdapter(Context context, List<ContactusModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ContactusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_contactus,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactusAdapter.ViewHolder holder, int position) {
        ContactusModel model=list.get(position);
        holder.d_name.setText(model.getD_name());
        holder.d_telephone_number.setText(model.getD_telephone_number());
        holder.d_mail_id.setText(model.getD_mail_id());
        holder.d_ing.setImageResource(model.getId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView d_ing,d_img_envelop,d_img_telephone;
        TextView d_telephone_number,d_mail_id,d_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            d_name=itemView.findViewById(R.id.d_name);
            d_telephone_number=itemView.findViewById(R.id.d_telephone_number);
            d_mail_id=itemView.findViewById(R.id.d_mail_id);
            d_ing=itemView.findViewById(R.id.d_image1);
            d_img_telephone=itemView.findViewById(R.id.d_telephone);
            d_img_envelop=itemView.findViewById(R.id.d_envelop_shape);
        }
    }
}
