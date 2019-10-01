package com.rishabh.concetto2019.SplashScreen.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.rishabh.concetto2019.Authentication.LogInPage.MVP.LoginActivity;
import com.rishabh.concetto2019.Authentication.SignUpPage.MVP.SignupActivity;
import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements SplashContract.view {

    SplashContract.presenter presenter;

    @BindView(R.id.layout_concetto)
    ConstraintLayout concettoLayout;

    private static int WELCOME_TIMEOUT = 1500;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        presenter = new SplashPresenter(this);

        Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in_long);
        concettoLayout.startAnimation(aniFade);
        new Handler().postDelayed(() -> {

            Intent intent = new Intent(SplashActivity.this, HomePageActivity.class);
            startActivity(intent);
            finish();
        },WELCOME_TIMEOUT);
    }
}
