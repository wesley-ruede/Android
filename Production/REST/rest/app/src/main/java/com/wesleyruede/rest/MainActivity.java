package com.wesleyruede.rest;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wesleyruede.rest.ui.ScheduleActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView mainBottomNav = findViewById(R.id.main_bottom_nav);
        mainBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home_nav:
                        return true;
                    case R.id.schedule_nav:
                        Intent mainScheduleIntent = new Intent(MainActivity.this, ScheduleActivity.class);
                        startActivity(mainScheduleIntent);
                        return true;
                }
                return false;
            }
        });
    }
}
