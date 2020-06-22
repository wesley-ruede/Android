package com.wesleyruede.rest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.wesleyruede.rest.ui.ScheduleActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAIN";
    private Button scheduleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d(TAG, "onCreate: MainActivity");
        scheduleButton = findViewById(R.id.schedule_button);
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Button Clicked");
                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                startActivity(intent);
                Log.d(TAG, "onClick: Activity Started");
            }
        });
    }
}
