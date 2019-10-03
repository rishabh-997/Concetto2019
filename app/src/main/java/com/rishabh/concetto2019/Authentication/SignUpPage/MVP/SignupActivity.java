package com.rishabh.concetto2019.Authentication.SignUpPage.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.SplashScreen.MVP.SplashActivity;
import com.rishabh.concetto2019.Utilities.SharedPref;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity implements SignupContract.view {

    SignupContract.presenter presenter;


    @BindView(R.id.name_signup_edittext)
    EditText nameSignupEditText;

    @BindView(R.id.phone_signup_edittext)
    EditText phoneSignupEditText;

    @BindView(R.id.college_signup_edittext)
    EditText collegeSignupEditText;

    @BindView(R.id.email_signup_edittext)
    EditText emailSignupEditText;

    @BindView(R.id.signup_signup_button)
    Button signupButton;

    private String name;
    private String email;
    private String phone;
    private String college;

    SharedPref sharedPref;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);
        nameSignupEditText = findViewById(R.id.name_signup_edittext);

        presenter = new SignupPresenter(this);
        ButterKnife.bind(this);
        sharedPref = new SharedPref(this);

        if(!sharedPref.getSetup().equals(""))
        {
            nameSignupEditText.setText(sharedPref.getName());
            collegeSignupEditText.setText(sharedPref.getCollege());
            emailSignupEditText.setText(sharedPref.getEmail());
            phoneSignupEditText.setText(sharedPref.getPhone());
        }
        setup();
    }

    private void setup()
    {
        signupButton.setOnClickListener(v ->
        {
            name = nameSignupEditText.getText().toString().trim();
            email = emailSignupEditText.getText().toString().trim();
            phone = phoneSignupEditText.getText().toString().trim();
            college = collegeSignupEditText.getText().toString().trim();

            if (name.length()==0){
                nameSignupEditText.setError("Please enter your name");
                nameSignupEditText.requestFocus();
            }
            else if (emailSignupEditText.length()==0){
                emailSignupEditText.setError("Please enter your email address");
                emailSignupEditText.requestFocus();
            }
            else if (phone.length()!=10){
                phoneSignupEditText.setError("Please enter your mobile number");
                phoneSignupEditText.requestFocus();
            }
            else if (collegeSignupEditText.length()==0){
                collegeSignupEditText.setError("Please enter the name of your college");
                collegeSignupEditText.requestFocus();
            }
            else{
                sharedPref.setName(name);
                sharedPref.setEmail(email);
                sharedPref.setCollege(college);
                sharedPref.setPhone(phone);
                sharedPref.setSetup("registered");

                collegeSignupEditText.setText("");
                nameSignupEditText.setText("");
                emailSignupEditText.setText("");
                phoneSignupEditText.setText("");

                Toast.makeText(this, "Profile Created", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(() -> {

                    finish();
                },500);
            }
        });

    }
}
