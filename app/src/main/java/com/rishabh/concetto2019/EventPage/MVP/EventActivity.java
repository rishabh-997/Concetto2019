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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventpage);
        presenter = new EventPresenter(this);
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
