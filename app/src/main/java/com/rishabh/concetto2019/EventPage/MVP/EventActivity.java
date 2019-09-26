package com.rishabh.concetto2019.EventPage.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rishabh.concetto2019.Authentication.LogInPage.MVP.LoginActivity;
import com.rishabh.concetto2019.Authentication.SignUpPage.MVP.SignupActivity;
import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventActivity extends AppCompatActivity implements EventContract.view {

    @BindView(R.id.loginactbtn)
    Button loginbtn;
    @BindView(R.id.signupactbtn)
    Button signupactbtn;


    EventContract.presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventpage);

        presenter = new EventPresenter(this);
        ButterKnife.bind(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginact = new Intent(EventActivity.this, LoginActivity.class);
                startActivity(loginact);
            }
        });

        signupactbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginact = new Intent(EventActivity.this, SignupActivity.class);
                startActivity(loginact);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, HomePageActivity.class));
        overridePendingTransition(R.anim.slidein_to_right,R.anim.slideout_to_right);
        finish();
    }
}
