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

import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {

    LoginContract.presenter presenter;

    @BindView(R.id.email_login_edittext)
    EditText emailLoginEditText;
    @BindView(R.id.password_login_edittext)
    EditText passwordLoginEditText;
    @BindView(R.id.login_login_button)
    Button loginButton;

    private Editable email;
    private Editable password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        presenter = new LoginPresenter(this);
        ButterKnife.bind(this);

        email = emailLoginEditText.getText();
        password = passwordLoginEditText.getText();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.length()==0){
                    emailLoginEditText.setError("Enter the required fields");
                }
                else if (password.length()<6){
                    passwordLoginEditText.setError("Please enter a valid password");
                }
                else{
                    Toast.makeText(LoginActivity.this, "You have successfully loged in", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        startActivity(new Intent(this, HomePageActivity.class));
//        overridePendingTransition(R.anim.slidein_to_right,R.anim.slideout_to_right);
//        finish();
//    }
}
