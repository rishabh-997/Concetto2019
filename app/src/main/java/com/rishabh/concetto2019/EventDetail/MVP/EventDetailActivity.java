package com.rishabh.concetto2019.EventDetail.MVP;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rishabh.concetto2019.R;

import butterknife.ButterKnife;

public class EventDetailActivity extends AppCompatActivity implements EventDetailContract.view {

    EventDetailContract.presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetailpage);

        presenter = new EventDetailPresenter(this);
        ButterKnife.bind(this);
    }
}
