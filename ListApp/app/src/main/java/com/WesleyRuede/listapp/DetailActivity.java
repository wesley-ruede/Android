package com.WesleyRuede.listapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Wesley Ruede on 10/22/19
 */
// This is being created for the operation of applying an index to the respective
    // image from the designated ListView object being pressed.


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Creating an Intent in response to the setOnItemCLickListener()'s
        // method startActivity() to draw an image on the screen.
        Intent in = getIntent();
        // Here I learned a nuance of Java as negative indexing is not allowed
        // so by using the very last element of an array denotes the end of it
        int index = in.getIntExtra("com.WesleyRuede.ITEM_INDEX", -1);

    }
}
