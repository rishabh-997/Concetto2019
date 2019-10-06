package com.rishabh.concetto2019.Contactus;

import android.os.Bundle;
import android.util.Log;

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
    @BindView(R.id.recycler_tech_team)
    RecyclerView recyclerViewTech;
    List<ContactusModel> list = new ArrayList<>();
    List<TechTeamModel> listTech = new ArrayList<>();
    ContactusAdapter adapter;
    TechTeamAdapter adapterTech;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);

        list.add(new ContactusModel("Dr. Annavarapu Chandrashekhara Rao",
                "Convener",
                "+91-9471191414"
                ,"acsrao@iitism.ac.in",
                R.mipmap.acsrao));
        list.add(new ContactusModel("Dr. Raghvendra Kumar Choudhary",
                "Co-Convener",
                "+91-7766907806",
                "raghvendra@iitism.ac.in",
                R.drawable.raghu));
        list.add(new ContactusModel("Prince Kunal",
                "Coordinator",
                "+91-9386667625",
                "princekunal1999@gmail.com",
                R.mipmap.prince_kunal));
        list.add(new ContactusModel("Neelansh Maheshwari",
                "Head Technical",
                "7255929901",
                "neelanshdhan@gmail.com",
                R.drawable.astro_10));
        list.add(new ContactusModel("Ashutosh Jindal",
                "Co-Coordinator",
                "+91-9468858829",
                "aashutj12@gmail.com",
                R.drawable.asuthosh));
        list.add(new ContactusModel("Tarun Kumar",
                "Head Security",
                "8507359111",
                "kumartarun990@gmail.com",
                R.drawable.astro_10));
        list.add(new ContactusModel("Harshit Sethi",
                "Head Promotion",
                "7508120516",
                "harshit8991@gmail.com",
                R.drawable.astro_10));
        list.add(new ContactusModel("Shashwat Raj",
                "Head Public Relation",
                "7903592830",
                "shashwatraj1310@gmail.com",
                R.drawable.astro_10));
        list.add(new ContactusModel("M Vamshi Krishna",
                "Head M&E",
                "9121561571",
                "vamshikrishna.maripudi@gmail.com",
                R.drawable.astro_10));
        list.add(new ContactusModel("Donthula Bharadwaj",
                "Head Designing",
                "9392427427",
                "bharadwajdonthula777@gmail.com",
                R.drawable.astro_10));
        list.add(new ContactusModel("Parth hetam",
                "Head Finance",
                "7209170501",
                "parthhetamsaria@me.iitism.ac.in",
                R.drawable.astro_10));

        Log.i("Pang aphas gaya", ""+list.size());

        adapter = new ContactusAdapter(this,list);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        listTech.add(new TechTeamModel("Shridhar Goel","Member",R.mipmap.shridhargoel));
        listTech.add(new TechTeamModel("Perul Jain","Member",R.mipmap.peruljain));
        listTech.add(new TechTeamModel("Neelansh Maheshwari","Head",R.mipmap.neelansh1));
        listTech.add(new TechTeamModel("Sirigireddy dhana Laxmi","Member",R.mipmap.dhana));

        adapterTech = new TechTeamAdapter(this,listTech);
        recyclerViewTech.setHasFixedSize(true);
        recyclerViewTech.setNestedScrollingEnabled(false);
        recyclerViewTech.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTech.setAdapter(adapterTech);
    }
}
