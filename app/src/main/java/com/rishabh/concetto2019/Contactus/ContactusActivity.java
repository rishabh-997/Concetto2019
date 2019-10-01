package com.rishabh.concetto2019.Contactus;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rishabh.concetto2019.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactusActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<ContactusModel> list = new ArrayList<>();
    ContactusAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);

        list.add(new ContactusModel("Rishabh Agarwal","78945643654","vhdgjvjvhihjn@gmail.com",R.drawable.rishabh));
        list.add(new ContactusModel("Rishabh Agarwal","78945643654","vhdgjvjvhihjn@gmail.com",R.drawable.rishabh));
        list.add(new ContactusModel("Rishabh Agarwal","78945643654","vhdgjvjvhihjn@gmail.com",R.drawable.rishabh));
        list.add(new ContactusModel("Rishabh Agarwal","78945643654","vhdgjvjvhihjn@gmail.com",R.drawable.rishabh));

        adapter = new ContactusAdapter(this,list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
