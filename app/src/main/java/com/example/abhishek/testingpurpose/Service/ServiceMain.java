package com.example.abhishek.testingpurpose.Service;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.abhishek.testingpurpose.R;
import com.example.abhishek.testingpurpose.databinding.ActivityServiceMainBinding;


public class ServiceMain extends AppCompatActivity {


    ActivityServiceMainBinding activityServiceMainBinding;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityServiceMainBinding= DataBindingUtil.setContentView(ServiceMain.this,R.layout.activity_service_main);

        activityServiceMainBinding.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(ServiceMain.this, MyService.class));
            }
        });

        activityServiceMainBinding.buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(ServiceMain.this, MyService.class));

            }
        });

        activityServiceMainBinding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ServiceMain.this,NextPage.class);
                startActivity(intent);
            }
        });

    }
}
