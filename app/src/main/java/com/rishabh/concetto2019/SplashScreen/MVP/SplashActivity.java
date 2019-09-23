package com.rishabh.concetto2019.SplashScreen.MVP;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rishabh.concetto2019.R;

public class SplashActivity extends AppCompatActivity implements SplashContract.view {

    SplashContract.presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(this);
    }
}
