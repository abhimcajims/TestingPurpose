package com.example.abhishek.testingpurpose.Torch;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.abhishek.testingpurpose.R;

import okhttp3.logging.HttpLoggingInterceptor;

public class FlashLight extends Activity {

    ToggleButton onOffFlashlight;
    private static final int CAMERA_REQUEST = 50;
    Boolean hasFlashLight;
    boolean isEnabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_light);
        onOffFlashlight = findViewById(R.id.onOffFlashlight);
        hasFlashLight = this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);




        isEnabled = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED;

        if (!isEnabled) {
            ActivityCompat.requestPermissions(FlashLight.this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);
        }

        onOffFlashlight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (hasFlashLight && isEnabled) {
                    if (checked) {
                        flashLightOn();
                        onOffFlashlight.setTextOn("Turn Off");

                    } else {
                        flashLightOff();
                        onOffFlashlight.setTextOff("Turn On");
                    }
                } else {
                }
            }
        });
    }

    private void flashLightOn() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);


        } catch (CameraAccessException e) {
        }
    }

    private void flashLightOff() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
        } catch (CameraAccessException e) {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQUEST:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    isEnabled = true;

                } else {
                    Toast.makeText(FlashLight.this, "Permission Denied for the Camera", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
