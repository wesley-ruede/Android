package com.wesleyruede.loginlogout;

/*
 An app that uses Firebase as a real time db registered
 with SHA1 in the Firebase console with the name
 Created by Wesley Ruede  10/25/19
*/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.wesleyruede.loginlogout.authentication.LoginActivity;
import com.wesleyruede.loginlogout.authentication.UserAccount;


public class MainActivity extends AppCompatActivity {

    // A credential authentication database system by Google.
    private FirebaseAuth mAuth;
    private String current_user_id;
    private Button signout, user_account;

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

        // when the signoutButton is pressed call signout on mAuth and send
        // the user back to the login activity
        signout = findViewById(R.id.signoutButton);
        user_account = findViewById(R.id.userAccount);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });

        // a method that send the user to the UserAccount activity
        user_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UserAccount.class));
            }
        });
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
// added create a user feature in SignupActivity with in activity_signup
// created a user and logout finished 10/30/19
