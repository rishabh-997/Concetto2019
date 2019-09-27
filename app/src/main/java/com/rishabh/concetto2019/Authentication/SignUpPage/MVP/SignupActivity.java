package com.rishabh.concetto2019.Authentication.SignUpPage.MVP;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rishabh.concetto2019.R;

import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity implements SignupContract.view {

    SignupContract.presenter presenter;
    String email, name, password, phone, college;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        presenter = new SignupPresenter(this);
        ButterKnife.bind(this);

        setup();
    }

    private void setup()
    {
        /**
         * Abstract methods here
         */
        presenter.doSignUp(email,name,password,phone,college);
    }

    @Override
    public void showToast(String results) {
        Toast.makeText(this, results, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signedin() {

        /**
         * Activity to be performed after successful signup
         */
    }
}
