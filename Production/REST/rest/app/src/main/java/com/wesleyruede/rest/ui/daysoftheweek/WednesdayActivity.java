package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

public class WednesdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wesdnesday);
        DatabaseHandler db = new DatabaseHandler(WednesdayActivity.this);
        db.wednesdayAddGroup(new Groups(1,"Wednesday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.wednesdayAddGroup(new Groups(2,"Wednesday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.wednesdayAddGroup(new Groups(3,"Wednesday","Step//Sponsorship","12:00 PM","1:00 PM"));
    }
}
