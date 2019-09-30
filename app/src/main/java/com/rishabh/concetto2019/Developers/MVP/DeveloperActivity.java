package com.rishabh.concetto2019.Developers.MVP;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rishabh.concetto2019.Developers.Model.Developers;
import com.rishabh.concetto2019.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DeveloperActivity extends AppCompatActivity implements DeveloperAdapter.onNoteClickListener
{
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.kritik_github)
    ImageView kritikgit;
    @BindView(R.id.kritik_linkedin)
    ImageView kritiklinked;


    List<Developers> list = new ArrayList<>();
    DeveloperAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        ButterKnife.bind(this);

        list.add(new Developers("Rishabh Agarwal","https://github.com/rishabh-997","https://www.linkedin.com/in/rishabh-997/","Mathematics and Commputing",R.drawable.rishabh));
        list.add(new Developers("Apoorva Raj Bhadani","https://github.com/ApoorvaRajBhadani","https://www.linkedin.com/in/apoorva222g","Mathematics and Commputing",R.drawable.astro_12));
        list.add(new Developers("Rishabh Agarwal","https://github.com/rishabh-997","https://linkedin.com/rishabh-997","Mathematics and Commputing",R.drawable.astro_12));
        list.add(new Developers("Rishabh Agarwal","https://github.com/rishabh-997","https://linkedin.com/rishabh-997","Mathematics and Commputing",R.drawable.astro_12));

        adapter = new DeveloperAdapter(this,list,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        kritikgit.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/kritikgarg1"));
            startActivity(intent);
        });
        kritiklinked.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/kritik-garg-a481a3175"));
            startActivity(intent);
        });
    }

    @Override
    public void onGitClick(int position) {
        String url = list.get(position).getGithub();
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void onLinkedClick(int position) {
        String url = list.get(position).getLinkedIn();
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}