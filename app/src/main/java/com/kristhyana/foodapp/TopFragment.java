package com.kristhyana.foodapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TopFragment extends Fragment {
    int click = 0;
    PassData passData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        Button previous = (Button) view.findViewById(R.id.prevbutton);
        Button next = (Button) view.findViewById(R.id.nextBtn);

        if(click < 0){
            click = 9;
        }
        if(click > 9){
            click = 0;
        }

        previous.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    click--;
                    passData = (PassData) getActivity();
                    passData.takeThisData(click);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                click++;
                passData = (PassData) getActivity();
                passData.takeThisData(click);
            }
        });

        return view;
    }

    interface PassData {
        public void takeThisData(int cData);

    }
}