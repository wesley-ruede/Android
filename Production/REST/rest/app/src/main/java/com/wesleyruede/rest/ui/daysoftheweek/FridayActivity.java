package com.wesleyruede.rest.ui.daysoftheweek;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.wesleyruede.rest.R;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;
import java.util.ArrayList;
import java.util.List;

public class FridayActivity extends AppCompatActivity {
    private static final String TAG = "friday_activity";
    private ArrayList<Groups> groupsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friday);
        DatabaseHandler db = new DatabaseHandler(FridayActivity.this);
        groupsArrayList = new ArrayList<>();

        db.fridayAddGroup(new Groups(0,"Friday","Daily reflection//Just for today", "9:00 AM", "10:00 AM"));
        db.fridayAddGroup(new Groups(1,"Friday","Step//Sponsorship", "12:00 PM", "1:00 PM"));
        db.fridayAddGroup(new Groups(2,"Friday","Re entry", "2:00 PM", "3:00 PM"));

        TextView fridayGroupNameOne = findViewById(R.id.friday_group_name_one);
        TextView fridayGroupStartTimeOne = findViewById(R.id.friday_group_start_time_one);
        TextView fridayGroupEndTimeOne = findViewById(R.id.friday_group_end_time_one);
        TextView fridayGroupNameTwo = findViewById(R.id.friday_group_name_two);
        TextView fridayGroupStartTimeTwo = findViewById(R.id.friday_group_start_time_two);
        TextView fridayGroupEndTimeTwo = findViewById(R.id.friday_group_end_time_two);
        TextView fridayGroupNameThree = findViewById(R.id.friday_group_name_three);
        TextView fridayGroupStartTimeThree = findViewById(R.id.friday_group_start_time_three);
        TextView fridayGroupEndTimeThree = findViewById(R.id.friday_group_end_time_three);

        /* Explicitly indexing the database objects as */
        List<Groups> groupsList = db.getAllFridayGroups();
        fridayGroupNameOne.setText(groupsList.get(9).getGroupDay());
        fridayGroupStartTimeOne.setText(groupsList.get(9).getGroupStartTime());
        fridayGroupEndTimeOne.setText(groupsList.get(9).getGroupEndTime());
        fridayGroupNameTwo.setText(groupsList.get(10).getGroupDay());
        fridayGroupStartTimeTwo.setText(groupsList.get(10).getGroupStartTime());
        fridayGroupEndTimeTwo.setText(groupsList.get(10).getGroupEndTime());
        fridayGroupNameThree.setText(groupsList.get(11).getGroupDay());
        fridayGroupStartTimeThree.setText(groupsList.get(11).getGroupStartTime());
        fridayGroupEndTimeThree.setText(groupsList.get(11).getGroupEndTime());

        /* List and log all groups for debugging */
//        for(Groups groups: groupsList) {
//            Log.d("friday_activity", "onCreate: " +groups.getGroupName()+" , "+groups.getGroupStartTime()+" , "
//            +groups.getGroupEndTime());
//            groupsArrayList.add(groups);
//        }
        Log.d("friday_group_list", "onCreate: " +db.getAllFridayGroups());
    }
}