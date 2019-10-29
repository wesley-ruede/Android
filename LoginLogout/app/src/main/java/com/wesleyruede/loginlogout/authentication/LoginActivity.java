package com.wesleyruede.loginlogout.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.wesleyruede.loginlogout.MainActivity;
import com.wesleyruede.loginlogout.R;

public class LoginActivity extends AppCompatActivity {

    // field variables in reference to the activity_login resources
    private EditText emailAddress, password;
    private Button signin, signup;

    // add a Firebase field variable
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // linking the field variable to the resources
        emailAddress = findViewById(R.id.emailField);
        password = findViewById(R.id.passwordField);
        signin = findViewById(R.id.signInButton);
        signup = findViewById(R.id.signUpButton);

        // a new onClickListener for the sign in button
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

        // instantiating a new FirebaseAuth object
        mAuth = FirebaseAuth.getInstance();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // store the use data in variable to store in the database
                String email = emailAddress.getText().toString();
                String Pass = password.getText().toString();

                if (!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(Pass)){
                    // using Firebase to authenticate the credentials
                    mAuth.signInWithEmailAndPassword(email, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // validate user input if input is successful
                            if (task.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish();
                            } else {
                                // generate an error if all else goes wrong
                                Toast.makeText(LoginActivity.this, "Error "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                } else {
                    // handle incorrect user input
                    Toast.makeText(LoginActivity.this, "You forgot to put something in", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}
