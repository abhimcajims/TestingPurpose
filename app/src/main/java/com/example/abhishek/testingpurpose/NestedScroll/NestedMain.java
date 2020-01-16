package com.example.abhishek.testingpurpose.NestedScroll;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.HorizontalScrollView;

import com.example.abhishek.testingpurpose.R;

public class NestedMain extends Activity {


    RecyclerView recycler_vertical;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            int orientation = this.getResources().getConfiguration().orientation;


            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                setContentView(R.layout.nav_header_home);
                //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                setContentView(R.layout.nested_main);
                //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            } else {
                //  :-) hehe;
            }


            recycler_vertical = (RecyclerView) findViewById(R.id.recycler_vertical);

            VerticalAdapter rad = new VerticalAdapter(NestedMain.this);
            recycler_vertical.setHasFixedSize(true);
            recycler_vertical.setLayoutManager(new LinearLayoutManager(NestedMain.this, LinearLayoutManager.VERTICAL, true));
            recycler_vertical.setAdapter(rad);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.nav_header_home);
            //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.nested_main);
            //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}
