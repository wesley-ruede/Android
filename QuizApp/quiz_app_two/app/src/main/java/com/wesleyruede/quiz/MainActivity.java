package com.wesleyruede.quiz;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button trueButton;
    private Button falseButton;
    private ImageButton previousButton;
    private ImageButton nextButton;
    private TextView questionTextView;

    private Question[] questionBank = new Question[]{
            new Question(R.string.pq1,true),
            new Question(R.string.pq2,false),
            new Question(R.string.pq3,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        questionTextView = findViewById(R.id.question_text_view);
        previousButton = findViewById(R.id.previous_button);
        nextButton = findViewById(R.id.next_button);


        // Interface to override onClickListener
        // implement the onClickListener class
        // A class which allows multiple inheritance
        // onViewClicked
        // basically it makes it so all of these Views have
        // an onClickListener registered to them
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
    }

    // if the registered View, buttons are clicked do x,y,z
    // onViewClicked Interface to listen to true and false buttons
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.false_button:
                Log.d("", "onClick: ");
                break;
            case R.id.true_button:
                Log.d(" ", "onClick: ");
                break;
            case R.id.next_button:
                Log.d(" ", "onClick: ");
            case R.id.previous_button:
                Log.d(" ", "onClick: ");
        }
    }
}