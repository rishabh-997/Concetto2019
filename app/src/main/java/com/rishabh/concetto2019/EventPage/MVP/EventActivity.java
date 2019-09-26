package com.rishabh.concetto2019.EventPage.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class EventActivity extends AppCompatActivity implements EventContract.view {

    EventContract.presenter presenter;
    private EventImageAdapter adapter;
    private ArrayList<EventImageModel> games;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventpage);
        FeatureCoverFlow coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);

        settingDummyData();
        coverFlow.setOnScrollPositionListener(onScrollListener());
        adapter = new EventImageAdapter(this, games);
        coverFlow.setAdapter(adapter);

        presenter = new EventPresenter(this);
        ButterKnife.bind(this);
    }


    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
            }
        };
    }

    private void settingDummyData() {
        games = new ArrayList<>();
        games.add(new EventImageModel(R.drawable.meat_balls_min, " Event1"));
        games.add(new EventImageModel(R.drawable.no_internet, " Event2"));
        games.add(new EventImageModel(R.drawable.veg_icon, " Event3"));




    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, HomePageActivity.class));
        overridePendingTransition(R.anim.slidein_to_right,R.anim.slideout_to_right);
        finish();
    }
}
