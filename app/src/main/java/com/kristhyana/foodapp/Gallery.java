package com.kristhyana.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Gallery extends AppCompatActivity implements  TopFragment.PassData{
    TopFragment topFragment;
    MiddleFragment middleFragment;
    BottomFragment bottomFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        topFragment = (TopFragment) getFragmentManager().findFragmentById(R.id.topFragment);
        middleFragment = (MiddleFragment) getFragmentManager().findFragmentById(R.id.midFragment);
        bottomFragment = (BottomFragment) getFragmentManager().findFragmentById(R.id.botFragment);

    }

    @Override
    public void takeThisData(int cData) {
        middleFragment.sendInfo(cData);
        bottomFragment.change(cData);

    }

}
