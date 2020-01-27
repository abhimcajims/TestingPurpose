package com.example.abhishek.testingpurpose.Thread;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.abhishek.testingpurpose.R;

public class ThreadMain extends AppCompatActivity {

    Button btn_click, btn_click2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_main);
        btn_click = findViewById(R.id.btn_click);
        btn_click2 = findViewById(R.id.btn_click2);

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewThread nt = new NewThread("start");
                nt.start();//Create a new Thread.
            }
        });
        btn_click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewThread ntt = new NewThread("run");
                ntt.run();//Run on main thread.
            }
        });
    }

    private class NewThread extends Thread {

        String text;

        public NewThread(String text) {
            this.text = text;
        }

        @Override
        public void run() {
            try {
               Log.d("Thread Printing----> ","Caller: " + text + " and code on this Thread is executed by : " + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
