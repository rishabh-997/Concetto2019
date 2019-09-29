package com.rishabh.concetto2019.Profile.MVP;

import android.os.Bundle;

import com.rishabh.concetto2019.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.view
{
    ProfileContract.presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        presenter = new ProfilePresenter(this);
        ButterKnife.bind(this);
    }
}
