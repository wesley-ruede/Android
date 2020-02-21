package com.wesleyruede.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.wesleyruede.test.data.DatabaseHandler;
import com.wesleyruede.test.model.Journal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private EditText editText;
    private Button changeText;
    private Button buttonTwo;
    private ArrayList<Journal> journalArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        journalArrayList = new ArrayList<>();
        textView = findViewById(R.id.set_text);
        editText = findViewById(R.id.enter_text);
        changeText = findViewById(R.id.button_one);
        buttonTwo = findViewById(R.id.button_two);

        changeText.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);

        Journal journal = db.getEntry(0);
        Journal journal_entry = new Journal();
        journal_entry.setJournalEntry("another great message");
        db.addEntry(journal_entry);
        Log.d("journal_entries", "onCreate: " +journal_entry.getId());


    }

    @Override
    public void onClick(View view) {
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        Journal journal = new Journal();
        switch (view.getId()){
            case R.id.button_one:
                String var = editText.getText().toString().trim();
                textView.setText(var);
                break;
            case R.id.button_two:
                String input_var = editText.getText().toString().trim();
                // journal.setJournalEntry(input_var);
                //db.addEntry(journal);
                Toast.makeText(MainActivity.this," "+journal.getJournalEntry(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
