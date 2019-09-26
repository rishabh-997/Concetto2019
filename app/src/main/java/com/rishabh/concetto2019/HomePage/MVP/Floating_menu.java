package com.rishabh.concetto2019.HomePage.MVP;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.rishabh.concetto2019.Authentication.LogInPage.MVP.LoginActivity;
import com.rishabh.concetto2019.Authentication.SignUpPage.MVP.SignupActivity;
import com.rishabh.concetto2019.R;

public class Floating_menu extends Fragment implements NavigationView.OnNavigationItemSelectedListener
{
    @BindView(R.id.ConcettoIcon)
    ImageView concettoIcon;
    @BindView(R.id.vNavigation)
    NavigationView navigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.fragment_menu, container, false);
        ButterKnife.bind(this,view);

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            switch (id) {
                case R.id.menu_login:
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    break;
                case R.id.menu_signup:
                    startActivity(new Intent(getActivity(), SignupActivity.class));
                    break;
            }
            return false;
        });


        return view ;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        return false;
    }
}
