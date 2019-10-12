package com.rishabh.concetto2019.SplashScreen.MVP;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rishabh.concetto2019.Authentication.LogInPage.MVP.LoginActivity;
import com.rishabh.concetto2019.Authentication.SignUpPage.MVP.SignupActivity;
import com.rishabh.concetto2019.HomePage.MVP.HomePageActivity;
import com.rishabh.concetto2019.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements SplashContract.view {

    SplashContract.presenter presenter;

    @BindView(R.id.layout_concetto)
    ConstraintLayout concettoLayout;

    String versionName,database_versionname;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("version");
    ValueEventListener listener;

    @BindView(R.id.progressbartitle)
    TextView progressbartitle;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    private static int WELCOME_TIMEOUT = 500;
    public static String url = "https://play.google.com/store/apps/details?id=com.rishabh.concetto2019";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        presenter = new SplashPresenter(this);

        Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in_long);
        concettoLayout.startAnimation(aniFade);

        try
        {
            versionName = this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
        }
        catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }

        listener = reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    database_versionname = ds.getValue().toString();

                    if(versionName.equals(database_versionname)){
                        progressBar.setVisibility(View.GONE);
                        progressbartitle.setVisibility(View.GONE);
                        new Handler().postDelayed(() -> {
                            Intent intent = new Intent(SplashActivity.this, HomePageActivity.class);
                            startActivity(intent);
                            finish();
                        },WELCOME_TIMEOUT);
                    }
                    else
                    {
                        progressBar.setVisibility(View.GONE);
                        progressbartitle.setVisibility(View.GONE);
                        showUpdate();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void showUpdate()
    {
        final AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("UPDATE");
        alertDialog.setMessage("Please update the app first !");
        alertDialog.setCancelable(false);

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Update Now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                alertDialog.dismiss();
                finish();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                finish();
            }
        });
        alertDialog.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (reference != null && listener != null) {
            reference.removeEventListener(listener);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (reference != null && listener != null) {
            reference.removeEventListener(listener);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (reference != null && listener != null) {
            reference.removeEventListener(listener);
        }
    }

}
