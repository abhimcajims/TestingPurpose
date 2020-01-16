package com.example.abhishek.testingpurpose.JsonParsing;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.abhishek.testingpurpose.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home
        extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btn_click, btn_clickk;
    ConstraintLayout cons_layout;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private JsonArrayRequest jsonArrayRequest;



    private String url = "http://www.mocky.io/v2/5cf11457300000ca6c00bca3";

    //private String url = "http://www.mocky.io/v2/5cf0ef33300000040a00bb8d";
    //private String url ="http://pastebin.com/raw/Em972E5s";
    private static final String TAG = Home.class.getName();

    final ArrayList<String> al = new ArrayList<>();
    List<JsonDecoding> jj = new ArrayList<>();
    RecyclerView recycler_list;
    List<Person> jc = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_click = (Button) findViewById(R.id.btn_click);
        btn_clickk = (Button) findViewById(R.id.btn_clickk);
        cons_layout = (ConstraintLayout) findViewById(R.id.cons_layout);
        recycler_list = (RecyclerView) findViewById(R.id.recycler_list);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btn_clickk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycler_list.setAdapter(null);
                jc.clear();

            }
        });

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jj.clear();
                sendAndRequestResponse();

            }
        });


    }

    private void sendAndRequestResponse() {
//RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);


        // Initialize a new JsonArrayRequest instance
        jsonArrayRequest = new JsonArrayRequest(

                url,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Do something with response
                        //mTextView.setText(response.toString());

                        // Process the JSON
                        try {
                            /*// Loop through the array elements
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                JSONObject student = response.getJSONObject(i);

                                // Get the current student (json object) data
                                String firstName = student.getString("name");
                                String lastName = student.getString("email");
                                String age = student.getString("gender");


                            }*/


                           /* JSONObject jo;

                            for (int i = 0; i < response.length(); i++) {
                                //jo = new JSONObject();
                                jo = response.getJSONObject(i);
                                Gson gs = new GsonBuilder().create();
                                JsonDecoding jd = gs.fromJson(jo.toString(), JsonDecoding.class);
                                jj.add(jd);
                            }

                            int b = 10;
                            RecyclerAdapter rad = new RecyclerAdapter(jj, Home.this);
                            recycler_list.setHasFixedSize(true);
                            recycler_list.setLayoutManager(new LinearLayoutManager(Home.this));
                            recycler_list.setAdapter(rad);*/

                            JSONObject jo;
                            for (int i = 0; i < response.length(); i++) {
                                jo = response.getJSONObject(i);
                                Gson gs = new GsonBuilder().create();
                                Person jd = gs.fromJson(jo.toString(), Person.class);
                                jc.add(jd);

                                RecyclerAdapter rad = new RecyclerAdapter(jc, Home.this);
                                recycler_list.setHasFixedSize(true);
                                recycler_list.setLayoutManager(new LinearLayoutManager(Home.this));
                                recycler_list.setAdapter(rad);
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Snackbar.make(
                                cons_layout,
                                "Error...",
                                Snackbar.LENGTH_LONG
                        ).show();
                    }
                }
        );

        // Add JsonArrayRequest to the RequestQueue
        mRequestQueue.add(jsonArrayRequest);

       /* //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i(TAG,"Error :" + error.toString());
            }
        });*/

        // mRequestQueue.add(mStringRequest);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
