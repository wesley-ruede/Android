package com.wesleyruede.rest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.wesleyruede.rest.ui.ScheduleActivity;

public class MainActivity extends AppCompatActivity {
    private Button scheduleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidThreeTen.init(this);
        setContentView(R.layout.activity_main);
        scheduleButton = findViewById(R.id.schedule_button);
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });
        /*
        Groups groups = new Groups();
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        Groups monday_group_one = new Groups();
        monday_group_one.setGroupStartTime("9:00 AM");
        monday_group_one.setGroupEndTime("10:00 AM");
        monday_group_one.setGroupDay("Monday");
        monday_group_one.setGroupName("Daily reflection // Just for today");
        //db.mondayAddGroup(new Groups(1,"Monday","Step//Sponsorship","12:00 PM","1:00 PM"));
        //db.mondayAddGroup(new Groups(2,"Monday","All Recovery-YPR","8:15 PM","9:15 PM"));
        db.mondayAddGroup(monday_group_one);
        Log.d("MainActivity", "onCreate: " + monday_group_one.getGroupStartTime() + " , " +monday_group_one.getGroupEndTime()+ " , " +monday_group_one.getGroupName()+ " , " +monday_group_one.getGroupDay());*/


    }
}
