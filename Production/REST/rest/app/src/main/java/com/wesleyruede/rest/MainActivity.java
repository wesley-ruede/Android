package com.wesleyruede.rest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.wesleyruede.rest.data.DatabaseHandler;
import com.wesleyruede.rest.model.Groups;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidThreeTen.init(this);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Button button =  findViewById(R.id.complete_button_two);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        Groups mondayGroups = new Groups();
        mondayGroups.setGroupStartTime("2:04");
        mondayGroups.setGroupEndTime("4:45");
        mondayGroups.setGroupDay("Monday");
        mondayGroups.setGroupName("A Group");
        db.mondayAddGroup(mondayGroups);


        Log.d("MON", "onCreate: " + mondayGroups.getGroupStartTime() + " , " +mondayGroups.getGroupEndTime()+ " , " +mondayGroups.getGroupName());
    }
}
