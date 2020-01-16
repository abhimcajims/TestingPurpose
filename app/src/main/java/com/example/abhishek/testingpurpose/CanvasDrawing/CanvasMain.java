package com.example.abhishek.testingpurpose.CanvasDrawing;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.abhishek.testingpurpose.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CanvasMain extends AppCompatActivity {

    LinearLayout linearLayout;
    private RequestQueue mRequestQueue;
    private JsonObjectRequest mJsonObject;
    private String url = "http://www.mocky.io/v2/5cf229033300001616d0d05e";

    List<ColorReceived> jj = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas_main);


        mRequestQueue = Volley.newRequestQueue(CanvasMain.this);

        mJsonObject = new JsonObjectRequest(url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                int a = 87;
                Gson gs = new GsonBuilder().create();
                ColorReceived jd = gs.fromJson(response.toString(), ColorReceived.class);
                jj.add(jd);
                linearLayout = findViewById(R.id.linearLayout);
                MyView myView = new MyView(CanvasMain.this);
                linearLayout.addView(myView);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(mJsonObject);


        // linearLayout.addView(myView);

    }
}
