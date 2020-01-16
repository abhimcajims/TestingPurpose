package com.example.abhishek.testingpurpose.RetrofitExample;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.abhishek.testingpurpose.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitMain extends Activity {

    RecyclerView recycler_vertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nested_main);
        recycler_vertical = findViewById(R.id.recycler_vertical);

        ArrayList<String> ob = new ArrayList<>();
        ob.add("abhishek");
        Call<List<Hero>> ca = new RetrofitClient().getInstance().getApi().getHeroes("android", ob);

        // Set up progress before call
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(RetrofitMain.this);
        //progressDoalog.setMax(100);
        progressDoalog.setMessage("Loading Data....");
        //progressDoalog.setTitle("ProgressDialog bar example");
        //progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // show it
        progressDoalog.show();

        ca.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                if (response.isSuccessful()) {
                    progressDoalog.dismiss();
                    List<Hero> lh = response.body();
                    RetroAdapter rad = new RetroAdapter(getApplicationContext(), lh);
                    recycler_vertical.setHasFixedSize(true);
                    recycler_vertical.setLayoutManager(new LinearLayoutManager(RetrofitMain.this, LinearLayoutManager.VERTICAL, true));
                    recycler_vertical.setAdapter(rad);
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
