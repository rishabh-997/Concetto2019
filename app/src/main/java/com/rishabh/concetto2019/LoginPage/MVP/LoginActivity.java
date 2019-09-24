package com.rishabh.concetto2019.LoginPage.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rishabh.concetto2019.EventPage.MVP.EventContract;
import com.rishabh.concetto2019.EventPage.MVP.EventPresenter;
import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {

    LoginContract.presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        presenter = new LoginPresenter(this);
        ButterKnife.bind(this);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        startActivity(new Intent(this, HomePageActivity.class));
//        overridePendingTransition(R.anim.slidein_to_right,R.anim.slideout_to_right);
//        finish();
//    }
}
