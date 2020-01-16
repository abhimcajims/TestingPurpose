package com.example.abhishek.testingpurpose.FragmentManagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.abhishek.testingpurpose.R;

public class MainFragment extends AppCompatActivity {

    FrameLayout frame_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);
        Log.d("Activity: ", "onCreate");

        frame_main = findViewById(R.id.frame_main);

        //replace();

        /*FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        FirstFragment firstFragment = new FirstFragment();
        ft.add(R.id.frame_main, firstFragment);
        ft.addToBackStack(null);
        ft.commit();*/

        getSupportFragmentManager().beginTransaction().add(R.id.frame_main, new FirstFragment()).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity: ", "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity: ", "onResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity: ", "onRestart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity: ", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity: ", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity: ", "onDestroy");

    }
}
