package com.wesleyruede.makeitrain;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    private int moneyCounter = 0;
    private TextView moneyText;
    private ConstraintLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // go to resources and find the layout activity_main
        setContentView(R.layout.activity_main);

        moneyText = findViewById(R.id.money_text);
        layout = findViewById(R.id.window);
    }

    // debugging log method for the show_tag button
    public void showTag(View view) {
        // Toast requires a context to show message, a message, and the duration of the message
        // text can be from res, remember to show the Toast with .show(), creates a window
        Toast.makeText(getApplicationContext(),R.string.show_tag,Toast.LENGTH_LONG).show();
    }
    // logging and manipulating string data for the TextView
    public void makeItRain(View v) {

        NumberFormat  numberFormat = NumberFormat.getCurrencyInstance(); // $1,000.00
        moneyCounter += 1000;
        // up cast int to string and format string as currency based on locale
        moneyText.setText(numberFormat.format(moneyCounter));
        Log.d("MIR", "makeItRain: Tapped " + moneyCounter);

        // change text color
        // moneyText.setTextColor(getResources().getColor(R.color.textColor));

        // change text and background color based on amount
        switch (moneyCounter) {
            case 5000:
                moneyText.setTextColor(Color.BLACK);
                layout.setBackgroundColor(Color.RED);
                break;
            case 10000:
                moneyText.setTextColor(Color.RED);
                layout.setBackgroundColor(Color.YELLOW);
                break;
            case 15000:
                moneyText.setTextColor(Color.YELLOW);
                layout.setBackgroundColor(Color.GREEN);
                break;
            case 20000:
                moneyText.setTextColor(Color.GREEN);
                layout.setBackgroundColor(Color.MAGENTA);
                break;
            case 25000:
                moneyText.setTextColor(Color.MAGENTA);
                layout.setBackgroundColor(Color.CYAN);
                break;
            case 30000:
                moneyText.setTextColor(Color.CYAN);
                layout.setBackgroundColor(Color.WHITE);
                break;
            case 35000:
                moneyText.setTextColor(Color.MAGENTA);
                layout.setBackgroundColor(Color.CYAN);

            case 50000:
                moneyText.setTextColor(Color.WHITE);
                layout.setBackgroundColor(Color.BLACK);
                break;
        }
    }
}