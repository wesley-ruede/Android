package com.wesleyruede.loginlogout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

// An app that uses Firebase as a real time db registered
// with SHA1 in the Firebase console with the name LoginLogout
// added google-services.json plugin for Gradle to LoginLogout/app dir
// project level build.gradle successfully updated
// app level build.gradle successfully updated
// Firebase sdk installed

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
