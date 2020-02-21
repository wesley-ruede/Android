package com.wesleyruede.contactmanagerrecycler;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView detsName, detsPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detsName = findViewById(R.id.dets_name);
        detsPhone = findViewById(R.id.dets_phone);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String name = bundle.getString("name");
            String phone = bundle.getString("number");

            detsName.setText(name);
            detsPhone.setText(phone);
        }
    }
}
