package com.rishabh.concetto2019.Authentication.SignUpPage.MVP;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rishabh.concetto2019.R;

import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity implements SignupContract.view {

    SignupContract.presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        presenter = new SignupPresenter(this);
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