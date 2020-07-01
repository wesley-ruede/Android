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

public class TuesdayActivity extends AppCompatActivity {
    //private ArrayList<Groups> groupsArrayList; --debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);
        DatabaseHandler db = new DatabaseHandler(TuesdayActivity.this);
        db.tuesdayAddGroup(new Groups("tuesday","Daily reflection|Just for today","9:00 AM","10:00 AM"));
        db.tuesdayAddGroup(new Groups("tuesday","12 Step|Sponsorship","12:00 PM","1:00 PM"));
        db.tuesdayAddGroup(new Groups("tuesday","Women's through the 12 steps","1:00 PM","2:30 PM"));

        TextView tuesdayGroupNameOne = findViewById(R.id.tuesday_group_name_one);
        TextView tuesdayGroupStartTimeOne = findViewById(R.id.tuesday_group_start_time_one);
        TextView tuesdayGroupEndTimeOne = findViewById(R.id.tuesday_group_end_time_one);
        TextView tuesdayGroupNameTwo = findViewById(R.id.tuesday_group_name_two);
        TextView tuesdayGroupStartTimeTwo = findViewById(R.id.tuesday_group_start_time_two);
        TextView tuesdayGroupEndTimeTwo = findViewById(R.id.tuesday_group_end_time_two);
        TextView tuesdayGroupNameThree = findViewById(R.id.tuesday_group_name_three);
        TextView tuesdayGroupStartTimeThree = findViewById(R.id.tuesday_group_start_time_three);
        TextView tuesdayGroupEndTimeThree = findViewById(R.id.tuesday_group_end_time_three);

        /* Explicitly indexing the database objects */
        List<Groups> groupsList = db.getAllTuesdayGroups();
        tuesdayGroupNameOne.setText(groupsList.get(0).getGroupName());
        tuesdayGroupStartTimeOne.setText(groupsList.get(0).getGroupStartTime());
        tuesdayGroupEndTimeOne.setText(groupsList.get(0).getGroupEndTime());
        tuesdayGroupNameTwo.setText(groupsList.get(1).getGroupName());
        tuesdayGroupStartTimeTwo.setText(groupsList.get(1).getGroupStartTime());
        tuesdayGroupEndTimeTwo.setText(groupsList.get(1).getGroupEndTime());
        tuesdayGroupNameThree.setText(groupsList.get(2).getGroupName());
        tuesdayGroupStartTimeThree.setText(groupsList.get(2).getGroupStartTime());
        tuesdayGroupEndTimeThree.setText(groupsList.get(2).getGroupEndTime());

        BottomNavigationView tuesdayBottomNav = findViewById(R.id.tuesday_bottom_nav);
        tuesdayBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_nav:
                        Intent tuesdayHomeIntent = new Intent(TuesdayActivity.this, MainActivity.class);
                        startActivity(tuesdayHomeIntent);
                    case R.id.schedule_nav:
                        Intent tuesdayScheduleIntent = new Intent(TuesdayActivity.this, ScheduleActivity.class);
                        startActivity(tuesdayScheduleIntent);
                }
                return false;
            }
        });
        //groupsArrayList = new ArrayList<>(); --debug
        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("friday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//                    +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
    }
}
