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

public class SaturdayActivity extends AppCompatActivity {
    // private ArrayList<Groups> groupsArrayList; --debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturday);
        //groupsArrayList = new ArrayList<>(); --debug
        DatabaseHandler db = new DatabaseHandler(SaturdayActivity.this);
        db.saturdayAddGroup(new Groups("saturday","Step | Sponsorship", "12:00 PM", "1:00 PM"));

        TextView saturdayGroupNameOne = findViewById(R.id.saturday_group_name_one);
        TextView saturdayGroupStartTimeOne = findViewById(R.id.saturday_group_start_time_one);
        TextView saturdayGroupEndTimeOne = findViewById(R.id.saturday_group_end_time_one);

        /* Explicitly indexing the database objects */
        List<Groups> groupsList = db.getAllSaturdayGroups();
        saturdayGroupNameOne.setText(groupsList.get(0).getGroupName());
        saturdayGroupStartTimeOne.setText(groupsList.get(0).getGroupStartTime());
        saturdayGroupEndTimeOne.setText(groupsList.get(0).getGroupEndTime());

        BottomNavigationView saturdayBottomNav = findViewById(R.id.saturday_bottom_nav);
        saturdayBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_nav:
                        Intent saturdayHomeIntent = new Intent(SaturdayActivity.this, MainActivity.class);
                        startActivity(saturdayHomeIntent);
                    case R.id.schedule_nav:
                        Intent mondayScheduleIntent = new Intent(SaturdayActivity.this, ScheduleActivity.class);
                        startActivity(mondayScheduleIntent);
                }
                return false;
            }
        });
        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("saturday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//            +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
    }
}
