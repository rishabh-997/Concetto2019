package com.rishabh.concetto2019.Profile.MVP;

import android.os.Bundle;
import android.widget.Toast;

import com.rishabh.concetto2019.Profile.Model.ProfileModel;
import com.rishabh.concetto2019.R;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.view
{
    ProfileContract.presenter presenter;
    ProfileModel profileModel;
    String name,college,admin,email,phone;

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
    }
}
