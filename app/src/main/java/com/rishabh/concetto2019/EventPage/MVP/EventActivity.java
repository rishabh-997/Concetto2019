package com.rishabh.concetto2019.EventPage.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.rishabh.concetto2019.EventPage.Model.EventPageList;
import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class EventActivity extends AppCompatActivity implements EventContract.view, EventAdapter.OnNoteListener ,NavigationView.OnNavigationItemSelectedListener{

    EventContract.presenter presenter;
    List<EventPageList> lists = new ArrayList<>();
    EventAdapter adapter;
    Animation up, down, rotate;
    NavigationView navigationView;
    EventPageList eventPageListlist;
    DatabaseReference databaseReference;
    DrawerLayout drawer;
    @BindView(R.id.event_recycler)
    RecyclerView recyclerView;
    ActionBarDrawerToggle toggle;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventpage);

        drawer = findViewById(R.id.drawerlayout2);
        navigationView = findViewById(R.id.vNavigation2);
        toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        presenter = new EventPresenter(this);
        ButterKnife.bind(this);
        up = AnimationUtils.loadAnimation(this,R.anim.slide_up);
        down = AnimationUtils.loadAnimation(this,R.anim.slide_down);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_button);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
            if(id== R.id.menu_cse) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        lists.clear();
                        adapter.notifyDataSetChanged();
                        for (DataSnapshot db : dataSnapshot.getChildren()) {
                            if (db.child("Organized By").getValue().toString().equals("Computer Science")) {
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

                                eventPageListlist = new EventPageList(name, ruleBookUrl, aboutUrl, organiser_1, organiser_2, organiser_1_phone, organiser_2_phone, prizes, registerUrl);
                                lists.add(eventPageListlist);
                            }
                            Log.i("Testing firebase", lists.size() + "");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
            else if(id== R.id.menu_mnc) {
                Toast.makeText(this, "hhh", Toast.LENGTH_SHORT).show();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        lists.clear();
                        Toast.makeText(EventActivity.this, "jjjjj", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                        for (DataSnapshot db : dataSnapshot.getChildren()) {
                            if (db.child("Organized By").getValue().toString().equals("Mathematics and Computing")) {
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

                                eventPageListlist = new EventPageList(name, ruleBookUrl, aboutUrl, organiser_1, organiser_2, organiser_1_phone, organiser_2_phone, prizes, registerUrl);
                                lists.add(eventPageListlist);
                            }
                            Log.i("Testing firebase", lists.size() + "");
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }




        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
            return super.onOptionsItemSelected(item);
    }
}
