package com.rishabh.concetto2019.HomePage.MVP;

import android.os.Bundle;
import androidx.annotation.NonNull;

import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.rishabh.concetto2019.R;

public class Floating_menu extends Fragment implements NavigationView.OnNavigationItemSelectedListener
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_menu, container, false);

        NavigationView navigationView=(NavigationView)view.findViewById(R.id.vNavigation);
        navigationView.setNavigationItemSelectedListener(this);

        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
