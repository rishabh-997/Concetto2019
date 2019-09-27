package com.rishabh.concetto2019.Authentication.LogInPage.MVP;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rishabh.concetto2019.Authentication.LogInPage.Model.LogInResponse;
import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.Utilities.SharedPref;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {

    LoginContract.presenter presenter;
    String email, password, access_token;
    SharedPref sharedPref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        presenter = new LoginPresenter(this);
        ButterKnife.bind(this);
        sharedPref = new SharedPref(this);
        setup();
    }

    private void setup()
    {
        /**
         * Perform operations before confirming login
         */
        presenter.doLogin(email, password);
    }

    @Override
    public void login(LogInResponse body) {
        /**
         * Perform After Login Activities
         */
        access_token = body.getResult().get(0).getAccess_token();
        sharedPref.setAccessToken(access_token);
    }

    @Override
    public void showToast(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
