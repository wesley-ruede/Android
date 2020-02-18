package com.example.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rightButton = findViewById((R.id.right_button));
        Button googleBtn = findViewById(R.id.google_button);
        googleBtn.setOnClickListener(this);
        rightButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.google_button:
                Intent intent= new Intent(getApplicationContext(), SecondActivty.class);
                intent.putExtra("com.example.quicklauncher.SOMETHING", "This is some text that will be in next activities TextView");
                startActivity(intent);
                break;
            case R.id.right_button:
                String url ="http://www.google.com";
                Uri web_address = Uri.parse(url);
                Intent web_intent = new Intent((Intent.ACTION_VIEW), web_address);
                if (web_intent.resolveActivity(getPackageManager()) !=null) {
                    startActivity(web_intent);
                }
                break;
        }
    }
}
