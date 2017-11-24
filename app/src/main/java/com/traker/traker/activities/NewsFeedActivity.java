package com.traker.traker.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.traker.traker.R;
import com.traker.traker.components.MainTopBar;

public class NewsFeedActivity extends AppCompatActivity {

    private MainTopBar topBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
    }
}
