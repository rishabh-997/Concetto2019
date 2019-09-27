package com.rishabh.concetto2019.EventPage.MVP;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rishabh.concetto2019.EventPage.Model.EventImageModel;
import com.rishabh.concetto2019.R;

import java.util.ArrayList;

public class EventImageAdapter extends BaseAdapter {

    private ArrayList<EventImageModel> list;
    private AppCompatActivity context;

    public EventImageAdapter(AppCompatActivity context, ArrayList<EventImageModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public EventImageModel getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.eventimagelayout, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.gameImage.setImageResource(list.get(position).getImageSource());
        viewHolder.gameName.setText(list.get(position).getName());
        convertView.setOnClickListener(onClickListener(position));
        return convertView;
    }

    private View.OnClickListener onClickListener(final int position) {
        return v -> {
            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.dialog_event_image);
            dialog.setCancelable(true); // dimiss when touching outside
            dialog.setTitle("Event Details");

            TextView text = dialog.findViewById(R.id.eventname3);
            text.setText(getItem(position).getName());
            ImageView image = dialog.findViewById(R.id.eventimage3);
            image.setImageResource(getItem(position).getImageSource());

            dialog.show();
        };
    }


    private static class ViewHolder {
        private TextView gameName;
        private ImageView gameImage;

        public ViewHolder(View v) {
            gameImage = v.findViewById(R.id.eventimage2);
            gameName = v.findViewById(R.id.eventname2);
        }
    }
}

