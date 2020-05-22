package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

import java.util.List;

public class WednesdayActivity extends AppCompatActivity {
    //private ArrayList<Groups> groupsArrayList; --debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wesdnesday);
        DatabaseHandler db = new DatabaseHandler(WednesdayActivity.this);
        db.wednesdayAddGroup(new Groups(1,"Wednesday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.wednesdayAddGroup(new Groups(2,"Wednesday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.wednesdayAddGroup(new Groups(3,"Wednesday","Step//Sponsorship","12:00 PM","1:00 PM"));

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
        wednesdayGroupNameOne.setText(groupsList.get(9).getGroupDay());
        wednesdayGroupStartTimeOne.setText(groupsList.get(9).getGroupStartTime());
        wednesdayGroupEndTimeOne.setText(groupsList.get(9).getGroupEndTime());
        wednesdayGroupNameTwo.setText(groupsList.get(10).getGroupDay());
        wednesdayGroupStartTimeTwo.setText(groupsList.get(10).getGroupStartTime());
        wednesdayGroupEndTimeTwo.setText(groupsList.get(10).getGroupEndTime());
        wednesdayGroupNameThree.setText(groupsList.get(11).getGroupDay());
        wednesdayGroupStartTimeThree.setText(groupsList.get(11).getGroupStartTime());
        wednesdayGroupEndTimeThree.setText(groupsList.get(11).getGroupEndTime());

        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("friday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//                    +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
    }
}
