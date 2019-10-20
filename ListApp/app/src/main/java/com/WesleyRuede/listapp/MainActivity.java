package com.WesleyRuede.listapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // reference to myListView which points to myListView activity_main
    ListView myListView;
    // a string-array in reference to items strings in res with a string-array
    String[] items;
    // a string-array in reference to prices strings in res with a string-array
    String[] prices;
    // a string-array in reference to prices strings in res with a string-array
    String[] descriptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference to the resources
        Resources res = getResources();
        // initialize myListView, use findViewById to look in the res dir and
        // return a ListView, cast to a ListView and store in myListView
        myListView = (ListView) findViewById(R.id.myListView);
        // initialize the string-array and use the res var in reference to
        // the resources in res of myListView
        items = res.getStringArray(R.array.items);
        // initialize the string-array and use the res var in reference to
        // the resources in res of prices
        prices = res.getStringArray(R.array.prices);
        // initialize the string-array and use the res var in reference to
        // the resources in res of descriptions
        descriptions = res.getStringArray(R.array.descriptions);

    }
}
