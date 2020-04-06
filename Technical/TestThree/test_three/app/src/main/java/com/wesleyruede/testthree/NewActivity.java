package com.wesleyruede.testthree;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        text = findViewById(R.id.new_text);

        Intent intent = getIntent();
        String intent_text = intent.getStringExtra("val");

        text.setText(intent_text);
    }
}
