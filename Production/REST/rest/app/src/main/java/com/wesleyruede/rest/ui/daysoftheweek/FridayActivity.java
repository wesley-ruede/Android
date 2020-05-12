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
    private ArrayList<Groups> groupsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friday);
        DatabaseHandler db = new DatabaseHandler(FridayActivity.this);
        groupsArrayList = new ArrayList<>();
        TextView fridayGroupName = findViewById(R.id.friday_group_name);
        TextView fridayGroupStartTime = findViewById(R.id.friday_group_start_time);
        TextView fridayGroupEndTime = findViewById(R.id.friday_group_end_time);

        db.fridayAddGroup(new Groups(1,"Friday","Step//Sponsorship", "12:00 PM",
                "1:00 PM"));
        db.fridayAddGroup(new Groups(2,"Friday","Step//Sponsorship", "12:00 PM",
                "1:00 PM"));
        db.fridayAddGroup(new Groups(3,"Friday","Step//Sponsorship", "12:00 PM",
                "1:00 PM"));

        /* List all Groups */
        List<Groups> groupsList = db.getAllFridayGroups();
        for(Groups groups: groupsList) {
            Log.d("friday_activity", "onCreate: "
                    +groups.getGroupName() + " , "
                    +groups.getGroupStartTime() + " , "
                    +groups.getGroupEndTime());
            fridayGroupName.setText(groups.getGroupName());
            fridayGroupEndTime.setText(groups.getGroupStartTime());
            fridayGroupStartTime.setText(groups.getGroupEndTime());
            groupsArrayList.add(groups);
        }
        Log.d("friday_contact_count", "onCreate: " +db.getAllFridayGroups());
    }
}
