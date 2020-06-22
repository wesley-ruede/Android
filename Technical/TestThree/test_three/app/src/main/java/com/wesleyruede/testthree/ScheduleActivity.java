package com.wesleyruede.testthree;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ScheduleActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavBarSch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        bottomNavBarSch = findViewById(R.id.bottom_nav_bar_sch);

        bottomNavBarSch.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent home_intent = new Intent(ScheduleActivity.this,MainActivity.class);
                        startActivity(home_intent);
                        return true;
                    case R.id.schedule:
                        return true;
                }
                return false;
            }
        });
    }
}
