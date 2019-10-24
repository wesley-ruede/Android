package com.WesleyRuede.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Wesley Ruede on 10/22/19
 */
// This is being created for the operation of applying an index to the respective
    // image from the designated ListView object being pressed.


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Creating an Intent in response to the setOnItemCLickListener()'s
        // method startActivity() to draw an image on the screen.
        Intent in = getIntent();
        // Here I learned a nuance of Java as negative indexing is not allowed
        // so by using the very last element of an array denotes the end of it
        int index = in.getIntExtra("com.WesleyRuede.ITEM_INDEX", -1);

        // call getImg method and scaleImg method

        if (index > -1) {
            // get the image at the index being passed in
            int pic = getImg(index);
            // an ImageView that searches for the drawable resources
            ImageView img = (ImageView) findViewById((R.id.imageView));
            // scale the image based on the index and drawable resource
            scaleImg(img, pic);
        }
    }

    // set the image that corresponds with the ListView object
    // that returns the resource image
    private int getImg(int index) {
        switch (index) {
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tomato;
            case 2: return R.drawable.squash;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pic) {

        // determining phone size to scale images
        Display screen  = getWindowManager().getDefaultDisplay();
        // get an instance of the BitmapFactory class
        BitmapFactory.Options options = new BitmapFactory.Options();

        // define boundaries of the BitmapFactory and turn on boundaries
        options.inJustDecodeBounds = true;
        // view the resources e.g. images without drawing them to save memory

        // trace the boundaries of the BitmapFactory
        int imgWidth = options.outWidth;
        // trace the size of the screen -- getWidth() is depreciated
        int screenWidth = screen.getWidth();

        // if imgWidth > screenWidth it will cause an error and must be scaled
        if (imgWidth > screenWidth) {
            // find ratio of image to screen -- round takes two floats
            int ratio = Math.round( (float)imgWidth / (float)screenWidth );
            // set sample size of the BitmpFactory based on ratio
            options.inSampleSize = ratio;
        }

        // turn off inJustDecodeBounds
        options.inJustDecodeBounds = false;
        // create a new Bitmap of the scaled image from the pic parameter
        // that has been passed in and and get the resources by calling
        // decodeBitmap on the BitmapFactory instance
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        // finally tke the image and set it to the scaled image
        img.setImageBitmap(scaledImg);

    }
}
