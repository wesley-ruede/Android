package com.wesleyruede.testthree;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private CheckBox boxOne,boxTwo,boxThree,boxFour,boxFive,boxSix;
    private BottomNavigationView bottomNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavBar = findViewById(R.id.bottom_nav_bar);
        boxOne = findViewById(R.id.check_box_one);
        boxTwo = findViewById(R.id.check_box_two);
        boxThree = findViewById(R.id.check_box_three);
        boxFour = findViewById(R.id.check_box_four);
        boxFive = findViewById(R.id.check_box_five);
        boxSix = findViewById(R.id.check_box_six);
        Button completeButton = findViewById(R.id.complete_button);
        boxOne.setOnCheckedChangeListener(this);
        boxTwo.setOnCheckedChangeListener(this);
        boxThree.setOnCheckedChangeListener(this);
        boxFour.setOnCheckedChangeListener(this);
        boxFive.setOnCheckedChangeListener(this);
        boxSix.setOnCheckedChangeListener(this);
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                intent.putExtra("val","A really interesting sequence of steps");
                startActivity(intent);
            }
        });

        bottomNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.schedule:
                        Intent intent_schedule = new Intent(MainActivity.this,ScheduleActivity.class);
                        startActivity(intent_schedule);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton box, boolean isChecked) {
        switch (box.getId()) {
            case R.id.check_box_one:
                break;
            case R.id.check_box_two:
                break;
            case R.id.check_box_three:
                break;
            case R.id.check_box_four:
                break;
            case R.id.check_box_five:
                break;
            case R.id.check_box_six:
                break;
        }
    }
}
