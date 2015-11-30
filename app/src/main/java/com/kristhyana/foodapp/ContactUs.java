package com.kristhyana.foodapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }


    public void ShowMap(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:39.0094691,-76.8980689"));
//        Intent chooser = Intent.createChooser(intent, "Launch Maps");
        startActivity(intent);
    }

    public void gotoWebsite(View view) {
        Intent i = new Intent(this, Website.class);
        startActivity(i);
    }

    public void share(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Vivian's Resturant @Greenbelt- \n " +
                "http://www.vivianaranha.com");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
