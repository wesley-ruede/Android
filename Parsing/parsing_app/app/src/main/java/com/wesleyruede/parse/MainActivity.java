package com.wesleyruede.parse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button sendButton;
    private TextView sendText;
    private ImageView sendImg;
    private Integer dictionaryIndex = 0;

    private Dictionary[] dictionary = new Dictionary[] {
            new Dictionary(R.string.quote)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.right_button);
        sendText = findViewById(R.id.send_text);
        sendImg = findViewById(R.id.send_img);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LeftActivity.class);
                intent.putExtra("LOG1","system log 1");
                intent.putExtra("LOG2","system log 2");
                intent.putExtra("LOG3"," " + dictionary[dictionaryIndex]);
                intent.putExtra("Toast_message","there is an error");
                startActivity(intent);
            }
        });

    }
}
