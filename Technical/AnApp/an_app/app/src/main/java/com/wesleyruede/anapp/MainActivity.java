package com.wesleyruede.anapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView showText;
    private EditText changeText;
    private Button changeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showText = findViewById(R.id.text_placement);
        changeButton = findViewById(R.id.change_text_button);
        changeText = findViewById(R.id.enter_text);

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String place_holder_text = changeText.getText().toString().trim();
                showText.setText(place_holder_text);
            }
        });
    }
}