package com.rishabh.concetto2019.Informals.MVP;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

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
import com.rishabh.concetto2019.Informals.Model.InformalModel;
import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.WorkshopPage.MVP.WorkshopActivity;
import com.rishabh.concetto2019.WorkshopPage.MVP.WorkshopAdapter;
import com.rishabh.concetto2019.WorkshopPage.Model.WorkshopModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InformalActivity extends AppCompatActivity
{
    @BindView(R.id.informal_recycler)
    RecyclerView recyclerView;

    Animation up, down, rotate;

    InformalAdapter adapter;
    List<InformalModel> list = new ArrayList<>();
    InformalModel model;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("informal");
    ProgressDialog progress;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_informal);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        up = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        down = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_button);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progress=new ProgressDialog(this);
        progress.setMessage(" Loading Events");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();

        reference.addValueEventListener(new ValueEventListener() {
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
                    String url =db.child("image url").getValue().toString();

                    model=new InformalModel(aboutspeaker,date,time,location,name,link,eventname,url);
                    list.add(model);
                }
                progress.dismiss();
                adapter=new InformalAdapter(list, InformalActivity.this,up,down,rotate);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
