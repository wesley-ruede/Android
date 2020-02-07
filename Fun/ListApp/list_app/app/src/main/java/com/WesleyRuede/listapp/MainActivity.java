package com.WesleyRuede.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        // reference to the resources (see app/res/layout directory in package) layout files
        Resources res = getResources();
        // initialize myListView, use findViewById to look in the res dir and
        // return a ListView, cast to a ListView and store in myListView
        myListView = (ListView) findViewById(R.id.myListView);
        // initialize the string-array and use the res var in reference to
        // the resources in res of myListView
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        // create a reference to the ItemAdapter which requires a context
        // and three string arrays
        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);
        // using the ItemAdapter by setting the ItemAdapter to the ListView
        myListView.setAdapter(itemAdapter);

        // ListView is populating with arrays and constraints have been adjusted

        //  move from MainActivity to DetailActivity
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                // send the activity the index of the item that is sent
                showDetailActivity.putExtra("com.WesleyRuede.ITEM_INDEX", i);
                // move to the image activity by clicking on the item in my_listview_detail Activity
                showDetailActivity.putExtra("DA","log 1");
                showDetailActivity.putExtra("IA","log 2");

                startActivity(showDetailActivity);

                // ListView is showing an image in another activity when pressed
                // Adding images to the drawable directory see app/res/drawable


            }
        });
    }
}