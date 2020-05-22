package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

import java.util.List;

public class SundayActivity extends AppCompatActivity {
    //private ArrayList<Groups> groupsArrayList; --debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunday);
        DatabaseHandler db = new DatabaseHandler(SundayActivity.this);
        //groupsArrayList = new ArrayList<>(); --debug
        db.sundayAddGroup(new Groups(1,"Sunday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.sundayAddGroup(new Groups(2,"Sunday","Step//Sponsorship","12:00 PM","1:00 PM"));
        db.sundayAddGroup(new Groups(3,"Sunday","Step//Sponsorship","12:00 PM","1:00 PM"));

        TextView sundayGroupNameOne = findViewById(R.id.sunday_group_name_one);
        TextView sundayGroupStartTimeOne = findViewById(R.id.sunday_group_start_time_one);
        TextView sundayGroupEndTimeOne = findViewById(R.id.sunday_group_end_time_one);
        TextView sundayGroupNameTwo = findViewById(R.id.sunday_group_name_two);
        TextView sundayGroupStartTimeTwo = findViewById(R.id.sunday_group_start_time_two);
        TextView sundayGroupEndTimeTwo = findViewById(R.id.sunday_group_end_time_two);
        TextView sundayGroupNameThree = findViewById(R.id.sunday_group_name_three);
        TextView sundayGroupStartTimeThree = findViewById(R.id.sunday_group_start_time_three);
        TextView sundayGroupEndTimeThree = findViewById(R.id.sunday_group_end_time_three);

        /* Explicitly indexing the database objects */
        List<Groups> groupsList = db.getAllSundayGroups();
        sundayGroupNameOne.setText(groupsList.get(9).getGroupDay());
        sundayGroupStartTimeOne.setText(groupsList.get(9).getGroupStartTime());
        sundayGroupEndTimeOne.setText(groupsList.get(9).getGroupEndTime());
        sundayGroupNameTwo.setText(groupsList.get(10).getGroupDay());
        sundayGroupStartTimeTwo.setText(groupsList.get(10).getGroupStartTime());
        sundayGroupEndTimeTwo.setText(groupsList.get(10).getGroupEndTime());
        sundayGroupNameThree.setText(groupsList.get(11).getGroupDay());
        sundayGroupStartTimeThree.setText(groupsList.get(11).getGroupStartTime());
        sundayGroupEndTimeThree.setText(groupsList.get(11).getGroupEndTime());

        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("friday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//                    +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
    }
}
