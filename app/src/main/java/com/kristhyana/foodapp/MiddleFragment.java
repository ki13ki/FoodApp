package com.kristhyana.foodapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class MiddleFragment extends Fragment {
    int[] image = {R.drawable.imageone, R.drawable.imagetwo, R.drawable.imagethree, R.drawable.imagefour,
            R.drawable.imagefive, R.drawable.imagesix, R.drawable.imageseven, R.drawable.imageeight, R.drawable.imagenine, R.drawable.ten};

    ImageView iv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_middle, container, false);
        iv = (ImageView) v.findViewById(R.id.galleryImage);
        return v;
    }

    public void sendInfo(int cData) {
            iv.setImageResource(image[cData]);
    }
}
