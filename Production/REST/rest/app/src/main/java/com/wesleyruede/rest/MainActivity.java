package com.wesleyruede.rest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidThreeTen.init(this);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Button button =  findViewById(R.id.complete_button_two);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        Groups monday_group_one = new Groups();
        monday_group_one.setGroupStartTime("9:00 AM");
        monday_group_one.setGroupEndTime("10:00 AM");
        monday_group_one.setGroupDay("Monday");
        monday_group_one.setGroupName("Daily reflection // Just for today");
        //db.mondayAddGroup(new Groups(1,"Monday","Step//Sponsorship","12:00 PM","1:00 PM"));
        //db.mondayAddGroup(new Groups(2,"Monday","All Recovery-YPR","8:15 PM","9:15 PM"));
        db.mondayAddGroup(monday_group_one);

        Log.d("MON", "onCreate: " + monday_group_one.getGroupStartTime() + " , " +monday_group_one.getGroupEndTime()+ " , " +monday_group_one.getGroupName()+ " , " +monday_group_one.getGroupDay());
    }
}
