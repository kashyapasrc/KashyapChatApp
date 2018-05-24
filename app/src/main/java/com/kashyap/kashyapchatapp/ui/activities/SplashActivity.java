package com.kashyap.kashyapchatapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.kashyap.kashyapchatapp.R;

public class SplashActivity extends AppCompatActivity {


    public void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToMainActivity();
            }
        }, 600);

    }

    private void navigateToMainActivity() {
        Intent intent = MainActivity.getIntentWithNewTask(getApplicationContext());
        startActivity(intent);
        finish();
    }

}
