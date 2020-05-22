package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;
import java.util.List;

public class MondayActivity extends AppCompatActivity {
    //private ArrayList<Groups> groupsArrayList; --debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
        DatabaseHandler db = new DatabaseHandler(MondayActivity.this);
        //groupsArrayList = new ArrayList<>(); --debug
        db.mondayAddGroup(new Groups(1,"Monday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.mondayAddGroup(new Groups(2,"Monday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.mondayAddGroup(new Groups(3,"Monday","Step//Sponsorship","12:00 PM","1:00 PM"));
        
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
        mondayGroupNameOne.setText(groupsList.get(9).getGroupDay());
        mondayGroupStartTimeOne.setText(groupsList.get(9).getGroupStartTime());
        mondayGroupEndTimeOne.setText(groupsList.get(9).getGroupEndTime());
        mondayGroupNameTwo.setText(groupsList.get(10).getGroupDay());
        mondayGroupStartTimeTwo.setText(groupsList.get(10).getGroupStartTime());
        mondayGroupEndTimeTwo.setText(groupsList.get(10).getGroupEndTime());
        mondayGroupNameThree.setText(groupsList.get(11).getGroupDay());
        mondayGroupStartTimeThree.setText(groupsList.get(11).getGroupStartTime());
        mondayGroupEndTimeThree.setText(groupsList.get(11).getGroupEndTime());

        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("friday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//                    +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
    }
}
