package com.rishabh.concetto2019.HomePage.MVP;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rishabh.concetto2019.R;

/**
 * Created by Rishabh Agarwal.
 */
public class ScheduleFragment1 extends Fragment {


    public ScheduleFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

}
