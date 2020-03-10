package com.wesleyruede.test;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.wesleyruede.test.data.DatabaseHandler;
import com.wesleyruede.test.model.Journal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "log_levels";
    private TextView textView, checkBoxText;
    private CheckBox checkBox;
    private EditText editText;
    private Button changeText, checkBoxButton;
    private Button buttonTwo;
    private StringBuilder str;
    private ArrayList<Journal> journalArrayList;

    /* Media Player */
    private MediaPlayer mediaPlayer;
    private Button playButton;

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
        playButton = findViewById(R.id.play_button);
        checkBoxButton = findViewById(R.id.check_box_button);

        /* OnClick buttons */
        changeText.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        playButton.setOnClickListener(this);
        checkBoxButton.setOnClickListener(this);

        /* I need to research this */
        // checkBox.setOnCheckedChangeListener(this);

        /* Media Player */
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.edm_music);

        /* Check Box */
        checkBoxText = findViewById(R.id.check_box_text);
        checkBox = findViewById(R.id.check_box);

        // Journal journal = db.getEntry(0);
        Journal journal_entry = new Journal();
        journal_entry.setJournalEntry("another great message");
        // db.addEntry(journal_entry);
        Log.d("journal_entries", "onCreate: " +journal_entry.getId());

        /* Logcat levels */
        Log.d(TAG, "onCreate: Debug");
        Log.i(TAG, "onCreate: Info ");
        Log.w(TAG, "onCreate: Warning ");
        Log.e(TAG, "onCreate: Error ");
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
                journal.setJournalEntry(input_var);
                db.addEntry(journal);
                Toast.makeText(MainActivity.this," "+journal.getJournalEntry(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.play_button:
                if (mediaPlayer.isPlaying()) {
                    //Todo: stop and give users the option to start again
                    pauseMusic();
                }else {
                    playMusic();
                }
                break;
            case R.id.check_box_button:
                isChecked();
                break;

        }
    }

    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            playButton.setText(R.string.play_text);
        }
    }

    public void playMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            playButton.setText(R.string.pause_text);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            mediaPlayer.release();
        }
    }

    public void isChecked() {
        if (checkBox.isChecked()) {
            checkBoxText.setText("You clicked the check box");
        }else if (!checkBox.isChecked()) {
            checkBoxText.setText("please click the check box");
        }
    }
}
