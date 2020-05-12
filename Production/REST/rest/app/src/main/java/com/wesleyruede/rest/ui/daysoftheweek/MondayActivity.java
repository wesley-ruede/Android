package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

public class MondayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
        DatabaseHandler db = new DatabaseHandler(MondayActivity.this);
        db.mondayAddGroup(new Groups(1,"Monday","Step//Sponsorship",
                "12:00 PM","1:00 PM"));
        db.mondayAddGroup(new Groups(2,"Monday","Step//Sponsorship",
                "12:00 PM","1:00 PM"));
        db.mondayAddGroup(new Groups(3,"Monday","Step//Sponsorship",
                "12:00 PM","1:00 PM"));
    }
}
