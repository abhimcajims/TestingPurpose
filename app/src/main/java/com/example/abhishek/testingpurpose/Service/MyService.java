package com.example.abhishek.testingpurpose.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.abhishek.testingpurpose.R;

public class MyService extends Service {
    MediaPlayer myPlayer;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();

        //myPlayer = MediaPlayer.create(MyService.this, R.raw.sun);

        myPlayer = MediaPlayer.create(MyService.this, R.raw.sun);

        myPlayer.setLooping(false); // Set looping
    }

    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        myPlayer.start();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
        myPlayer.stop();
    }
}
