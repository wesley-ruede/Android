package com.wesleyruede.loginlogout;

/*
 An app that uses Firebase as a real time db registered
 with SHA1 in the Firebase console with the name
 Created by Wesley Ruede  10/25/19
*/

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.wesleyruede.loginlogout.authentication.LoginActivity;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String current_user_id;

    // if user is logged in then do nothing
    @Override
    protected void onStart() {
        super.onStart();

        if (current_user_id==null) {
            // send user back to the LoginActivity
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }

    // if user is not logged in send user to login page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        current_user_id = mAuth.getUid();
    }
}

// added google-services.json plugin for Gradle to LoginLogout/app dir
// project level build.gradle successfully updated
// app level build.gradle successfully updated
// Firebase sdk installed
// created a new package in the Main Java directory
// login and logout layout will be in the authentication
// added user credentials to Firebase email Authentication database
// user successfully signed in with device
// login complete -- 10/29/19
