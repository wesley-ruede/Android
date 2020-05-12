package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

public class SundayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunday);
        DatabaseHandler db = new DatabaseHandler(SundayActivity.this);
        db.sundayAddGroup(new Groups(1,"Sunday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.sundayAddGroup(new Groups(2,"Sunday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.sundayAddGroup(new Groups(3,"Sunday","Step//Sponsorship","12:00 PM","1:00 PM"));


    }
}
