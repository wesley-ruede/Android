package com.example.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Attempt to launch an activity within the app
        Button secondActivityBtn = findViewById((R.id.secondActivityBtn));
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // building an intent
                Intent startIntent = new Intent(getApplicationContext(), SecondActivty.class);
                startIntent.putExtra("com.example.quicklauncher.SOMETHING", "Hello World!" );
                startActivity(startIntent);
            }
        });

        // Attempt to launch an activity outside of the app
        Button googleBtn = findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String google ="http://www.google.com";
                Uri webaddres = Uri.parse(google);

                Intent goToGoogle = new Intent((Intent.ACTION_VIEW), webaddres);
                if (goToGoogle.resolveActivity(getPackageManager()) !=null) {
                    startActivity(goToGoogle);
                }
            }
        });
    }
}
