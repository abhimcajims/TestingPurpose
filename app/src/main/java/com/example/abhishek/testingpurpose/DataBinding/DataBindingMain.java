package com.example.abhishek.testingpurpose.DataBinding;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.abhishek.testingpurpose.R;
import com.example.abhishek.testingpurpose.databinding.DataBindingMainBinding;

public class DataBindingMain extends AppCompatActivity implements View.OnClickListener {

    DataBindingMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            binding = DataBindingUtil.setContentView(DataBindingMain.this, R.layout.data_binding_main);
            binding.btnClick.setOnClickListener(this);
            Intent oo = new Intent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_click:
                String temp = binding.tvName.getText().toString();
                binding.tvName.setText(binding.tvEmail.getText().toString());
                binding.tvEmail.setText(temp);
                break;

            default:
                Snackbar.make(binding.cnstMain, "Your Id not fount", Snackbar.LENGTH_LONG).show();
                break;
        }
       /* if (v.getId() == R.id.btn_click) {
            String temp = binding.tvName.getText().toString();
            binding.tvName.setText(binding.tvEmail.getText().toString());
            binding.tvEmail.setText(temp);
        }*/
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(DataBindingMain.this, "Press twice to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
