package com.example.abhishek.testingpurpose.Sqlite;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abhishek.testingpurpose.R;
import com.example.abhishek.testingpurpose.databinding.InsertUserBinding;

public class InsertUser extends AppCompatActivity implements View.OnClickListener {


    InsertUserBinding insertUserBinding;

    MyDbHandler myDbHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_user);
        insertUserBinding = DataBindingUtil.setContentView(InsertUser.this, R.layout.insert_user);

        myDbHandler = Temp.getMyDbHandler();
    }

    public void Save(View view) {


        User user = new User();
        user.setId(insertUserBinding.etId.getText().toString());
        user.setName(insertUserBinding.etName.getText().toString());
        user.setEmail(insertUserBinding.etMail.getText().toString());
        user.setPhone(insertUserBinding.etPhone.getText().toString());
        if (myDbHandler!=null) {
            int check = myDbHandler.insertUser(user);
            if (check == 1) {
                Toast.makeText(InsertUser.this, "User Data Inserted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(InsertUser.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        }
    }


    @Override
    public void onClick(View v) {

    }
}
