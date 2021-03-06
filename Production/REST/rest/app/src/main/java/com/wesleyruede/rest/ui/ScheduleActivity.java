package com.wesleyruede.rest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wesleyruede.rest.MainActivity;
import com.wesleyruede.rest.R;
import com.wesleyruede.rest.ui.daysoftheweek.FridayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.MondayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.SaturdayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.SundayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.ThursdayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.TuesdayActivity;
import com.wesleyruede.rest.ui.daysoftheweek.WednesdayActivity;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Button mondayButton = findViewById(R.id.monday_button);
        Button tuesdayButton = findViewById(R.id.tuesday_button);
        Button wednesdayButton = findViewById(R.id.wednesday_button);
        Button thursdayButton = findViewById(R.id.thursday_button);
        Button fridayButton = findViewById(R.id.friday_button);
        Button saturdayButton = findViewById(R.id.saturday_button);
        Button sundayButton = findViewById(R.id.sunday_button);
        mondayButton.setOnClickListener(this);
        tuesdayButton.setOnClickListener(this);
        wednesdayButton.setOnClickListener(this);
        thursdayButton.setOnClickListener(this);
        fridayButton.setOnClickListener(this);
        saturdayButton.setOnClickListener(this);
        sundayButton.setOnClickListener(this);
        BottomNavigationView scheduleBottomNav = findViewById(R.id.schedule_nav);
        scheduleBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_nav:
                        Intent scheduleHomeNav = new Intent(ScheduleActivity.this, MainActivity.class);
                        startActivity(scheduleHomeNav);
                        return true;
                    case R.id.schedule_nav:
                        return true;
                }
                return false;
            }
        });
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
                break;
            case R.id.sunday_button:
                Intent sunday_intent = new Intent(ScheduleActivity.this, SundayActivity.class);
                startActivity(sunday_intent);
                break;
        }
    }
}
