package com.example.abhishek.testingpurpose.Sqlite;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.abhishek.testingpurpose.R;
import com.example.abhishek.testingpurpose.databinding.ActivityUpdateUserBinding;


public class UpdateUser extends AppCompatActivity {

    //ActivityUpdateUserBinding activityUpdateUserBinding;
    ActivityUpdateUserBinding activityUpdateUserBinding;
    MyDbHandler myDbHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityUpdateUserBinding = DataBindingUtil.setContentView(UpdateUser.this, R.layout.activity_update_user);
        myDbHandler=Temp.getMyDbHandler();

    }

    public void Update(View view) {
        User user = new User();
        user.setId(activityUpdateUserBinding.etId.getText().toString());
        user.setName(activityUpdateUserBinding.etName.getText().toString());
        user.setEmail(activityUpdateUserBinding.etMail.getText().toString());
        user.setPhone(activityUpdateUserBinding.etPhone.getText().toString());
        if (myDbHandler!=null) {
            boolean check = myDbHandler.UpdateUser(user);
            if (check ) {
                Toast.makeText(UpdateUser.this, "User Updated successfully", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(UpdateUser.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        }
    }
}
