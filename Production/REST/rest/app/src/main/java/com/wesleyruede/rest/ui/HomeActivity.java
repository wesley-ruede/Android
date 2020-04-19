package com.wesleyruede.rest.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        DatabaseHandler db = new DatabaseHandler(HomeActivity.this);
        Groups groups = new Groups();

        String firstGroupOfTheDay = groups.getGroupStartTime();
    }
}
