package com.wesleyruede.loginlogout.authentication;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.wesleyruede.loginlogout.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import id.zelory.compressor.Compressor;

// this was a tricky one to handle and
// had to delete import io.grpc.Compressor

public class UserAccount extends AppCompatActivity {

    // field variables for the ui xml elements
    ImageView userImage;
    EditText userName, userPhone, userAddress;
    Button complete;

    // choose image
    private Uri imageUri;
    private Bitmap compressor;
    private ProgressDialog progressDialog;

    // Google's Firebase, Firestore, and with Cloud storage
    String user_id;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        // reference to the xml views in resources
        userImage = findViewById(R.id.userImage);
        userName = findViewById(R.id.userName);
        userPhone = findViewById(R.id.userPhone);
        userAddress = findViewById(R.id.userAddress);
        complete = findViewById(R.id.complete);
        progressDialog = new ProgressDialog(this);

        // instantiating the Firebase objects to access
        // the methods provided by the respective classes
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();
        storageReference = FirebaseStorage.getInstance().getReference();

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

        // complete button onclick listener for storing user data including
        // name and an image to firestore
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setMessage("storing data... ");
                progressDialog.show();

                final String username = userName.getText().toString();
                final String userphone = userPhone.getText().toString();
                final String useraddress = userAddress.getText().toString();

                // check that all fields are filled
                if (!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(userphone)&& !TextUtils.isEmpty(useraddress)&&imageUri!=null) {
                    // if all fields are filled then
                    File newFile = new File(imageUri.getPath());

                    try {
                        compressor = new Compressor(UserAccount.this)
                                .setMaxHeight(125)
                                .setMaxWidth(125)
                                .compressToBitmap(newFile);



                    } catch (IOException e) {
                        e.printStackTrace();
                    }
/////////////////////////////////// the compressed image  is now being encoded and created
                        /////////// byte by byte in the thumb byte array
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    compressor.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                    byte[] thumb = byteArrayOutputStream.toByteArray();

                    UploadTask image_path = storageReference.child("user_image").child(user_id+".jpg").putBytes(thumb);
//////////////////////////////////// the issue is that this application is assuming a best case scenario
                    //////////////// and the lack of a onFailureListener does not allow exceptions to be handled
                    image_path.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();

                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        }
                    });


                } else {
                    Toast.makeText(UserAccount.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
///////////////////////////////// -- is the storeUserData method needed?
    private void storeUserData(Task<UploadTask.TaskSnapshot> task, String username, EditText userAddress, String userphone) {
        Uri download_uri;
    }
////////////////////////////////// This method is now pointless, solved.
                    ///////////// Or so I thought. Well that is enough for today.
    // https://firebase.google.com/docs/storage/android/upload-files#get_a_download_url

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
