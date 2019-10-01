package com.rishabh.concetto2019.HomePage.MVP;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.transition.TransitionManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.rishabh.concetto2019.EventPage.MVP.EventActivity;
import com.rishabh.concetto2019.EventPage.MVP.EventActivityNew;
import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.TechTalkPage.MVP.TechTalkActivity;
import com.rishabh.concetto2019.WorkshopPage.MVP.WorkshopActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rishabh Agarwal on 23rd Septemer 2019
 */

public class HomePageActivity extends AppCompatActivity implements HomePageContract.view, View.OnTouchListener {

    @BindView(R.id.button_event)
    TextView event;
    @BindView(R.id.button_techtalks)
    TextView techtalk;
    @BindView(R.id.button_workshop)
    TextView workshop;
    @BindView(R.id.drawerlayout)
    FlowingDrawer mDrawer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.animated_view)
    PlanetAnimationView animationView;
    @BindView(R.id.moon_image)
    ImageView moon_rotating;
    @BindView(R.id.schedule_day1)
    ImageView schedule_day1;
    @BindView(R.id.schedule_day2)
    ImageView schedule_day2;
    @BindView(R.id.schedule_day3)
    ImageView schedule_day3;
    @BindView(R.id.schedule_container)
    FrameLayout frameLayout;
    @BindView(R.id.relativelayout)
    RelativeLayout relativeLayout;

    public static int fragment_state = 0;
    final Fragment fragment1 = new ScheduleFragment1();
    final Fragment fragment2 = new ScheduleFragment2();
    final Fragment fragment3 = new ScheduleFragment3();
    final FragmentManager fm1 = getSupportFragmentManager();
    final FragmentManager fm2 = getSupportFragmentManager();
    final FragmentManager fm3 = getSupportFragmentManager();

    HomePageContract.presenter presenter;
    float dx, current, original;
    int lastAction, width, retreat = 0;
    Animation rotation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ButterKnife.bind(this);
        presenter = new HomePagePresenter(this);
        setSupportActionBar(toolbar);
        animationView.resume();
        rotation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        rotation.setFillAfter(true);
        moon_rotating.startAnimation(rotation);
        fm1.beginTransaction().add(R.id.schedule_container,fragment1,"1").hide(fragment1).commit();
        fm2.beginTransaction().add(R.id.schedule_container,fragment2,"2").hide(fragment2).commit();
        fm3.beginTransaction().add(R.id.schedule_container,fragment3,"3").hide(fragment3).commit();
        setup();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setup() {

        //getting screen size
        Rect displayRectangle = new Rect();
        Window window = this.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);
        width = (int) (displayRectangle.width());

        //touch listeners
        event.setOnTouchListener(this);
        techtalk.setOnTouchListener(this);
        workshop.setOnTouchListener(this);

        toolbar.setNavigationIcon(R.drawable.hamburgericon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.openMenu();
            }
        });

        schedule_day1.setOnClickListener(v -> {
            fragment_state = 1;
            fm1.beginTransaction().show(fragment1).commit();
        });
        schedule_day2.setOnClickListener(v -> {
            fragment_state = 2;
            fm2.beginTransaction().show(fragment2).commit();
        });
        schedule_day3.setOnClickListener(v -> {
            fragment_state = 3;
            fm3.beginTransaction().show(fragment3).commit();
        });

        //flowing drawer
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    Log.i("MainActivity", "Drawer STATE_CLOSED");
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
                Log.i("MainActivity", "openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
            }
        });
        setupMenu();
    }

    //handles touch events
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastAction = MotionEvent.ACTION_DOWN;
                dx = v.getX() - event.getRawX();
                original = event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                lastAction = MotionEvent.ACTION_MOVE;
                current = event.getRawX();
                float change = ((original - current) / width * 100);
                if (change > 0 && change < 25) {
                    retreat = 1;
                    v.setX(event.getRawX() + dx);
                } else
                    retreat = 0;
                break;
            case MotionEvent.ACTION_UP:
                if(lastAction == MotionEvent.ACTION_DOWN)
                    Toast.makeText(this, "swipe to open", Toast.LENGTH_SHORT).show();
                else {
                    if (retreat == 1) {
                        v.setX(original + dx);
                    } else {
                        if (v.getId() == R.id.button_workshop) {

                            startActivity(new Intent(this, WorkshopActivity.class));
                            overridePendingTransition(R.anim.slidein_to_left, R.anim.slideout_to_left);
                        } else if (v.getId() == R.id.button_event) {

                            startActivity(new Intent(this, EventActivityNew.class));
                            overridePendingTransition(R.anim.slidein_to_left, R.anim.slideout_to_left);
                        } else if (v.getId() == R.id.button_techtalks) {

                            startActivity(new Intent(this, TechTalkActivity.class));
                            overridePendingTransition(R.anim.slidein_to_left, R.anim.slideout_to_left);
                        }
                        v.setX(original + dx);
                    }
                }
                break;
        }
        return false;
    }
    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        Floating_menu f_menu = (Floating_menu) fm.findFragmentById(R.id.id_container_menu);
        if (f_menu == null) {
            f_menu = new Floating_menu();
            fm.beginTransaction().add(R.id.id_container_menu, f_menu).commit();
        }
    }

        @Override
    public void onBackPressed() {
        if(fragment_state==1)
        {
            fragment_state = 0;
            fm1.beginTransaction().hide(fragment1).commit();
        }
        else if(fragment_state==2)
        {
            fragment_state = 0;
            fm2.beginTransaction().hide(fragment2).commit();
        }
        else if(fragment_state==3)
        {
            fragment_state = 0;
            fm3.beginTransaction().hide(fragment3).commit();
        }
        else{
              super.onBackPressed();
        }
    }
}