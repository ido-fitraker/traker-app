package com.traker.traker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.traker.traker.R;
import com.traker.traker.activities.login_flow.HealthFormActivity;
import com.traker.traker.activities.login_flow.MyGoalsActivity;
import com.traker.traker.activities.login_flow.RegistrationActivity;
import com.traker.traker.activities.login_flow.TrainerChoosingActivity;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
//                                          Intent i = new Intent(SplashActivity.this, RegistrationActivity.class);
                                          Intent i = new Intent(SplashActivity.this, HealthFormActivity.class);
                                          startActivity(i);

                                          finish();
                                      }
                                  },
                SPLASH_TIME_OUT);
    }
}