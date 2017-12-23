package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.traker.traker.R;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;

/**
 * Created by idoroiengel on 12/14/17.
 */

public class WorkoutFunctionButtonLayout extends CustomTrakerLayout {

    private static final int [] IMAGE_IDS = {
            R.id.workout_layout_function_buttons_layout_leader_list_button,
            R.id.workout_layout_function_buttons_layout_challenges_button,
            R.id.workout_layout_function_buttons_layout_training_session_history_button,
            R.id.workout_layout_function_buttons_layout_class_explorer_button
    };
    private WorkoutFunctionButtonsLayoutInterface mWorkoutFunctionButtonsLayoutListener;
    private ArrayList<ImageView> mFunctionButtonsList = new ArrayList<>();

    public WorkoutFunctionButtonLayout(Context context) {
        this(context, null);
        TrakerLog.d(TrakerLog.getCause() + "activated context-only constructor.");
    }

    public WorkoutFunctionButtonLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.workout_function_buttons_layout, this, true);
        bindViews();
        initViews();
        TrakerLog.d(TrakerLog.getCause() + " activated context+attributes cunstructor.");
    }


    public WorkoutFunctionButtonsLayoutInterface getmWorkoutFunctionButtonsLayoutListener() {
        return mWorkoutFunctionButtonsLayoutListener;
    }

    public void setmWorkoutFunctionButtonsLayoutListener(WorkoutFunctionButtonsLayoutInterface mWorkoutFunctionButtonsLayoutListener) {
        this.mWorkoutFunctionButtonsLayoutListener = mWorkoutFunctionButtonsLayoutListener;
    }

    private void bindViews() {
        bindImages(IMAGE_IDS);
        TrakerLog.d(TrakerLog.getCause() + "binded views.");
    }


    private void bindImages(int[] images) {
        for(int i = 0; i < images.length; i++) {
            ImageView curentImage = findViewById(images[i]);
            mFunctionButtonsList.add(curentImage);
        }
        TrakerLog.d(TrakerLog.getCause() + " binded images.");
    }
    private void initViews() {
        initCLickables();
        TrakerLog.d(TrakerLog.getCause() + " initiated views.");
    }

    private void initCLickables() {
        for(ImageView  image : mFunctionButtonsList){
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonCLicked(view);
                }
            });
        }
        TrakerLog.d(TrakerLog.getCause() + " initiated clickables.");
    }

    private void buttonCLicked(View view) {
        switch (view.getId()){
            case R.id.workout_layout_function_buttons_layout_leader_list_button:{
                mWorkoutFunctionButtonsLayoutListener.onLeadersListPressed();
                break;
            }
            case R.id.workout_layout_function_buttons_layout_challenges_button:{
                mWorkoutFunctionButtonsLayoutListener.onChallengesPressed();
                break;
            }
            case R.id.workout_layout_function_buttons_layout_training_session_history_button:{
                mWorkoutFunctionButtonsLayoutListener.onTrainingSessionHistoryPressed();
                break;
            }
            case R.id.workout_layout_function_buttons_layout_class_explorer_button:{
                mWorkoutFunctionButtonsLayoutListener.onClassExplorerPressed();
                break;
            }
        }
        TrakerLog.d(TrakerLog.getCause() + " function button clicked.");
    }


    public interface WorkoutFunctionButtonsLayoutInterface{
        void onLeadersListPressed();
        void onChallengesPressed();
        void onTrainingSessionHistoryPressed();
        void onClassExplorerPressed();
    }
}
