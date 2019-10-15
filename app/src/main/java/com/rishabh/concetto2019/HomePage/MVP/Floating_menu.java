package com.rishabh.concetto2019.HomePage.MVP;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.rishabh.concetto2019.Aboutus.AboutUsActivity;
import com.rishabh.concetto2019.Contactus.ContactusActivity;
import com.rishabh.concetto2019.Authentication.SignUpPage.MVP.SignupActivity;
import com.rishabh.concetto2019.Developers.MVP.DeveloperActivity;
import com.rishabh.concetto2019.Map.MapActivity;
import com.rishabh.concetto2019.Profile.MVP.ProfileActivity;
import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.Utilities.SharedPref;

public class Floating_menu extends Fragment implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.vNavigation)
    NavigationView navigationView;

    @BindView(R.id.facebook_hyperlink_imageview)
    ImageView fbLogo;
    @BindView(R.id.web_hyperlink_imageview)
    ImageView webLogo;
    @BindView(R.id.instagram_hyperlink_imageview)
    ImageView instaLogo;

    SharedPref sharedPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        ButterKnife.bind(this, view);
        sharedPref = new SharedPref(getContext());

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            switch (id) {
                case R.id.menu_about:
                    Intent intent = new Intent(getActivity(), AboutUsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.menu_map:
                    startActivity(new Intent(getActivity(), MapActivity.class));
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
                    if (sharedPref.getSetup() == "") {
                        Toast.makeText(getContext(), "Please Register First", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(), SignupActivity.class));
                    } else {
                        startActivity(new Intent(getActivity(), ProfileActivity.class));
                    }
                    break;
                case R.id.menu_contactus:
                    startActivity(new Intent(getActivity(), ContactusActivity.class));
                    break;

            }
            return false;
        });



        fbLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //https://www.facebook.com/Concettoiitdhanbad/
                Toast.makeText(getContext(),"Loading...",Toast.LENGTH_SHORT).show();
                String url = "https://www.facebook.com/Concettoiitdhanbad/";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/320442528100910"));
                    startActivity(intent);
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,    Uri.parse(url)));
                }
            }
        });
        webLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(),"Loading...",Toast.LENGTH_SHORT).show();
                String url = "https://www.concetto19.tech/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        instaLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Loading...",Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("http://instagram.com/_u/concetto.iitism");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/concetto.iitism")));
                }
            }
        });

        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
