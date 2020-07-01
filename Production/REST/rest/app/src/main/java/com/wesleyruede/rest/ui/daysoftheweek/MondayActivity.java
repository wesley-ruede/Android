package com.wesleyruede.rest.ui.daysoftheweek;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wesleyruede.rest.MainActivity;
import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;
import com.wesleyruede.rest.ui.ScheduleActivity;

import java.util.List;

public class MondayActivity extends AppCompatActivity {
    //private ArrayList<Groups> groupsArrayList; --debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
        DatabaseHandler db = new DatabaseHandler(MondayActivity.this);
        BottomNavigationView mondayBottomNav = findViewById(R.id.monday_bottom_nav);
        //groupsArrayList = new ArrayList<>(); --debug
        db.mondayAddGroup(new Groups("monday","Daily reflection | Just for today", "9:00 AM", "10:00 AM"));
        db.mondayAddGroup(new Groups("monday","Step | Sponsorship", "12:00 PM", "1:00 PM"));
        db.mondayAddGroup(new Groups("monday","All Recovery-YPR","8:15 PM","9:15 PM"));
        
        TextView mondayGroupNameOne = findViewById(R.id.monday_group_name_one);
        TextView mondayGroupStartTimeOne = findViewById(R.id.monday_group_start_time_one);
        TextView mondayGroupEndTimeOne = findViewById(R.id.monday_group_end_time_one);
        TextView mondayGroupNameTwo = findViewById(R.id.monday_group_name_two);
        TextView mondayGroupStartTimeTwo = findViewById(R.id.monday_group_start_time_two);
        TextView mondayGroupEndTimeTwo = findViewById(R.id.monday_group_end_time_two);
        TextView mondayGroupNameThree = findViewById(R.id.monday_group_name_three);
        TextView mondayGroupStartTimeThree = findViewById(R.id.monday_group_start_time_three);
        TextView mondayGroupEndTimeThree = findViewById(R.id.monday_group_end_time_three);

        /* Explicitly indexing the database objects */
        List<Groups> groupsList = db.getAllMondayGroups();
        mondayGroupNameOne.setText(groupsList.get(0).getGroupName());
        mondayGroupStartTimeOne.setText(groupsList.get(0).getGroupStartTime());
        mondayGroupEndTimeOne.setText(groupsList.get(0).getGroupEndTime());
        mondayGroupNameTwo.setText(groupsList.get(1).getGroupName());
        mondayGroupStartTimeTwo.setText(groupsList.get(1).getGroupStartTime());
        mondayGroupEndTimeTwo.setText(groupsList.get(1).getGroupEndTime());
        mondayGroupNameThree.setText(groupsList.get(2).getGroupName());
        mondayGroupStartTimeThree.setText(groupsList.get(2).getGroupStartTime());
        mondayGroupEndTimeThree.setText(groupsList.get(2).getGroupEndTime());
        mondayBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_nav:
                        Intent mondayHomeIntent = new Intent(MondayActivity.this, MainActivity.class);
                        startActivity(mondayHomeIntent);
                    case R.id.schedule_nav:
                        Intent mondayScheduleIntent = new Intent(MondayActivity.this, ScheduleActivity.class);
                        startActivity(mondayScheduleIntent);
                }
                return false;
            }
        });

        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("monday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//                    +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
    }
}
