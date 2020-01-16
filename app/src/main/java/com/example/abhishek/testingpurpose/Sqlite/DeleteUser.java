package com.example.abhishek.testingpurpose.Sqlite;


import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.abhishek.testingpurpose.R;
import com.example.abhishek.testingpurpose.databinding.ActivityDeleteUserBinding;

public class DeleteUser extends AppCompatActivity {

    ActivityDeleteUserBinding activityDeleteUserBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDeleteUserBinding = DataBindingUtil.setContentView(DeleteUser.this, R.layout.activity_delete_user);

    }

    public void delete(View view) {
        if (!activityDeleteUserBinding.etId.getText().toString().equalsIgnoreCase("")) {
            MyDbHandler myDbHandler = Temp.getMyDbHandler();
            if (myDbHandler != null) {
                int i=myDbHandler.deleteUser(activityDeleteUserBinding.etId.getText().toString());
                if(i==1){
                    Toast.makeText(DeleteUser.this, "User info deleted", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(DeleteUser.this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(DeleteUser.this, "Enter id first", Toast.LENGTH_LONG).show();
        }
    }
}
