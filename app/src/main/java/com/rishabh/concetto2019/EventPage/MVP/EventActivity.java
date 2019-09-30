package com.rishabh.concetto2019.EventPage.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rishabh.concetto2019.EventPage.Model.EventPageList;
import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class EventActivity extends AppCompatActivity implements EventContract.view, EventAdapter.OnNoteListener {

    EventContract.presenter presenter;
    List<EventPageList> lists = new ArrayList<>();
    EventAdapter adapter;
    Animation up, down, rotate;
    EventPageList eventPageListlist;
    DatabaseReference databaseReference;

    @BindView(R.id.event_recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventpage);
        presenter = new EventPresenter(this);
        ButterKnife.bind(this);
        up = AnimationUtils.loadAnimation(this,R.anim.slide_up);
        down = AnimationUtils.loadAnimation(this,R.anim.slide_down);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_button);

<<<<<<< HEAD
        setup();
    }

    private void setup()
    {
        lists.add(new EventPageList("Buffet Money","https://www.github.com/rishabh-997","https://www.github.com/rishabh-997","Rishabh","Kritik","9935685103","6209274679","Prize worth rs 5000","https://www.github.com/rishabh-997"));
=======
>>>>>>> e4d653d5577e6b880d003e20588a6ee3f1079fe5
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EventAdapter(this,lists,this, up, down,rotate);

        databaseReference = FirebaseDatabase.getInstance().getReference("Events");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lists.clear();
                for(DataSnapshot db: dataSnapshot.getChildren()){
                    String name = db.child("Name").getValue().toString();
                    String organiser_1 = db.child("Organizer1").getValue().toString();
                    String organiser_2 = db.child("Organizer2").getValue().toString();
                    String organiser_1_phone = db.child("Organizer1 Phone").getValue().toString();
                    String organiser_2_phone = db.child("Organizer2 Phone").getValue().toString();
                    String organisedBy = db.child("Organised By").getValue().toString();
                    String prizes = db.child("Prizes").getValue().toString();
                    String aboutUrl = db.child("About url").getValue().toString();
                    String ruleBookUrl = db.child("Rule Book url").getValue().toString();
                    String registerUrl = db.child("Register url").getValue().toString();

                    eventPageListlist = new EventPageList(name,ruleBookUrl,aboutUrl,organiser_1,organiser_2,organiser_1_phone,organiser_2_phone,prizes,registerUrl);
                    lists.add(eventPageListlist);
                    Log.i("Testing firebase", lists.size()+"");
                }
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, HomePageActivity.class));
        overridePendingTransition(R.anim.slidein_to_right,R.anim.slideout_to_right);
        finish();
    }

    @Override
    public void onRuleClick(int position) {
        /**
         * dekha do rule book
         */



    }

    @Override
    public void onAboutClick(int position) {
        /**
         * dikha do about us
         */
    }

    @Override
    public void onRegisterClick(int position) {
        /**
         * kara do register
         */
    }
}
