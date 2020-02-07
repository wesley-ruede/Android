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

public class SignupActivity extends AppCompatActivity {

    private EditText emailField, passwordField, passwordConfirm;
    private Button complete, signin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        passwordConfirm = findViewById(R.id.passwordConfirm);

        complete = findViewById(R.id.complete);
        signin = findViewById(R.id.signinButton);

        mAuth = FirebaseAuth.getInstance();

        // if the signinButton is pressed return to the LoginActivity \
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                finish();
            }
        });


        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // capture user input from activity_signup EditText
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();
                String passconf = passwordConfirm.getText().toString();

                if(!TextUtils.isEmpty(email)&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(passconf) ) {

                    if (password.equals(passconf)) {

                        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                                }else {
                                    Toast.makeText(SignupActivity.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }else {
                        Toast.makeText(SignupActivity.this, "Your passwords do not match", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    // if any data is missing display an error message
                    Toast.makeText(SignupActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
