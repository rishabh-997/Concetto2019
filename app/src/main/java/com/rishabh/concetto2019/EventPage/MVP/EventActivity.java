package com.rishabh.concetto2019.EventPage.MVP;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.rishabh.concetto2019.EventPage.Model.EventImageModel;
import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import timber.log.Timber;

public class EventActivity extends AppCompatActivity implements EventContract.view {

    EventContract.presenter presenter;
    private EventImageAdapter adapter;
    private ArrayList<EventImageModel> games = new ArrayList<>();

//    @BindView(R.id.coverflow)
//    FeatureCoverFlow coverFlow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventpage);
        presenter = new EventPresenter(this);
        ButterKnife.bind(this);

       // setup();
    }

//    private void setup()
//    {
//        settingDummyData();
//        coverFlow.setOnScrollPositionListener(onScrollListener());
//        adapter = new EventImageAdapter(this, games);
//        coverFlow.setAdapter(adapter);
//    }


//    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
//        return new FeatureCoverFlow.OnScrollPositionListener() {
//            @SuppressLint("BinaryOperationInTimber")
//            @Override
//            public void onScrolledToPosition(int position) {
//                Timber.tag("MainActiivty").v("position: " + position);
//            }
//
//            @Override
//            public void onScrolling() {
//                Timber.i("scrolling");
//            }
//        };
//    }
//
//    private void settingDummyData() {
//        games.add(new EventImageModel(R.drawable.meat_balls_min, " Event1"));
//        games.add(new EventImageModel(R.drawable.no_internet, " Event2"));
//        games.add(new EventImageModel(R.drawable.veg_icon, " Event3"));
//    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, HomePageActivity.class));
        overridePendingTransition(R.anim.slidein_to_right,R.anim.slideout_to_right);
        finish();
    }
}
