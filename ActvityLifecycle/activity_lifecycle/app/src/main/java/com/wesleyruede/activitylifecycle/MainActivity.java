package com.wesleyruede.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button guessButton;
    private TextView guessText;
    private final int REQUEST_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // onCreate is the first state of the life cycle
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Cycle","onCreate");
        Toast.makeText(MainActivity.this,"onCreate()",
                Toast.LENGTH_SHORT).show();

        guessButton = findViewById(R.id.guess_button);
        guessText = findViewById(R.id.guess_text);

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guessString = guessText.toString().trim();
                if(!guessString.isEmpty()){
                    // intent needs a context and the proceeding class
                    // put a key and value or uid like HashMap
                    Intent intent = new Intent(MainActivity.this,ShowGuess.class);
                    // passing a literal string as data along with the Intent
                    intent.putExtra("guess","hello there");
                    intent.putExtra("THE","Spirit");
                    intent.putExtra("kungFu","Hustle");
                    intent.putExtra("southPark",13);
                    startActivityForResult(intent,RESULT_OK);
                    // startActivity(new Intent(MainActivity.this, ShowGuess.class);
                } else {
                    Toast.makeText(MainActivity.this,"Enter input",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    // A protocol to receive data from ShowGuess.class activity at MainActivity.class
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE) {
            assert data != null;
            String message = data.getStringExtra("message_back");
            Log.d("second activity", " " + data.getStringExtra("message_back"));
            Toast.makeText(MainActivity.this, message,
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }


    // Android activity life cycle logging
    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Cycle","onStart()");
        // Toast.makeText(MainActivity.this,"onStart()",Toast.LENGTH_SHORT).show();
    }

    @Override
    // same as onResume, used for app compatibility
    protected void onPostResume() {
        super.onPostResume();

        Log.d("Cycle","onPostResume()");
//        Toast.makeText(MainActivity.this,"onPostResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Cycle","onPause()");
//        Toast.makeText(MainActivity.this,"onPause()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Cycle","onDestroy()");
        // Toast.makeText(MainActivity.this,"onDestroy()",Toast.LENGTH_SHORT).show();
    }
}