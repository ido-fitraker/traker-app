package com.traker.traker.activities.login_flow;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.traker.traker.R;
import com.traker.traker.beans.enums.FitnessGoal;
import com.traker.traker.beans.professionals.PersonalTrainer;
import com.traker.traker.components.TrakerButton;
import com.traker.traker.components.TrakerLinearLayout;
import com.traker.traker.components.TrakerPersonalTrainerLayout;
import com.traker.traker.util.loggers.TrakerLog;

import java.util.ArrayList;

public class TrainerChoosingActivity extends AppCompatActivity {

    // UI
    private LinearLayout mBackButton;
    private TrakerButton mSkipButton;
    private LinearLayout mTrainersLayout;

    // data
    private TrakerLinearLayout mChosenGoalLayout;
    private ImageView mChosenGoalImage;
    private TextView mChosenGoalText;

    private ArrayList<PersonalTrainer> mockList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer_choosing);
        mockList = initMockList();
        TrakerLog.i(TrakerLog.getCause()+" this is mockList: "+ mockList.toString());
        bindViews();
        initViews();
        initData();
        TrakerLog.i(TrakerLog.getCause()+" activated onCreate method.");
    }

    private ArrayList<PersonalTrainer> initMockList() {
        ArrayList<PersonalTrainer> list = new ArrayList<>();
        TrakerLog.i(TrakerLog.getCause()+" entered initMockList().");
        list.add(
            new PersonalTrainer("עידו אנגל", 3, 3, getResources().getString(R.string.my_goals_build_muscles_goal),
                    FitnessGoal.BUILD_MUSCLES_GOAL, true, true, false,
                                String.valueOf(R.drawable.coach_image_on)));
        TrakerLog.i(TrakerLog.getCause()+" added first.");
        list.add(
            new PersonalTrainer("גיא ליאני", 4, 3, getResources().getString(R.string.my_goals_general_goal),
                    FitnessGoal.GENERAL_GOAL, false, true, false,
                                String.valueOf(R.drawable.coach_image_on)));
        TrakerLog.i(TrakerLog.getCause()+" added second.");
        list.add(new PersonalTrainer("איתי נגר", 4, 6, getResources().getString(R.string.my_Goals_weight_loss_goal),
                FitnessGoal.WEIGHT_LOSS_GOAL, true, false, true,
                                String.valueOf(R.drawable.coach_image_on)));
        list.add(new PersonalTrainer("איתי נבות", 4, 6, getResources().getString(R.string.my_Goals_weight_loss_goal),
                FitnessGoal.WEIGHT_LOSS_GOAL, true, false, true,
                String.valueOf(R.drawable.coach_image_on)));
        list.add(new PersonalTrainer("הדר מקסימוב", 4, 6, getResources().getString(R.string.my_Goals_weight_loss_goal),
                FitnessGoal.WEIGHT_LOSS_GOAL, true, false, true,
                String.valueOf(R.drawable.coach_image_on)));
        list.add(new PersonalTrainer("דור ויזנר", 4, 6, getResources().getString(R.string.my_Goals_weight_loss_goal),
                FitnessGoal.WEIGHT_LOSS_GOAL, true, false, true,
                String.valueOf(R.drawable.coach_image_on)));
        TrakerLog.i(TrakerLog.getCause()+" added third.");
        TrakerLog.d(TrakerLog.getCause()+" initiated mock list.");
        return list;
    };

    private void bindViews() {
        mBackButton = (LinearLayout)findViewById(R.id.trainer_choosing_linear_layout_back_screen);
        mSkipButton = (TrakerButton)findViewById(R.id.trainer_choosing_skip_button);
        mChosenGoalLayout = (TrakerLinearLayout)findViewById(R.id.trainer_choosing_chosen_goal_layout);
        mChosenGoalImage = (ImageView)findViewById(R.id.trainer_choosing_chosen_goal_layout_goal_image);
        mChosenGoalText = (TextView)findViewById(R.id.trainer_choosing_chosen_goal_layout_goal_text);
        mTrainersLayout = (LinearLayout)findViewById(R.id.trainer_choosing_personal_trainers_list_layout);
        TrakerLog.d(TrakerLog.getCause()+" binded views.");
    }
    private void initViews(){
        assignBackButtonListener();
        assignSkipButtonListener();
        assignTrainerListener();
        TrakerLog.d(TrakerLog.getCause()+" initiated views.");
    }

    private void assignTrainerListener() {

    }

    private void initData(){
        loadGoalToScreen();
        loadPersonalTrainersList(mockList);
//                        (ArrayList<PersonalTrainer>)
//                        LoginManager.getInstance().getObject()
//                ));
        TrakerLog.d(TrakerLog.getCause()+" initiated data.");
    }
    private void assignSkipButtonListener() {
        mSkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skipTrainerChoosing();
            }
        });
        TrakerLog.d(TrakerLog.getCause()+"assigned skip button listener.");
    }

    // implement this method according to the next screen that should appear after this screen.
    private void skipTrainerChoosing() {
//        Intent i = new Intent(this, //some other activity.);
        TrakerLog.d(TrakerLog.getCause()+" skipped choosing trainer.");
    }

    private void assignBackButtonListener(){
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToPreviousScreen();

            }
        });
        TrakerLog.d(TrakerLog.getCause()+" assigned back button listener.");
    }

    private void returnToPreviousScreen() {
        Intent i = new Intent(this, MyGoalsActivity.class);
        startActivity(i);
        TrakerLog.d(TrakerLog.getCause()+" returned to previous screen.");
    }



    private void loadPersonalTrainersList(ArrayList<PersonalTrainer> trainers) {
        for(int i = 0; i < trainers.size(); i++){
                TrakerPersonalTrainerLayout trakerPersonalTrainerLayout = new TrakerPersonalTrainerLayout(this);
                TrakerLog.w(TrakerLog.getCause() + " initiated TrakerPersonaLinearLayout.");
                trakerPersonalTrainerLayout.setTrainer(trainers.get(i));
                trakerPersonalTrainerLayout.setTrakerPersonalTrainerLayoutInterface(
                        new TrakerPersonalTrainerLayout.TrakerPersonalTrainerLayoutInterface() {
                    @Override
                    public void onChooseTrainer(PersonalTrainer personalTrainer) {
                        chooseTrainer(personalTrainer);
                        TrakerLog.d(TrakerLog.getCause()+" activated chooseTrainer(PersonalTrainer).");
                    }
                });
                mTrainersLayout.addView(trakerPersonalTrainerLayout);

            }
        }

    private void chooseTrainer(PersonalTrainer personalTrainer) {
        Intent trainerIntent = new Intent(this, ChosenTrainerActivity.class);
        trainerIntent.putExtra("chosen_trainer", personalTrainer);
        TrakerLog.i(TrakerLog.getCause()+"my trainer: " + personalTrainer);
        startActivity(trainerIntent);
    }


    private void loadGoalToScreen() {
        Intent intent = getIntent();
        String fitnessGoalString = intent.getStringExtra("goal_chosen");
        fillLayoutMissingDetails(fitnessGoalString);
        TrakerLog.d(TrakerLog.getCause()+" goal loaded into screen.");
    }

    private void fillLayoutMissingDetails(String fitnessGoal){
        mChosenGoalLayout.setFitnessGoal(FitnessGoal.valueOf(fitnessGoal));
        mChosenGoalImage.setBackgroundResource(mChosenGoalLayout.getFitnessGoal().getImageUri());
        mChosenGoalText.setText(mChosenGoalLayout.getFitnessGoal().getName().toString());
        TrakerLog.d(TrakerLog.getCause()+" filled missing details in layout.");
        }

    }

