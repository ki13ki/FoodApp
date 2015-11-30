package com.kristhyana.foodapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Preferences extends AppCompatActivity {

    RadioGroup rg;
    TextView tv;
    TextView tv12;
    ToggleButton tb;
    EditText et;
    TextView tv13;
    Button addButton;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        rg = (RadioGroup) findViewById(R.id.radioType);
        tv = (TextView) findViewById(R.id.textView11);
        tv12 = (TextView) findViewById(R.id.textView12);
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        et = (EditText) findViewById(R.id.editText);
        tv13 = (TextView) findViewById(R.id.textView13);
        addButton = (Button) findViewById(R.id.button8);
        resetButton = (Button) findViewById(R.id.button9);


        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int selectedType = prefs.getInt("type", 0);
        if (selectedType != 0) {
            typeOfFood(selectedType);
            RadioButton rb = (RadioButton) findViewById(selectedType);
            rb.setChecked(true);
        }
        Boolean b = prefs.getBoolean("specials", false);
        if (b) {
            tb.setChecked(true);
            tv12.setText("Send Me Specials");

        } else {
            tb.setChecked(false);
            tv12.setText("Dont Send Me Specials");

        }
        Boolean all = prefs.getBoolean("areAllergiesSet", false);
        if (all) {
            tv13.setVisibility(View.VISIBLE);
            resetButton.setVisibility(View.VISIBLE);
            et.setVisibility(View.GONE);
            addButton.setVisibility(View.GONE);
            tv13.setText(prefs.getString("allergies", "None"));
        } else {
            tv13.setVisibility(View.GONE);
            resetButton.setVisibility(View.GONE);
            et.setVisibility(View.VISIBLE);
            addButton.setVisibility(View.VISIBLE);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("type", checkedId);
                editor.commit();
                typeOfFood(checkedId);


            }
        });

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tv12.setText("Send Me Specials");
                } else {
                    tv12.setText("Dont Send Me Specials");
                }
                SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("specials", isChecked);
                editor.commit();

            }
        });
    }

    public void typeOfFood(int checkedId) {
        switch (checkedId) {
            case R.id.radioButton: {
                tv.setText("You hate Animals");
                break;
            }
            case R.id.radioButton2: {
                tv.setText("You are Meat Lover");
                break;
            }
            case R.id.radioButton3: {
                tv.setText("You are Vegan");
                break;
            }
            case R.id.radioButton4: {
                tv.setText("You are Kosher");
                break;
            }
            case R.id.radioButton5: {
                tv.setText("You are Halal");
                break;
            }
        }
    }

    public void resetAllergies(View v) {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("areAllergiesSet", false);
        editor.commit();

        tv13.setVisibility(View.GONE);
        resetButton.setVisibility(View.GONE);
        et.setVisibility(View.VISIBLE);
        addButton.setVisibility(View.VISIBLE);
        et.setText("");

    }

    public void addAllergies(View v) {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("areAllergiesSet", true);
        editor.putString("allergies", et.getText().toString());
        editor.commit();


        tv13.setVisibility(View.VISIBLE);
        tv13.setText(et.getText().toString());
        resetButton.setVisibility(View.VISIBLE);
        et.setVisibility(View.GONE);
        addButton.setVisibility(View.GONE);
    }
}
