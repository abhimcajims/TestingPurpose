package com.example.abhishek.testingpurpose.Sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.abhishek.testingpurpose.R;

import java.util.List;

public class SqliteMain extends Activity implements View.OnClickListener {


    Button btn_insert, btn_update, btn_display, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_main);
        init();
        btn_insert.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_display.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        MyDbHandler db = new MyDbHandler(this, MyDbHandler.DATABASE_NAME, null, 1);

        Temp.setMyDbHandler(db);

    }

    private void init() {

        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_display = (Button) findViewById(R.id.btn_display);
        btn_delete = (Button) findViewById(R.id.btn_delete);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_insert:
                startActivity(new Intent(SqliteMain.this, InsertUser.class));
                break;
            case R.id.btn_update:

                startActivity(new Intent(SqliteMain.this, UpdateUser.class));

                break;
            case R.id.btn_display:
                startActivity(new Intent(SqliteMain.this, ViewUser.class));

                break;
            case R.id.btn_delete:
                startActivity(new Intent(SqliteMain.this, DeleteUser.class));

                break;
            default:
                break;
        }
    }
}
