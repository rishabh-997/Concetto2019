package com.rishabh.concetto2019.HomePage.MVP;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.rishabh.concetto2019.EventPage.MVP.EventActivity;
import com.rishabh.concetto2019.R;
import com.rishabh.concetto2019.TechTalkPage.MVP.TechTalkActivity;
import com.rishabh.concetto2019.WorkshopPage.MVP.WorkshopActivity;
import java.util.Random;
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

    HomePageContract.presenter presenter;
    float dx, current, original;
    int lastAction, width, retreat = 0;
    Random random = new Random();
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
        setup();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setup() {

        Rect displayRectangle = new Rect();
        Window window = this.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);
        width = (int) (displayRectangle.width());

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
                            finish();
                        } else if (v.getId() == R.id.button_event) {

                            startActivity(new Intent(this, EventActivity.class));
                            overridePendingTransition(R.anim.slidein_to_left, R.anim.slideout_to_left);
                            finish();
                        } else if (v.getId() == R.id.button_techtalks) {

                            startActivity(new Intent(this, TechTalkActivity.class));
                            overridePendingTransition(R.anim.slidein_to_left, R.anim.slideout_to_left);
                            finish();
                        }
                        v.setX(original + dx);
                    }
                }
                break;
        }
        return false;
    }
}
