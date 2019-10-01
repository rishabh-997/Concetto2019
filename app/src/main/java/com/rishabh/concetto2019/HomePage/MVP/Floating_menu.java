package com.rishabh.concetto2019.HomePage.MVP;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.Toast;

import com.rishabh.concetto2019.Aboutus.AboutUsActivity;
import com.rishabh.concetto2019.Contactus.ContactusActivity;
import com.rishabh.concetto2019.Developers.MVP.DeveloperActivity;
import com.rishabh.concetto2019.Profile.MVP.ProfileActivity;
import com.rishabh.concetto2019.R;

public class Floating_menu extends Fragment implements NavigationView.OnNavigationItemSelectedListener
{
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
                case R.id.menu_about:
                    Intent intent = new Intent(getActivity(),AboutUsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.menu_report_bug:
                    Intent i = new Intent(Intent.ACTION_SENDTO);
                    String mailTo = "mailto:".concat("rishabh.agarwal997@gmail.com");
                    i.setData(Uri.parse(mailTo));
                    try {
                        startActivity(i);
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.menu_developers:
                    startActivity(new Intent(getActivity(), DeveloperActivity.class));
                    break;
                case R.id.menu_profile:
                    startActivity(new Intent(getActivity(), ProfileActivity.class));
                    break;
                case R.id.menu_contactus:
                    startActivity(new Intent(getActivity(), ContactusActivity.class));
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
