package com.rishabh.concetto2019.Profile.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rishabh.concetto2019.Authentication.SignUpPage.MVP.SignupActivity;
import com.rishabh.concetto2019.Profile.Model.ProfileModel;
import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.Utilities.SharedPref;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.view
{
    ProfileContract.presenter presenter;
    SharedPref sharedPref;

    @BindView(R.id.profile_name)
    TextView profile_name;
    @BindView(R.id.profile_college)
    TextView profile_college;
    @BindView(R.id.profile_email)
    TextView profile_email;
    @BindView(R.id.profile_phone)
    TextView profile_phone;
    @BindView(R.id.profile_forgot)
    TextView profile_forgot;
    @BindView(R.id.profile_event)
    TextView profile_events;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        presenter = new ProfilePresenter(this);
        ButterKnife.bind(this);
        sharedPref = new SharedPref(this);

        profile_name.setText(sharedPref.getName());
        profile_phone.setText(sharedPref.getPhone());
        profile_college.setText(sharedPref.getCollege());
        profile_email.setText(sharedPref.getEmail());

        profile_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, SignupActivity.class));
            }
        });

    }
}
