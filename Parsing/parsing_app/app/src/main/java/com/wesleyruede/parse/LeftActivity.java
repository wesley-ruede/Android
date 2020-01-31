package com.wesleyruede.parse;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LeftActivity extends AppCompatActivity {
    private ImageView a2ImgView;
    private TextView a2TxtView;
    private Button a2Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left);

        a2ImgView = findViewById(R.id.a2_img);
        a2TxtView = findViewById(R.id.a2_text);
        a2Btn = findViewById(R.id.a2_button);

        Bundle extra = getIntent().getExtras();

        if(extra != null){
            a2TxtView.setText(extra.getString("LOG3"));
            Log.d("LOG2", " " + extra.getString("LOG2"));
        } else{
            Toast.makeText(LeftActivity.this,extra.getString("toast_message"),
                    Toast.LENGTH_SHORT)
                    .show();
        }

        a2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}
