package com.traker.traker.activities.login_flow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.components.MyGoalsLayout;
import com.traker.traker.components.TrakerButton;
import com.traker.traker.components.TrakerLinearLayout;
import com.traker.traker.managers.LoginManager;
import com.traker.traker.util.loggers.TrakerLog;

import java.util.ArrayList;

/**
 * Created by idoengel on 10/24/17.
 */

public class MyGoalsActivity extends AppCompatActivity {
    private LinearLayout mBackButton;
    private TrakerButton mContinueButton;
    private MyGoalsLayout mGoalsLayout;
    private boolean mGoalWasChosen;
    private Intent mNextScreenIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_goals);
        bindViews();
        initViews();
        TrakerLog.d(TrakerLog.getCause()+" onCreate method for MyGoalsActivity.");
    }
    private void bindViews(){
        mBackButton = (LinearLayout)findViewById(R.id.my_goals_linear_layout_back_screen);
        mContinueButton = (TrakerButton)findViewById(R.id.my_goals_continue_button);
        mGoalsLayout = (MyGoalsLayout)findViewById(R.id.my_goals_table_layout);
        TrakerLog.d(TrakerLog.getCause()+" binded views in MyGoalsActivity.");
    }
    private void initViews(){
        assignBackButtonListener();
        assignContinueButtonListener();
        mGoalWasChosen = false;
        mGoalsLayout.setmGoalsListener(new MyGoalsLayout.MyGoalsInterface() {
            @Override
            public void onPressed(TrakerLinearLayout layout) {
                changeGoalLayoutUI(layout);
                updateUserDetails(layout);
            }
        });
        mNextScreenIntent = new Intent(this, TrainerChoosingActivity.class);
        TrakerLog.d(TrakerLog.getCause()+" initiated views in MyGoalsActivity.");
    }

    private void changeGoalLayoutUI(TrakerLinearLayout layout) {
        ArrayList<TrakerLinearLayout> layoutList = mGoalsLayout.getmGoalsButtons();
        for(TrakerLinearLayout tll : layoutList){
            if(!tll.equals(layout)) {
                tll.setBackgroundResource(R.color.colorBlack);
            }
            else {
                layout.setBackgroundResource(R.drawable.chosen_traker_button_border);
            }
            }
        mGoalWasChosen = true;
        TrakerLog.d(TrakerLog.getCause()+" changed layoutUI.");
        TrakerLog.d(TrakerLog.getCause()+" flagged goal was chosen.");
    }
    private void updateUserDetails(TrakerLinearLayout layout){
        LoginManager.getLoggedinUser().setFitnessGoal(layout.getFitnessGoal());
        mNextScreenIntent.putExtra("goal_chosen", layout.getFitnessGoal().toString());

        TrakerLog.d(TrakerLog.getCause()+" updated logged-in user details");
    }

    private void continueToNextScreen() {
        startActivity(mNextScreenIntent);
        TrakerLog.d(TrakerLog.getCause()+" continuing to next screen.");
        TrakerLog.d(TrakerLog.getCause() + LoginManager.getLoggedinUser().toString());
    }

    private void assignBackButtonListener() {
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToPreviousScreen();
            }
        });
        TrakerLog.d(TrakerLog.getCause()+" assigned bakButton listener.");
    }

    private void returnToPreviousScreen() {
        Intent i = new Intent(this, HealthFormActivity.class);
        startActivity(i);
        finish();
        TrakerLog.d(TrakerLog.getCause()+" returning to previous screen.");
    }

    private void assignContinueButtonListener() {
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mGoalWasChosen)
                    continueToNextScreen();
                else
                    informNextScreenError();
            }
        });
        TrakerLog.d(TrakerLog.getCause()+" assigned continueButton listener.");
    }
    private void informNextScreenError() {
        Toast.makeText(this,"כדי להמשיך עליך לבחור מטרה ספציפית", Toast.LENGTH_SHORT).show();
        TrakerLog.i(TrakerLog.getCause()+" informed next screen error.");
    }

}
