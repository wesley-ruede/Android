package com.example.addingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    // altering the main method
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // creating a reference the controls in the activity_main.xml

        // creating an object of the Button type
        /* using findViewById to search through resources and find an id called addBtn,
        cast as a button and store it as a reference to the addBtn variable that was created
        R = resources
        id = search through resources for an id */
        Button addBtn = (Button) findViewById(R.id.addBtn);
        // create an onClickListener which, while the app is running if the button is clicked then do this
        addBtn.setOnClickListener(new View.OnClickListener() {
            // this is added in automatically
            @Override
            public void onClick(View view) {
                // to here from auto completing new View.OnClickListener()
                // when the button is pressed get sum(firstNumEditText + secondNumEditText)
                // and return the results to be stored in resultTextView
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
                // must parse the numbers as they are integers in a TextView
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 + num2;
                resultTextView.setText(result + "");
            }
        });
    }
}