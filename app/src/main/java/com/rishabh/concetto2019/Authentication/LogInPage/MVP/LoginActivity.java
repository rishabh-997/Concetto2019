package com.rishabh.concetto2019.Authentication.LogInPage.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.rishabh.concetto2019.Authentication.LogInPage.Model.LogInResponse;
import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.Utilities.SharedPref;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {

    LoginContract.presenter presenter;
    String access_token;
    SharedPref sharedPref;

    @BindView(R.id.email_login_edittext)
    EditText emailLoginEditText;
    @BindView(R.id.password_login_edittext)
    EditText passwordLoginEditText;
    @BindView(R.id.login_login_button)
    Button loginButton;

    private String email;
    private String password;

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
        loginButton.setOnClickListener(v ->
        {
            email = emailLoginEditText.getText().toString();
            password = passwordLoginEditText.getText().toString();

            if(email.length()==0){
                emailLoginEditText.setError("Enter the required fields");
            }
            else if (password.length()<6){
                passwordLoginEditText.setError("Please enter a valid user_password");
            }
            else
            {
                presenter.doLogin(email,password);
            }
        });
    }

    @Override
    public void login(LogInResponse body)
    {
        /**
         * perform after signup effects
         */
        access_token = body.getResult().get(0).getAccess_token();
        sharedPref.setAccessToken(access_token);
    }

    @Override
    public void showToast(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
