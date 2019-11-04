package com.wesleyruede.loginlogout.authentication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.wesleyruede.loginlogout.R;

public class UserAccount extends AppCompatActivity {

    // field variables for the ui xml elements
    ImageView userImage;
    EditText userName, userPhone, userAddress;
    Button complete;

    // choose image
    private Uri imageUri;
    private Bitmap compressor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        userImage = findViewById(R.id.userImage);
        userName = findViewById(R.id.userName);
        userPhone = findViewById(R.id.userPhone);
        userAddress = findViewById(R.id.userAddress);
        complete = findViewById(R.id.complete);

        // a method which allows a clickable image to request permission to change the image
        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(UserAccount.this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                            PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(UserAccount.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                        ActivityCompat.requestPermissions(UserAccount.this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                    } else {
                        ChooseImage();
                    }
                } else {
                    ChooseImage();
                }
            }
        });

    }

    // choose and crop the image
    private void ChooseImage() {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(1,1)
                .start(UserAccount.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode==RESULT_OK) {
                imageUri = result.getUri();

            }else if (resultCode==CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
