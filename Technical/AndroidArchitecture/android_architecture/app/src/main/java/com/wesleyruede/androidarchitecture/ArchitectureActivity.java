package com.wesleyruede.androidarchitecture;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.wesleyruede.androidarchitecture.mvp.MVPActivity;
import com.wesleyruede.androidarchitecture.mvvm.MVVMActivity;

public class ArchitectureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture);
    }

    public void onMVC(View view){
        startActivity(MVPActivity.getIntent(this));
    }

    public void onMVP(View view){
        startActivity(MVPActivity.getIntent(this));
    }

    public void onMVVM(View view){
        startActivity(MVVMActivity.getIntent(this));
    }
}
