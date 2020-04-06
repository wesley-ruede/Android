package com.wesleyruede.testthree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener {
    private CheckBox boxOne,boxTwo,boxThree,boxFour,boxFive,boxSix;
    private Button completeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxOne = findViewById(R.id.check_box_one);
        boxTwo = findViewById(R.id.check_box_two);
        boxThree = findViewById(R.id.check_box_three);
        boxFour = findViewById(R.id.check_box_four);
        boxFive = findViewById(R.id.check_box_five);
        boxSix = findViewById(R.id.check_box_six);
        completeButton = findViewById(R.id.complete_button);

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewActivity.class);
                intent.putExtra("val","A really interesting sequence of steps");
                startActivity(intent);
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
