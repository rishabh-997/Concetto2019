package com.rishabh.concetto2019.Developers.MVP;

import android.os.Bundle;

import com.rishabh.concetto2019.Developers.Model.Developers;
import com.rishabh.concetto2019.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class DeveloperActivity extends AppCompatActivity
{
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    List<Developers> list = new ArrayList<>();
    DeveloperAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        list.add(new Developers("Rishabh Agarwal","https://github.com/rishabh-997","https://linkedin.com/rishabh-997","Mathematics and Commputing",R.drawable.astro_12));

        adapter = new DeveloperAdapter(this,list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
