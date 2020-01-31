package com.wesleyruede.quiz2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// A Controller which takes the Question Model and displays the Views based on instructions

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button trueButton;
    private Button falseButton;
    private Button prevButton;
    private Button nextButton;
    private TextView questionTextView;
    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
            new Question(R.string.question_text,true),
            new Question(R.string.question1,true),
            new Question(R.string.question2,false),
            new Question(R.string.question3,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.previous_button);
        questionTextView = findViewById(R.id.text_view);

        // need to set up the buttons with onClickListener
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        // this context requires an interface OnCLick which enables
        // multiple inheritance and these buttons to be
        // registered to the onClickListener method from View
    }

    // all Views inside of the case are listening to be clicked
    // view.getId is using the literal layout elements
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.false_button:
                Log.d("FB", "False button clicked");
                checkAnswer(true);
                break;
            case R.id.true_button:
                Log.d("TB", "True button clicked");
                checkAnswer(false);
                break;
            case R.id.next_button:
                Log.d("NB", "Next button clicked");
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                updateQuestion();
                break;
            case R.id.previous_button:
                Log.d("PB", "Previous button clicked");
                if(currentQuestionIndex > 0){
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                    updateQuestion();
                }
        }
    }

    private void updateQuestion() {
        Log.d("Index", "onClick: " + currentQuestionIndex);
        // set TextView as Question for each string in the array from the string resources
        // when the index reaches the end of the array return to the beginning
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }

    private void checkAnswer(boolean userChoosesCorrect) {
        // get the correct output based on index in Question[] and check if it is true or false
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId;
        // if the user chooses the correct answer point to the res string, else point
        // to the other res string and finally toast based on the given string
        if(userChoosesCorrect == answerIsTrue) {
            toastMessageId = R.string.correct;
        }
        else toastMessageId = R.string.incorrect;
        Toast.makeText(MainActivity.this, toastMessageId,
                Toast.LENGTH_SHORT)
                .show();
    }
}