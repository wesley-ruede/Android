package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

public class ThursdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thursday);
        DatabaseHandler db = new DatabaseHandler(ThursdayActivity.this);
        db.thursdayAddGroup(new Groups(1,"Thursday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.thursdayAddGroup(new Groups(2,"Thursday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.thursdayAddGroup(new Groups(3,"Thursday","Step//Sponsorship","12:00 PM","1:00 PM"));

    }
}
