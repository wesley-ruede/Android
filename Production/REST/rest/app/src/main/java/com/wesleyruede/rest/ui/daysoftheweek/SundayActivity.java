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

public class SundayActivity extends AppCompatActivity {
    //private ArrayList<Groups> groupsArrayList; --debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunday);
        DatabaseHandler db = new DatabaseHandler(SundayActivity.this);
        //groupsArrayList = new ArrayList<>(); --debug

        db.sundayAddGroup(new Groups("sunday","Step | Sponsorship", "12:00 PM", "1:00 PM"));
        db.sundayAddGroup(new Groups("sunday","Keep it simple", "8:15 PM", "9:15 PM"));
        TextView sundayGroupNameOne = findViewById(R.id.sunday_group_name_one);
        TextView sundayGroupStartTimeOne = findViewById(R.id.sunday_group_start_time_one);
        TextView sundayGroupEndTimeOne = findViewById(R.id.sunday_group_end_time_one);
        TextView sundayGroupNameTwo = findViewById(R.id.sunday_group_name_two);
        TextView sundayGroupStartTimeTwo = findViewById(R.id.sunday_group_start_time_two);
        TextView sundayGroupEndTimeTwo = findViewById(R.id.sunday_group_end_time_two);


        /* Explicitly indexing the database objects */
        List<Groups> groupsList = db.getAllSundayGroups();
        sundayGroupNameOne.setText(groupsList.get(0).getGroupName());
        sundayGroupStartTimeOne.setText(groupsList.get(0).getGroupStartTime());
        sundayGroupEndTimeOne.setText(groupsList.get(0).getGroupEndTime());
        sundayGroupNameTwo.setText(groupsList.get(1).getGroupName());
        sundayGroupStartTimeTwo.setText(groupsList.get(1).getGroupStartTime());
        sundayGroupEndTimeTwo.setText(groupsList.get(1).getGroupEndTime());


        BottomNavigationView sundayBottomNav = findViewById(R.id.sunday_bottom_nav);
        sundayBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_nav:
                        Intent sundayHomeIntent = new Intent(SundayActivity.this, MainActivity.class);
                        startActivity(sundayHomeIntent);
                    case R.id.schedule_nav:
                        Intent mondayScheduleIntent = new Intent(SundayActivity.this, ScheduleActivity.class);
                        startActivity(mondayScheduleIntent);
                }
                return false;
            }
        });
        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("sunday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//                    +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
    }
}
