package com.wesleyruede.rest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.wesleyruede.rest.R;
import com.wesleyruede.rest.ui.daysoftheweek.FridayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.MondayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.SaturdayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.SundayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.ThursdayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.TuesdayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.WednesdayActivity;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mondayButton,tuesdayButton,wednesdayButton,thursdayButton,fridayButton,saturdayButton,sundayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        mondayButton = findViewById(R.id.monday_button);
        tuesdayButton = findViewById(R.id.tuesday_button);
        wednesdayButton = findViewById(R.id.wednesday_button);
        thursdayButton = findViewById(R.id.thursday_button);
        fridayButton = findViewById(R.id.friday_button);
        saturdayButton = findViewById(R.id.saturday_button);
        sundayButton = findViewById(R.id.sunday_button);
        mondayButton.setOnClickListener(this);
        tuesdayButton.setOnClickListener(this);
        wednesdayButton.setOnClickListener(this);
        thursdayButton.setOnClickListener(this);
        fridayButton.setOnClickListener(this);
        saturdayButton.setOnClickListener(this);
        sundayButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.monday_button:
                Intent monday_intent = new Intent(ScheduleActivity.this, MondayActivity.class);
                startActivity(monday_intent);
                break;
            case R.id.tuesday_button:
                Intent tuesday_intent = new Intent(ScheduleActivity.this, TuesdayActivity.class);
                startActivity(tuesday_intent);
                break;
            case R.id.wednesday_button:
                Intent wednesday_intent = new Intent(ScheduleActivity.this, WednesdayActivity.class);
                startActivity(wednesday_intent);
                break;
            case R.id.thursday_button:
                Intent thursday_intent = new Intent(ScheduleActivity.this, ThursdayActivity.class);
                startActivity(thursday_intent);
                break;
            case R.id.friday_button:
                Intent friday_intent = new Intent(ScheduleActivity.this, FridayActivity.class);
                startActivity(friday_intent);
                break;
            case R.id.saturday_button:
                Intent saturday_intent = new Intent(ScheduleActivity.this, SaturdayActivity.class);
                startActivity(saturday_intent);
            case R.id.sunday_button:
                Intent sunday_intent = new Intent(ScheduleActivity.this, SundayActivity.class);
                startActivity(sunday_intent);
        }
    }
}
