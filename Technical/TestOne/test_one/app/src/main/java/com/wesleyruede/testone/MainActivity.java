package com.wesleyruede.testone;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private CheckBox checkBox1, checkBox2;
    private TextView pizzaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = findViewById(R.id.check_box_1);
        checkBox2 = findViewById(R.id.check_box_2);
        pizzaText = findViewById(R.id.pizza_text);

    }

    @Override
    public void onCheckedChanged(CompoundButton box, boolean isChecked) {

        StringBuilder str = new StringBuilder(pizzaText.getText());
        CharSequence boxText = box.getText();
        if (isChecked) {
            str.append(" " + boxText);
        }else {
            int start = str.indexOf(boxText.toString());
            int length = boxText.length();
            str.replace(start, start + length, " ");
        }
        pizzaText.setText(str.toString().trim());

    }
}
