package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

public class SaturdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturday);
        DatabaseHandler db = new DatabaseHandler(SaturdayActivity.this);
        db.saturdayAddGroup(new Groups(1,"Saturday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.saturdayAddGroup(new Groups(2,"Saturday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.saturdayAddGroup(new Groups(3,"Saturday","Step//Sponsorship","12:00 PM","1:00 PM"));

    }
}
