package com.wesleyruede.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowGuess extends AppCompatActivity {
    private TextView showGuessTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);
        showGuessTextView =findViewById(R.id.recieved_text);

        // The best way ------
        // A container object that takes all passed intent extras objects
        // an array[] of intent objects
        Bundle extra = getIntent().getExtras();

        if(extra != null){
            showGuessTextView.setText(extra.getString("guess"));
            Log.d("extra", " " + extra.getString("kungFu"));
            Log.d("extra", " " + extra.getInt("southPark"));
        } // --------

        // A protocol to send data from this activity back to the original activity
        showGuessTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("message_back","from second activity");
                setResult(RESULT_OK,intent);
                // close the object stack
                finish();
            }
        });

//       the safe and succinct way which checks the given input is not empty
//       before passing the value to the TextView to be displayed
//       if (getIntent().getStringExtra("guess") != null) {
//          Log.d("THE"," " + getIntent().getStringExtra("kungFu"));
//          showGuessTextView.setText(getIntent().getStringExtra("guess"));

        // normal way ------
        // get the HashMap keys
        // String value = getIntent().getStringExtra("guess");
        // setting the received_text TextView to the enter_guess TV
        // showGuessTextView.setText(value);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Show Guess", "The View has been destroyed");
    }
}

