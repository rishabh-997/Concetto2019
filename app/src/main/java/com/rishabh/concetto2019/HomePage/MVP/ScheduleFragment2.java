package com.rishabh.concetto2019.HomePage.MVP;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rishabh.concetto2019.HomePage.Model.ScheduleModel;
import com.rishabh.concetto2019.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment2 extends Fragment {

    RecyclerView recyclerView;
    TextView textView;
    DatabaseReference databaseReference;
    ScheduleAdapter2 adapter;
    List<ScheduleModel> list = new ArrayList<>();

    public ScheduleFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_schedule_fragment2, container, false);


        recyclerView = view.findViewById(R.id.schedule2_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        textView = view.findViewById(R.id.textView5);

        adapter = new ScheduleAdapter2(list,getContext());

        databaseReference = FirebaseDatabase.getInstance().getReference("day2");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot db :dataSnapshot.getChildren()){
                    String name = db.child("name").getValue().toString();
                    String place= db.child("place").getValue().toString();
                    String time = db.child("time").getValue().toString();

                    ScheduleModel model = new ScheduleModel(name,time,place);
                    list.add(model);
                }
                if(list.size()==0)
                {
                    textView.setVisibility(View.VISIBLE);
                }
                else {
                    recyclerView.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.GONE);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }

}
