package com.example.sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_ID = "message_pref";
    public Button saveButton;
    public EditText enterMessage;
    public TextView showMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = findViewById(R.id.save_button);
        enterMessage = findViewById(R.id.input_text);
        showMessageTextView = findViewById(R.id.show_message);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = enterMessage.getText().toString();

                // MODE_PRIVATE argument sets the saved data as only for this app
                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("message",message);

                editor.commit(); // saving to disk!

            }
        });

        // Get data back from SP
        SharedPreferences getShareData = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
        String value = getShareData.getString("message","Nothing yet");

        showMessageTextView.setText(value);
    }
}