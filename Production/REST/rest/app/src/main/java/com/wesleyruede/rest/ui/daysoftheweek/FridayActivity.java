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

public class FridayActivity extends AppCompatActivity {
    //private ArrayList<Groups> groupsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friday);
        DatabaseHandler db = new DatabaseHandler(FridayActivity.this);
        BottomNavigationView fridayNavBar = findViewById(R.id.friday_bottom_nav);

        db.fridayAddGroup(new Groups("Friday","Daily reflection | Just for today", "9:00 AM", "10:00 AM"));
        db.fridayAddGroup(new Groups("Friday","Step | Sponsorship", "12:00 PM", "1:00 PM"));
        db.fridayAddGroup(new Groups("Friday","Re entry", "2:00 PM", "3:00 PM"));

        TextView fridayGroupNameOne = findViewById(R.id.friday_group_name_one);
        TextView fridayGroupStartTimeOne = findViewById(R.id.friday_group_start_time_one);
        TextView fridayGroupEndTimeOne = findViewById(R.id.friday_group_end_time_one);
        TextView fridayGroupNameTwo = findViewById(R.id.friday_group_name_two);
        TextView fridayGroupStartTimeTwo = findViewById(R.id.friday_group_start_time_two);
        TextView fridayGroupEndTimeTwo = findViewById(R.id.friday_group_end_time_two);
        TextView fridayGroupNameThree = findViewById(R.id.friday_group_name_three);
        TextView fridayGroupStartTimeThree = findViewById(R.id.friday_group_start_time_three);
        TextView fridayGroupEndTimeThree = findViewById(R.id.friday_group_end_time_three);

        /* Explicitly indexing the database objects as */
        List<Groups> groupsList = db.getAllFridayGroups();
        fridayGroupNameOne.setText(groupsList.get(0).getGroupName());
        fridayGroupStartTimeOne.setText(groupsList.get(0).getGroupStartTime());
        fridayGroupEndTimeOne.setText(groupsList.get(0).getGroupEndTime());
        fridayGroupNameTwo.setText(groupsList.get(1).getGroupName());
        fridayGroupStartTimeTwo.setText(groupsList.get(1).getGroupStartTime());
        fridayGroupEndTimeTwo.setText(groupsList.get(1).getGroupEndTime());
        fridayGroupNameThree.setText(groupsList.get(2).getGroupName());
        fridayGroupStartTimeThree.setText(groupsList.get(2).getGroupStartTime());
        fridayGroupEndTimeThree.setText(groupsList.get(2).getGroupEndTime());

        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("friday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//            +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
        //Log.d("friday_group_list", "onCreate: " +db.getAllFridayGroups());

        fridayNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_nav:
                        Intent friday_home_intent = new Intent(FridayActivity.this, MainActivity.class);
                        startActivity(friday_home_intent);
                        return true;
                    case R.id.schedule_nav:
                        Intent thursday_schedule_intent = new Intent(FridayActivity.this, ScheduleActivity.class);
                        startActivity(thursday_schedule_intent);
                        return true;
                }
                return false;
            }
        });
    }
}