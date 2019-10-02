package com.rishabh.concetto2019.EventPage.MVP;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rishabh.concetto2019.EventPage.Model.EventPageList;
import com.rishabh.concetto2019.R;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventActivityNew extends AppCompatActivity
        implements EventContract.view, EventAdapter.OnNoteListener, NavigationView.OnNavigationItemSelectedListener {
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
    @BindView(R.id.openDrawer)
    ImageView openDrawer;
    @BindView(R.id.leftclick)
    ImageView leftclick;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_new);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progress=new ProgressDialog(this);
        progress.setMessage(" Loading Events");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        presenter = new EventPresenter(this);
        ButterKnife.bind(this);

        leftclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });


        navigationView.setNavigationItemSelectedListener(this);
        up = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        down = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_button);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EventAdapter(this, lists, this, up, down, rotate);

        databaseReference = FirebaseDatabase.getInstance().getReference("Events");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lists.clear();
                for (DataSnapshot db : dataSnapshot.getChildren()) {
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

                    eventPageListlist = new EventPageList(name, ruleBookUrl, aboutUrl, organiser_1, organiser_2, organiser_1_phone, organiser_2_phone, prizes, registerUrl,organisedBy);
                    lists.add(eventPageListlist);
                    Log.i("Testing firebase", lists.size() + "");
                }
                progress.dismiss();
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    void  filter(String a){
        int n=lists.size();
        List<EventPageList> listnew=new ArrayList<>();
        for(int i=0; i<n; i++ ){
            if(lists.get(i).getOrganisedBy().equals(a)){
                String name = lists.get(i).getEvent_name().toString();
                String organiser_1 = lists.get(i).getOrganizer_name1().toString();
                String organiser_2 = lists.get(i).getOrganizer_name2().toString();
                String organiser_1_phone = lists.get(i).getOrganizer_phone1().toString();
                String organiser_2_phone = lists.get(i).getOrganizer_phone2().toString();
                String organisedBy = lists.get(i).getOrganisedBy().toString();
                String prizes =lists.get(i).getPrize().toString();
                String aboutUrl = lists.get(i).getAbout_url().toString();
                String ruleBookUrl = lists.get(i).getRule_book_url().toString();
                String registerUrl = lists.get(i).getRegister_url().toString();

                eventPageListlist = new EventPageList(name, ruleBookUrl, aboutUrl, organiser_1, organiser_2, organiser_1_phone, organiser_2_phone, prizes, registerUrl,organisedBy);
                listnew.add(eventPageListlist);



            }
            adapter = new EventAdapter(EventActivityNew.this, listnew, EventActivityNew.this, up, down, rotate);

            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.event_activity_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.all){

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    lists.clear();
                    for (DataSnapshot db : dataSnapshot.getChildren()) {
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

                        eventPageListlist = new EventPageList(name, ruleBookUrl, aboutUrl, organiser_1, organiser_2, organiser_1_phone, organiser_2_phone, prizes, registerUrl,organisedBy);
                        lists.add(eventPageListlist);
                        Log.i("Testing firebase", lists.size() + "");
                    }
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (id == R.id.cse) {
            filter("computer Science and Engineering");

        } else if (id == R.id.mnc) {
             filter("Mathematics and Computing");
        } else if (id == R.id.petro) {

        } else if (id == R.id.ei) {

        } else if (id == R.id.ece) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onRuleClick(int position) {
        Uri uri = Uri.parse(lists.get(position).getRule_book_url()); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    @Override
    public void onAboutClick(int position) {

    }

    @Override
    public void onRegisterClick(int position) {
      //  Toast.makeText(this, "working", Toast.LENGTH_SHORT).show();
        Uri uri = Uri.parse(lists.get(position).getRegister_url()); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
}
