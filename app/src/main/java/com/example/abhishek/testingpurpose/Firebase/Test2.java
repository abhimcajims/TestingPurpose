package com.example.abhishek.testingpurpose.Firebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Test2  extends AppCompatActivity{


    int a=10;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    void open(){
        System.out.print(a);
        System.out.print("Pushing to Branch02 from desktop");
        System.out.print("Pushing to Branch02 from desktop Again");


    }

}
