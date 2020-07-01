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

public class WednesdayActivity extends AppCompatActivity {
    //private ArrayList<Groups> groupsArrayList; --debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wesdnesday);
        DatabaseHandler db = new DatabaseHandler(WednesdayActivity.this);
        db.wednesdayAddGroup(new Groups("wednesday","Daily reflection|Just for today","0:00 AM","10:00 AM"));
        db.wednesdayAddGroup(new Groups("wednesday","12 Step|Sponsorship","12:00 PM","1:00 PM"));
        db.wednesdayAddGroup(new Groups("wednesday","Smart Recovery","7:00 PM","8:30 PM"));

        TextView wednesdayGroupNameOne = findViewById(R.id.wednesday_group_name_one);
        TextView wednesdayGroupStartTimeOne = findViewById(R.id.wednesday_group_start_time_one);
        TextView wednesdayGroupEndTimeOne = findViewById(R.id.wednesday_group_end_time_one);
        TextView wednesdayGroupNameTwo = findViewById(R.id.wednesday_group_name_two);
        TextView wednesdayGroupStartTimeTwo = findViewById(R.id.wednesday_group_start_time_two);
        TextView wednesdayGroupEndTimeTwo = findViewById(R.id.wednesday_group_end_time_two);
        TextView wednesdayGroupNameThree = findViewById(R.id.wednesday_group_name_three);
        TextView wednesdayGroupStartTimeThree = findViewById(R.id.wednesday_group_start_time_three);
        TextView wednesdayGroupEndTimeThree = findViewById(R.id.wednesday_group_end_time_three);

        /* Explicitly indexing the database objects */
        List<Groups> groupsList = db.getAllWednesdayGroups();
        wednesdayGroupNameOne.setText(groupsList.get(0).getGroupName());
        wednesdayGroupStartTimeOne.setText(groupsList.get(0).getGroupStartTime());
        wednesdayGroupEndTimeOne.setText(groupsList.get(0).getGroupEndTime());
        wednesdayGroupNameTwo.setText(groupsList.get(1).getGroupName());
        wednesdayGroupStartTimeTwo.setText(groupsList.get(1).getGroupStartTime());
        wednesdayGroupEndTimeTwo.setText(groupsList.get(1).getGroupEndTime());
        wednesdayGroupNameThree.setText(groupsList.get(2).getGroupName());
        wednesdayGroupStartTimeThree.setText(groupsList.get(2).getGroupStartTime());
        wednesdayGroupEndTimeThree.setText(groupsList.get(2).getGroupEndTime());

        BottomNavigationView wednesdayBottomNav = findViewById(R.id.wednesday_bottom_nav);
        wednesdayBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_nav:
                        Intent wednesdayHomeIntent = new Intent(WednesdayActivity.this, MainActivity.class);
                        startActivity(wednesdayHomeIntent);
                    case R.id.schedule_nav:
                        Intent wednesdayScheduleIntent = new Intent(WednesdayActivity.this, ScheduleActivity.class);
                        startActivity(wednesdayScheduleIntent);
                }
                return false;
            }
        });
        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("wednesday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//                    +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
    }
}
