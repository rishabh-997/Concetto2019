package com.rishabh.concetto2019.Authentication.SignUpPage.MVP;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.Utilities.SharedPref;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity implements SignupContract.view {

    SignupContract.presenter presenter;

    @BindView(R.id.phone_signup_edittext)
    EditText nameSignupEditText;
    @BindView(R.id.name_signup_edittext)
    EditText emailSignupEditText;

    @BindView(R.id.phone_signup_edittext)
    EditText phoneSignupEditText;
    @BindView(R.id.password_signup_edittext)
    EditText collegeSignupEditText;
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

        presenter = new SignupPresenter(this);
        ButterKnife.bind(this);
        sharedPref = new SharedPref(this);
        setup();
    }

    private void setup()
    {
        signupButton.setOnClickListener(v ->
        {
            name = nameSignupEditText.getText().toString();
            email = emailSignupEditText.getText().toString();
            phone = phoneSignupEditText.getText().toString();
            college = collegeSignupEditText.getText().toString();

            if (name.length()==0){
                nameSignupEditText.setError("Please enter your name");
                nameSignupEditText.requestFocus();
            }
            else if (email.length()==0){
                emailSignupEditText.setError("Please enter your email address");
                emailSignupEditText.requestFocus();
            }
            else if (phone.length()!=10){
                phoneSignupEditText.setError("Please enter your mobile number");
                phoneSignupEditText.requestFocus();
            }
            else if (college.length()==0){
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
            }
        });

    }
}
