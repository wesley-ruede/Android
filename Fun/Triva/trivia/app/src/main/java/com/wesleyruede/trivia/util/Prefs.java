package com.wesleyruede.trivia.util;

import android.app.Activity;
import android.content.SharedPreferences;

public class Prefs {
    private SharedPreferences preferences;

    // need to pass the intent of the  context
    public Prefs(Activity activity) {
        this.preferences = activity.getPreferences(activity.MODE_PRIVATE);
    }

    public void saveHighScore(int score) {
        int currentScore = score;

        int lastScore = preferences.getInt("high_score",0);

        if(currentScore > lastScore) {
            // the highest score and saving it locally
            preferences.edit().putInt("high_score",currentScore).apply();
        }
    }

    public int getHighScore() {
        return preferences.getInt("high_score",0);
    }
}
