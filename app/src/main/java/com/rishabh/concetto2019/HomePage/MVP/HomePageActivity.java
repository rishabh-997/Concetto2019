package com.rishabh.concetto2019.HomePage.MVP;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rishabh.concetto2019.R;

public class HomePageActivity extends AppCompatActivity implements HomePageContract.view
{

    HomePageContract.presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        presenter = new HomePagePresenter(this);
    }
}
