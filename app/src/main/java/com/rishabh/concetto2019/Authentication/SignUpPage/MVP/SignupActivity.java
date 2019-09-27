package com.rishabh.concetto2019.Authentication.SignUpPage.MVP;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

    private String name;
    private String email;
    private String password;
    private String phone;
    private String college;

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
        name = nameSignupEditText.getText().toString();
        email = emailSignupEditText.getText().toString();
        password = passwordSignupEditText.getText().toString();
        phone = phoneSignupEditText.getText().toString();
        college = collegeSignupEditText.getText().toString();

        signupButton.setOnClickListener(v -> {
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
                presenter.doSignUp(email,name,password,phone,college);
            }
        });

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
