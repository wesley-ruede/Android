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

public class ThursdayActivity extends AppCompatActivity {
    //private ArrayList<Groups> groupsArrayList; --debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thursday);
        //groupsArrayList = new ArrayList<>(); --debug
        DatabaseHandler db = new DatabaseHandler(ThursdayActivity.this);
        /* Uncomment and insert the group data*/
        db.thursdayAddGroup(new Groups("Thursday","Daily reflection | Just for Today","9:00 AM","10:00 AM"));
        db.thursdayAddGroup(new Groups("Thursday","12 Step | Sponsorship","12:00 PM","1:00 PM"));
        db.thursdayAddGroup(new Groups("Thursday","HVN (Hearing voices network)","1:15 PM","2:45 PM"));
        db.thursdayAddGroup(new Groups("Thursday","WRAP","3:00 PM","4:00 PM"));

        TextView thursdayGroupNameOne = findViewById(R.id.thursday_group_name_one);
        TextView thursdayGroupStartTimeOne = findViewById(R.id.thursday_group_start_time_one);
        TextView thursdayGroupEndTimeOne = findViewById(R.id.thursday_group_end_time_one);
        TextView thursdayGroupNameTwo = findViewById(R.id.thursday_group_name_two);
        TextView thursdayGroupStartTimeTwo = findViewById(R.id.thursday_group_start_time_two);
        TextView thursdayGroupEndTimeTwo = findViewById(R.id.thursday_group_end_time_two);
        TextView thursdayGroupNameThree = findViewById(R.id.thursday_group_name_three);
        TextView thursdayGroupStartTimeThree = findViewById(R.id.thursday_group_start_time_three);
        TextView thursdayGroupEndTimeThree = findViewById(R.id.thursday_group_end_time_three);
        TextView thursdayGroupNameFour = findViewById(R.id.thursday_group_name_four);
        TextView thursdayGroupStartTimeFour = findViewById(R.id.thursday_group_start_time_four);
        TextView thursdayGroupEndTimeFour = findViewById(R.id.thursday_group_end_time_four);
        BottomNavigationView thursdayNavBar = findViewById(R.id.thursday_bottom_nav);
        /* Explicitly indexing the database objects */
        List<Groups> groupsList = db.getAllThursdayGroups();
        thursdayGroupNameOne.setText(groupsList.get(0).getGroupName());
        thursdayGroupStartTimeOne.setText(groupsList.get(0).getGroupStartTime());
        thursdayGroupEndTimeOne.setText(groupsList.get(0).getGroupEndTime());
        thursdayGroupNameTwo.setText(groupsList.get(1).getGroupName());
        thursdayGroupStartTimeTwo.setText(groupsList.get(1).getGroupStartTime());
        thursdayGroupEndTimeTwo.setText(groupsList.get(1).getGroupEndTime());
        thursdayGroupNameThree.setText(groupsList.get(2).getGroupName());
        thursdayGroupStartTimeThree.setText(groupsList.get(2).getGroupStartTime());
        thursdayGroupEndTimeThree.setText(groupsList.get(2).getGroupEndTime());
        thursdayGroupNameFour.setText(groupsList.get(3).getGroupName());
        thursdayGroupStartTimeFour.setText(groupsList.get(3).getGroupStartTime());
        thursdayGroupEndTimeFour.setText(groupsList.get(3).getGroupEndTime());

        thursdayNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_nav:
                        Intent thursday_home_intent = new Intent(ThursdayActivity.this, MainActivity.class);
                        startActivity(thursday_home_intent);
                        return true;
                    case R.id.schedule_nav:
                        Intent thursday_schedule_intent = new Intent(ThursdayActivity.this, ScheduleActivity.class);
                        startActivity(thursday_schedule_intent);
                        return true;
                }
                return false;
            }
        });
        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("friday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//                    +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
    }
}
