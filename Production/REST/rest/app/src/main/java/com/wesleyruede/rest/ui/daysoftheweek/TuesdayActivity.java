package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

public class TuesdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);
        DatabaseHandler db = new DatabaseHandler(TuesdayActivity.this);
        db.tuesdayAddGroup(new Groups(1,"Tuesday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.tuesdayAddGroup(new Groups(2,"Tuesday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.tuesdayAddGroup(new Groups(3,"Tuesday","Step//Sponsorship","12:00 PM","1:00 PM"));
    }
}
