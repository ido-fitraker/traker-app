package com.traker.traker.activities.login_flow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.beans.professionals.PersonalTrainer;
import com.traker.traker.components.TrakerButton;
import com.traker.traker.components.VerticalTrakerPersonalTrainerLayout;
import com.traker.traker.utils.TrakerLog;

// TODO increase trainer's photo size to be better positioned. rearrange layout to ltr orientation.
public class ChosenTrainerActivity extends AppCompatActivity {

    // UI
    private LinearLayout mBackScreen;
    private TrakerButton mContinueButton;

    // data
    private VerticalTrakerPersonalTrainerLayout mTrainerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_trainer);
        bindViews();
        initViews();
        initData();
        TrakerLog.d(TrakerLog.getCause()+" onCreate method.");
    }
    private void bindViews() {
        mBackScreen = (LinearLayout) findViewById(R.id.chosen_trainer_linear_layout_back_screen);
        mContinueButton = (TrakerButton) findViewById(R.id.chosen_trainer_continue_button);
        mTrainerLayout = (VerticalTrakerPersonalTrainerLayout) findViewById(R.id.chosen_trainer_personal_trainer_layout);
        TrakerLog.d(TrakerLog.getCause()+" binded views.");
    }

    private void initViews() {
        assignListeners();
        TrakerLog.d(TrakerLog.getCause()+" initiated views.");
    }
    private void setupPersonalTraining() {
        Toast.makeText(this, "TBD", Toast.LENGTH_SHORT).show();
        // TODO implement method according requirements.
    }

    private void initData() {
        mTrainerLayout.setTrainer((PersonalTrainer) getIntent().getExtras().get("chosen_trainer"));
        TrakerLog.d(TrakerLog.getCause()+" initiated data.");
    }

    private void assignListeners(){
        mBackScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToPreviousScreen();
            }
        });
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupPersonalTraining();
            }
        });
        TrakerLog.d(TrakerLog.getCause()+" assigned listeners.");
    }
    private void returnToPreviousScreen(){
        Intent i = new Intent(this, TrainerChoosingActivity.class);
        startActivity(i);
        TrakerLog.d(TrakerLog.getCause()+" returned to previous screen.");
    }
}
