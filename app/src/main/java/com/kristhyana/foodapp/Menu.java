package com.kristhyana.foodapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    ListView listView;
    String[] title;
    String[] price;
    int[] image = {R.drawable.coffeesmell, R.drawable.steak, R.drawable.icecream};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listView = (ListView) findViewById(R.id.listView);
        title = getResources().getStringArray(R.array.menu);
        price = getResources().getStringArray(R.array.price);



        MyAdapter adapter = new MyAdapter(this,title,image,price);
        listView.setAdapter(adapter);
    }


    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        int[] images;
        String[] titleArray;
        String[] descArray;
        int count = 0;

        public MyAdapter(Context c, String[] titles, int[] imgs, String[] desc) {
            super(c, R.layout.activity_menu, R.id.item, titles);
            this.context = c;
            this.images = imgs;
            this.titleArray = titles;
            this.descArray = desc;


        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.menu_single_row, parent, false);


            ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
            TextView myTitle = (TextView) row.findViewById(R.id.item);
            TextView myDesc = (TextView) row.findViewById(R.id.price);


            myImage.setImageResource(images[position]);
            myTitle.setText(titleArray[position]);
            myDesc.setText(descArray[position]);

            return row;
        }

    }
}
