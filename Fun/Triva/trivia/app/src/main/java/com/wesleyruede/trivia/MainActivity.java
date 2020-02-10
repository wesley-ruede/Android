package com.wesleyruede.trivia;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.wesleyruede.trivia.data.AnswerListAsyncResponse;
import com.wesleyruede.trivia.data.QuestionBank;
import com.wesleyruede.trivia.model.Question;
import com.wesleyruede.trivia.model.Score;
import com.wesleyruede.trivia.util.Prefs;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

// This Trivia app is created with the MVC design pattern
// The data package handles Json api calls with the Volley library

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView questionTextView;
    private TextView questionCounterTextView;
    private TextView highScoreTextView;
    private TextView currentScoreTextView;
    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private int currentQuestionIndex = 0;
    private List<Question> questionList;
    private int scoreCounter = 0;
    private Score score;
    private Prefs prefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = new Score();
        prefs = new Prefs(MainActivity.this);
        // Log.d("prefs", "onCreate: " + prefs.getHighScore());

        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        questionCounterTextView = findViewById(R.id.counter_text_view);
        questionTextView = findViewById(R.id.question_text_view);
        highScoreTextView = findViewById(R.id.high_score_text_view);
        currentScoreTextView = findViewById(R.id.current_score_text_view);
        // set default values of score textviews and get defaults from Score and Prefs
        currentScoreTextView.setText(MessageFormat.format("Current score {0}",String.valueOf(score.getScore())));
        highScoreTextView.setText(MessageFormat.format("High Score {0}",String.valueOf(prefs.getHighScore())));
        questionList = new QuestionBank().getQuestions(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Question> questionArrayList) {
                questionTextView.setText(questionArrayList.get(currentQuestionIndex).getAnswer());
                // set the counter_text_view to index out of all questions e.g 24 / 854
                questionCounterTextView.setText(MessageFormat.format("{0} / {1}",currentQuestionIndex,questionArrayList.size()));
                Log.d("Inside", "processFinished: " + questionArrayList);
            }
        });
        Log.d("Main", "onCreate: " + questionList);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next_button:
                prefs.saveHighScore(scoreCounter);
                currentQuestionIndex = (currentQuestionIndex + 1) % questionList.size();
                updateQuestion();
                break;
            case R.id.prev_button:
                if(currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionList.size();
                    updateQuestion();
                }
                break;
            case R.id.true_button:
                checkAnswer(true);
                updateQuestion();
                break;
            case R.id.false_button:
                checkAnswer(false);
                updateQuestion();
                break;

        }
    }

    private void checkAnswer(boolean userChoosesCorrect) {
        boolean answerIsTrue = questionList.get(currentQuestionIndex).isAnswerTrue();
        // int toastMessage;
        if(userChoosesCorrect == answerIsTrue) {

            fadeAnimation();
            addPoints();
            // toastMessage =  R.string.correct_answer;
        }else {
            shakeAnimation();
            deductPoint();
            // toastMessage = R.string.wrong_answer;
        }
        // Toast.makeText(MainActivity.this,toastMessage,Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion() {
        String question = questionList.get(currentQuestionIndex).getAnswer();
        questionTextView.setText(question);
        questionCounterTextView.setText(MessageFormat.format("{0} / {1}",currentQuestionIndex,questionList.size()));
    }

    private void addPoints() {
        scoreCounter += 100;
        score.setScore(scoreCounter);
        currentScoreTextView.setText(MessageFormat.format("Current Score {0}", String.valueOf(score.getScore())));

        // Log.d("Score:", "addPoints: " + score.getScore());
    }

    private void deductPoint() {
        scoreCounter -= 100;
        if(scoreCounter > 0){
            score.setScore(scoreCounter);
            currentScoreTextView.setText(MessageFormat.format("Current Score {0}", String.valueOf(score.getScore())));

        } else {
            scoreCounter = 0;
            score.setScore(scoreCounter);
            currentScoreTextView.setText(MessageFormat.format("Current Score {0}", String.valueOf(score.getScore())));

            Log.d("Score bad", "deductPoint: " + score.getScore());
        }
    }

    private void fadeAnimation() {
        final CardView cardView = findViewById(R.id.input_card_view);

        // decrease visibility from completely visible to invisible
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.0f);

        alphaAnimation.setDuration(350);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setRepeatMode(Animation.REVERSE);

        cardView.setAnimation(alphaAnimation);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                cardView.setCardBackgroundColor(Color.GREEN);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardView.setCardBackgroundColor(Color.WHITE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void shakeAnimation() {
        final Animation shake = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.shake_animation);
        final CardView cardView = findViewById(R.id.input_card_view);
        cardView.setAnimation(shake);

        // capture the animation object
        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                cardView.setCardBackgroundColor(Color.RED);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardView.setCardBackgroundColor(Color.WHITE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override
    protected void onPause() {
        prefs.saveHighScore(score.getScore()); // high score gets saved to disk
        super.onPause();
    }
}