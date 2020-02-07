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

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.wesleyruede.loginlogout.MainActivity;
import com.wesleyruede.loginlogout.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    private UploadTask uploadTask;
    private Uri download_uri;

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
                    // the compressed image  is now being encoded and created byte by byte in the thumb byte array
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    compressor.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byte[] thumb = byteArrayOutputStream.toByteArray();

                    UploadTask image_path = storageReference.child("user_image").child(user_id + ".jpg").putBytes(thumb);
                    final StorageReference ref = storageReference.child("user_image");
                    uploadTask = ref.putBytes(thumb);
//////////////////////////////////// the issue is that this application is assuming a best case scenario
                    //////////////// and the lack of a onFailureListener does not allow exceptions to be handled
                    image_path.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();

                        } // I used the wrong method. OnSuccessListener is correct
                    }).addOnCompleteListener(new OnCompleteListener<com.google.firebase.storage.UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.storage.UploadTask.TaskSnapshot> task) {
                            if(task.isSuccessful()){

                                StoreData(task,
                                        useraddress,
                                        username,
                                        userphone);

                            }else {
                                String error = task.getException().getMessage();
                                Toast.makeText(UserAccount.this,"Image Error"+error,Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();

                            }


                        }
                    });
                }
            }
        });
    }


    // This is progress. Finally got somewhere with my efforts.
    private void StoreData(Task<com.google.firebase.storage.UploadTask.TaskSnapshot> task, String useraddress, String username, String userphone) {
        // needed new string data as it was declared final in
        final String fusername = username;
        final String fuserphone = userphone;
        final String fuseraddress =  useraddress;
        final StorageReference ref = storageReference.child("user_image");


        // this is a necessary block for the getDownloadUrl() method and getResult() method. It also catches errors which is nice.
        Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }
                return ref.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {

                    // mapping data to a Firestore database
                    download_uri = task.getResult();
                    Map<String,String> userData = new HashMap<>();
                    userData.put("userName",fusername);
                    userData.put("userPhone", fuserphone);
                    userData.put("userAddress", fuseraddress);
                    userData.put("userImage", download_uri.toString());

                    firebaseFirestore.collection("Users").document(user_id).set(userData).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {

                                progressDialog.dismiss();
                                Toast.makeText(UserAccount.this,"Data successfully stored",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(UserAccount.this, MainActivity.class));

                            } else {
                                Toast.makeText(UserAccount.this,"Firestore error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                } else {
                    download_uri = imageUri;

                }
            }
        });

    }
    // Technically this block is not throwing any errors but, I don't think it does what I want at the moment.
    // https://firebase.google.com/docs/storage/android/upload-files#get_a_download_url

    // If userImage.setOnClickListener() method is given permission by the user to
    // access the device's image software, choose and crop the image.
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
                // this is why the image is not showing. I need to implement this method below:
                // userImage = setImageURI(imageUri)
                // I have a found a few different options:
                // http://www.java2s.com/Code/Android/UI/SetimageUriforImageView.htm -- probably not
                // https://forums.xamarin.com/discussion/4323/image-from-url-in-imageview/p1 -- maybe
                // https://stackoverflow.com/questions/3870638/how-to-use-setimageuri-on-android -- most likely
                // https://theartofdev.com/2016/01/15/android-image-cropper-async-support-and-custom-progress-ui/ -- maybe
                // https://github.com/ArthurHub/Android-Image-Cropper/issues/159 -- not that useful.
                // there is also a method setImageUriAsync() supposedly. I'm not sure at the moment.



            }else if (resultCode==CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Toast.makeText(UserAccount.this,"Cropped Image Error"+error,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
