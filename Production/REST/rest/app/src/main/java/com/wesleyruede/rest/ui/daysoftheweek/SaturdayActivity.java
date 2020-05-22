package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

import java.util.List;

public class SaturdayActivity extends AppCompatActivity {
    // private ArrayList<Groups> groupsArrayList; --debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturday);
        //groupsArrayList = new ArrayList<>(); --debug
        DatabaseHandler db = new DatabaseHandler(SaturdayActivity.this);
        db.saturdayAddGroup(new Groups(1,"Saturday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.saturdayAddGroup(new Groups(2,"Saturday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.saturdayAddGroup(new Groups(3,"Saturday","Step//Sponsorship","12:00 PM","1:00 PM"));

        TextView saturdayGroupNameOne = findViewById(R.id.saturday_group_name_one);
        TextView saturdayGroupStartTimeOne = findViewById(R.id.saturday_group_start_time_one);
        TextView saturdayGroupEndTimeOne = findViewById(R.id.saturday_group_end_time_one);
        TextView saturdayGroupNameTwo = findViewById(R.id.saturday_group_name_two);
        TextView saturdayGroupStartTimeTwo = findViewById(R.id.saturday_group_start_time_two);
        TextView saturdayGroupEndTimeTwo = findViewById(R.id.saturday_group_end_time_two);
        TextView saturdayGroupNameThree = findViewById(R.id.saturday_group_name_three);
        TextView saturdayGroupStartTimeThree = findViewById(R.id.saturday_group_start_time_three);
        TextView saturdayGroupEndTimeThree = findViewById(R.id.saturday_group_end_time_three);

        /* Explicitly indexing the database objects */
        List<Groups> groupsList = db.getAllSaturdayGroups();
        saturdayGroupNameOne.setText(groupsList.get(9).getGroupDay());
        saturdayGroupStartTimeOne.setText(groupsList.get(9).getGroupStartTime());
        saturdayGroupEndTimeOne.setText(groupsList.get(9).getGroupEndTime());
        saturdayGroupNameTwo.setText(groupsList.get(10).getGroupDay());
        saturdayGroupStartTimeTwo.setText(groupsList.get(10).getGroupStartTime());
        saturdayGroupEndTimeTwo.setText(groupsList.get(10).getGroupEndTime());
        saturdayGroupNameThree.setText(groupsList.get(11).getGroupDay());
        saturdayGroupStartTimeThree.setText(groupsList.get(11).getGroupStartTime());
        saturdayGroupEndTimeThree.setText(groupsList.get(11).getGroupEndTime());

        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("friday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//            +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
    }
}
