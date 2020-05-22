package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

import java.util.List;

public class ThursdayActivity extends AppCompatActivity {
    //private ArrayList<Groups> groupsArrayList; --debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thursday);
        //groupsArrayList = new ArrayList<>(); --debug
        DatabaseHandler db = new DatabaseHandler(ThursdayActivity.this);
        db.thursdayAddGroup(new Groups(1,"Thursday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.thursdayAddGroup(new Groups(2,"Thursday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.thursdayAddGroup(new Groups(3,"Thursday","Step//Sponsorship","12:00 PM","1:00 PM"));

        TextView thursdayGroupNameOne = findViewById(R.id.thursday_group_name_one);
        TextView thursdayGroupStartTimeOne = findViewById(R.id.thursday_group_start_time_one);
        TextView thursdayGroupEndTimeOne = findViewById(R.id.thursday_group_end_time_one);
        TextView thursdayGroupNameTwo = findViewById(R.id.thursday_group_name_two);
        TextView thursdayGroupStartTimeTwo = findViewById(R.id.thursday_group_start_time_two);
        TextView thursdayGroupEndTimeTwo = findViewById(R.id.thursday_group_end_time_two);
        TextView thursdayGroupNameThree = findViewById(R.id.thursday_group_name_three);
        TextView thursdayGroupStartTimeThree = findViewById(R.id.thursday_group_start_time_three);
        TextView thursdayGroupEndTimeThree = findViewById(R.id.thursday_group_end_time_three);

        /* Explicitly indexing the database objects */
        List<Groups> groupsList = db.getAllThursdayGroups();
        thursdayGroupNameOne.setText(groupsList.get(9).getGroupDay());
        thursdayGroupStartTimeOne.setText(groupsList.get(9).getGroupStartTime());
        thursdayGroupEndTimeOne.setText(groupsList.get(9).getGroupEndTime());
        thursdayGroupNameTwo.setText(groupsList.get(10).getGroupDay());
        thursdayGroupStartTimeTwo.setText(groupsList.get(10).getGroupStartTime());
        thursdayGroupEndTimeTwo.setText(groupsList.get(10).getGroupEndTime());
        thursdayGroupNameThree.setText(groupsList.get(11).getGroupDay());
        thursdayGroupStartTimeThree.setText(groupsList.get(11).getGroupStartTime());
        thursdayGroupEndTimeThree.setText(groupsList.get(11).getGroupEndTime());

        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("friday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//                    +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
    }
}
