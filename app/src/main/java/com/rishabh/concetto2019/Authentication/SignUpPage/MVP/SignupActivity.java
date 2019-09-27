package com.rishabh.concetto2019.Authentication.SignUpPage.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity implements SignupContract.view {

    SignupContract.presenter presenter;

    @BindView(R.id.name_signup_edittext)
    EditText nameSignupEditText;
    @BindView(R.id.email_signup_edittext)
    EditText emailSignupEditText;
    @BindView(R.id.password_signup_edittext)
    EditText passwordSignupEditText;
    @BindView(R.id.phone_signup_edittext)
    EditText phoneSignupEditText;
    @BindView(R.id.college_signup_edittext)
    EditText collegeSignupEditText;
    @BindView(R.id.signup_signup_button)
    Button signupButton;

    private Editable name;
    private Editable email;
    private Editable password;
    private Editable phone;
    private Editable college;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        presenter = new SignupPresenter(this);
        ButterKnife.bind(this);

        name = nameSignupEditText.getText();
        email = emailSignupEditText.getText();
        password = passwordSignupEditText.getText();
        phone = phoneSignupEditText.getText();
        college = collegeSignupEditText.getText();


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.length()==0){
                    nameSignupEditText.setError("Please enter your name");
                }
                else if (email.length()==0){
                    emailSignupEditText.setError("Please enter your email address");
                }
                else if (phone.length()!=10){
                    phoneSignupEditText.setError("Please enter your mobile number");
                }
                else if (college.length()==0){
                    collegeSignupEditText.setError("Please enter the name of your college");
                }
                else if (password.length()<6){
                    passwordSignupEditText.setError("Please enter a valid password");
                }
                else{
                    Intent intent = new Intent(SignupActivity.this, HomePageActivity.class);
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
