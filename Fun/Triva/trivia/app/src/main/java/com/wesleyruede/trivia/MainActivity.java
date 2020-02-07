package com.wesleyruede.trivia;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.wesleyruede.trivia.data.AnswerListAsyncResponse;
import com.wesleyruede.trivia.data.QuestionBank;
import com.wesleyruede.trivia.model.Question;
import java.util.ArrayList;
import java.util.List;

// This Trivia app is created with the MVC design pattern
// The data package handles Json calls with the Volley library

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the array of arrays with the corresponding String and
        // Boolean Question singleton instance. The internet processes
        // requests asynchronously the so app must handle null responses
        // and wait for the queue to respond with the next element in the array.
        // QuestionBank.getQuestions() = [["question",true"],["Question",false]] or null
        // Calling the class and method allows us to implement the Interface
        // thus overriding the default behavior of the ArrayList and pass the
        // json response (see: [[],[]]) directly to MainActivity.
        List<Question> questionList = new QuestionBank().getQuestions(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Question> questionArrayList) {

                Log.d("Inside", "processFinished: " + questionArrayList);
            }
        });

        Log.d("Main", "onCreate: " + questionList);
    }
}
