package com.rishabh.concetto2019.HomePage.MVP;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rishabh.concetto2019.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageActivity extends AppCompatActivity implements HomePageContract.view, View.OnTouchListener {

    @BindView(R.id.button_event)
    Button event;
    @BindView(R.id.button_techtalks)
    Button techtalk;
    @BindView(R.id.button_specialnight)
    Button specialnight;
    @BindView(R.id.button_workshop)
    Button workshop;

    HomePageContract.presenter presenter;
    View.OnTouchListener listener;
    float dx,dy;
    int lastAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ButterKnife.bind(this);
        presenter = new HomePagePresenter(this);
        setup();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setup() {
        event.setOnTouchListener(this);
        techtalk.setOnTouchListener(this);
        workshop.setOnTouchListener(this);
        specialnight.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastAction = MotionEvent.ACTION_DOWN;
                dx = v.getX() - event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                lastAction = MotionEvent.ACTION_MOVE;
                v.setX(event.getRawX() + dx);
                break;
            case MotionEvent.ACTION_UP:
                if(lastAction==MotionEvent.ACTION_DOWN)
                    Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
