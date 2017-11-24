package com.traker.traker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.traker.traker.R;
import com.traker.traker.activities.login_flow.HealthFormActivity;
import com.traker.traker.activities.login_flow.MyGoalsActivity;
import com.traker.traker.activities.login_flow.PersonalDetailsActivity;
import com.traker.traker.activities.login_flow.RegistrationActivity;
import com.traker.traker.activities.login_flow.TrainerChoosingActivity;
import com.traker.traker.managers.LoginManager;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
//                                          Intent i = new Intent(SplashActivity.this, RegistrationActivity.class);
                                          Intent i = new Intent(SplashActivity.this,
                                                  LoginManager.getInstance().LOGIN_ACTIVITIES[0]);
//                                                  PersonalDetailsActivity.class);
                                          startActivity(i);

                                          finish();
                                      }
                                  },
                SPLASH_TIME_OUT);
    }
}