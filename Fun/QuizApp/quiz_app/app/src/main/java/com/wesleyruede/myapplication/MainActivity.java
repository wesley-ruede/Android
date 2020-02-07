package com.wesleyruede.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private TextView questionTextView;
    private ImageButton nextButton;
    private ImageButton previousButton;

    private int questionIndex = 0;

    // string array for the buttons to move through
    private Question[] questionBank = new Question[] {
            new Question(R.string.question00,true),
            new Question(R.string.question01,false),
            new Question(R.string.question02,true),
            new Question(R.string.question03,false),
            new Question(R.string.question04,false),
            new Question(R.string.question05,true),
            new Question(R.string.question06,true),
            new Question(R.string.question07,true),
            new Question(R.string.question1,false),
            new Question(R.string.question2,true),
            new Question(R.string.question3,true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        questionTextView = findViewById(R.id.question_text);
        nextButton = findViewById(R.id.next_button);
        previousButton = findViewById(R.id.previous_button);

        // Interface to override onClickListener implement the
        // onClickListener class A class which allows multiple inheritance
        // onViewClicked basically it makes it so all of these Views have
        // an onClickListener registered to them

        // register buttons to listen for click events
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
    }
    // if the registered View, buttons are clicked do x,y,z
    // onViewClicked Interface to listen to true and false buttons

    // a quick message when the buttons are pressed
    @Override
    public void onClick(View view) {
        // allow access to all resources by id
        switch (view.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;
            case R.id.next_button:
                // step forward in the Question[] and increment each time the button is clicked
                questionIndex = (questionIndex + 1) % questionBank.length;
                updateQuestion();
                break;
            case R.id.previous_button:
                // ensure index does not go backwards to -1
                if (questionIndex > 0) {
                    questionIndex = (questionIndex - 1) % questionBank.length;
                    updateQuestion();
                }
        }
    }
    // refactor to stream line question checking and updating the textView
    private void updateQuestion() {
        Log.d("next button","onCLick " + questionIndex);
        questionTextView.setText(questionBank[questionIndex].getAnswerResId());
    }

    // call to Question class to check if the returned value is true or false
    private void checkAnswer(boolean userChoosesCorrect) {
        boolean  answerIsTrue = questionBank[questionIndex].isAnswerTrue();
        int toastMessageId;

        if(userChoosesCorrect == answerIsTrue) {
            toastMessageId = R.string.correct;
        } else {
            toastMessageId = R.string.incorrect;
        }
        // show the correct string based the returned true or false boolean value
        Toast.makeText(MainActivity.this,toastMessageId,Toast.LENGTH_SHORT).show();
    }
}