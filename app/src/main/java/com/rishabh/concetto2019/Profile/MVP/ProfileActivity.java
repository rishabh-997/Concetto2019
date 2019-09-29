package com.rishabh.concetto2019.Profile.MVP;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.rishabh.concetto2019.Profile.Model.ProfileModel;
import com.rishabh.concetto2019.R;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.view
{
    ProfileContract.presenter presenter;
    String name,college,admin,email,phone;

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
    }

    @Override
    public void showToast(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProfile(List<ProfileModel> profile) {
        name = profile.get(0).getName();
        college = profile.get(0).getCollege();
        admin = profile.get(0).getAdmin();
        email = profile.get(0).getEmail();
        phone = profile.get(0).getPhone();

        profile_name.setText(name);
        profile_college.setText(college);
        profile_phone.setText(phone);
        profile_email.setText(email);

        profile_forgot.setOnClickListener(v -> Toast.makeText(this, "Forgot Password", Toast.LENGTH_SHORT).show());
        profile_events.setOnClickListener(v -> Toast.makeText(this, "Registered Events", Toast.LENGTH_SHORT).show());
    }
}
