package com.rishabh.concetto2019.WorkshopPage.MVP;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.TechTalkPage.MVP.TechTalkActivity;
import com.rishabh.concetto2019.TechTalkPage.MVP.TechtalkModel;
import com.rishabh.concetto2019.TechTalkPage.MVP.Techtalkadapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class WorkshopActivity extends AppCompatActivity implements WorkshopContract.view {

    WorkshopContract.presenter presenter;
    WorkshopAdapter workshopAdapter;
    RecyclerView recycler;
    WorkshopModel workshopModel;
    List<WorkshopModel> list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop_page);
        recycler=findViewById(R.id.workshop_recycler);
        getSupportActionBar().hide();
        recycler.setHasFixedSize(false);
        list=new ArrayList<>();
        recycler.setLayoutManager(new LinearLayoutManager(this));

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Workshop");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot db: dataSnapshot.getChildren()){
                    String aboutspeaker = db.child("About").getValue().toString();
                    String date = db.child("Date").getValue().toString();
                    String eventname=db.child("Eventname").getValue().toString();
                    String location=db.child("Location").getValue().toString();
                    String name=db.child("Name").getValue().toString();
                    String link=db.child("Registration link").getValue().toString();
                    String time=db.child("Time").getValue().toString();

                    workshopModel=new WorkshopModel(aboutspeaker,date,time,location,name,link,eventname);
                    list.add(workshopModel);

                }
                workshopAdapter=new WorkshopAdapter(list, WorkshopActivity.this);
                workshopAdapter.notifyDataSetChanged();
                recycler.setAdapter(workshopAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        presenter = new WorkshopPresenter(this);
        ButterKnife.bind(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, HomePageActivity.class));
        overridePendingTransition(R.anim.slidein_to_right,R.anim.slideout_to_right);
        finish();
    }
}
