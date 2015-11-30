package com.kristhyana.foodapp;

import android.content.Intent;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent i;

        //noinspection SimplifiableIfStatement
        if (id == R.id.preferences) {
            i = new Intent(this, Preferences.class);
            startActivity(i);
        }
        if (id == R.id.gallery) {
            i = new Intent(this, Gallery.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    public void menulist(View view) {
        Intent intent = new Intent(this, com.kristhyana.foodapp.Menu.class);
        startActivity(intent);
    }

    public void gotoContactUs(View view) {
        Intent intent = new Intent(this, ContactUs.class);
        startActivity(intent);
    }

    public void gotoWebsite(View view) {
        Intent i = new Intent(this, Website.class);
        startActivity(i);
    }

    public void gotoGallery(View view) {
        Intent i = new Intent(this, Gallery.class);
        startActivity(i);
    }

    public void gotoPrefs(View view) {
        Intent i = new Intent(this, Preferences.class);
        startActivity(i);
    }
}
