package com.rishabh.concetto2019.EventPage.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
    Animation up, down;

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

        setup();
    }

    private void setup()
    {
        lists.add(new EventPageList("Kamasutra","https://www.github.com/rishabh-997","https://www.github.com/rishabh-997","Rishabh","Kritik","9935685103","6209274679","Prize worth rs 69","https://www.github.com/rishabh-997"));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EventAdapter(this,lists,this, up, down);
        recyclerView.setAdapter(adapter);

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
