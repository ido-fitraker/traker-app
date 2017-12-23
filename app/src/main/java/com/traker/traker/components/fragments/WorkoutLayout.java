package com.traker.traker.components.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.components.TrakerLinearLayout;
import com.traker.traker.components.WorkoutFunctionButtonLayout;
import com.traker.traker.utils.TrakerApplication;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;

/**
 * Created by idoroiengel on 12/13/17.
 */

public class WorkoutLayout extends android.support.v4.app.Fragment{

    private static View mRootView;
    private WorkoutFunctionButtonLayout.WorkoutFunctionButtonsLayoutInterface mWokroutFunctionButtonsLayoutListener;
    private WorkoutFunctionButtonLayout mFunctionButtonsLayout;
    private WorkoutLayoutInterfece mWorkoutLayoutListener;

    private static final int[] MUSCLES_GROUP_LAYOUT_IDS = {
        R.id.workout_layout_muscles_group_layout_a_group,
        R.id.workout_layout_muscles_group_layout_b_group,
        R.id.workout_layout_muscles_group_layout_c_group
    };

    private ArrayList<TrakerLinearLayout> mMusclesGroupList= new ArrayList<>();
    private TrakerLinearLayout mNewTrainingSessionLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.workout_layout, container, false);
        bindViews();
        initViews();
        TrakerLog.d(TrakerLog.getCause() + "onCreateView for WorkoutLayout.");
        return mRootView;
    }

    public WorkoutFunctionButtonLayout.WorkoutFunctionButtonsLayoutInterface getmWokroutFunctionButtonsLayoutListener() {
        return mWokroutFunctionButtonsLayoutListener;
    }

    public void setmWokroutFunctionButtonsLayoutListener(WorkoutFunctionButtonLayout.WorkoutFunctionButtonsLayoutInterface mWokroutFunctionButtonsLayoutListener) {
        this.mWokroutFunctionButtonsLayoutListener = mWokroutFunctionButtonsLayoutListener;
    }

    private void bindViews() {
        mNewTrainingSessionLayout = mRootView.findViewById(R.id.workout_layout_new_training_session_layout);
        mFunctionButtonsLayout = mRootView.findViewById(R.id.workout_layout_workout_function_buttons_layout);
        bindLists();
        TrakerLog.d(TrakerLog.getCause() + " binded views.");
    }

    private void bindLists() {
        bindMusclesGroupLayouts(MUSCLES_GROUP_LAYOUT_IDS);
        TrakerLog.d(TrakerLog.getCause() + " binded lists.");
    }

    private void bindMusclesGroupLayouts(int[] musclesGroupIds) {
            for(int i = 0; i < musclesGroupIds.length; i++){
            TrakerLinearLayout currentLayout = mRootView.findViewById(musclesGroupIds[i]);
            mMusclesGroupList.add(currentLayout);
        }
        TrakerLog.d(TrakerLog.getCause() + "binded muscles group layouts.");
    }


    private void initViews() {
        implementFunctionButtonsLayout();
        animateTrainingSessionButton();
        TrakerLog.d(TrakerLog.getCause() + " initiated views.");
    }

    private void animateTrainingSessionButton() {
        mNewTrainingSessionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginNewTrainingSession();
            }
        });
    }

    private void beginNewTrainingSession() {
        Toast.makeText(TrakerApplication.getContext(), "pressed new training session", Toast.LENGTH_SHORT).show();
        TrakerLog.d(TrakerLog.getCause() + " asked to begin new training session.");
    }

    private void implementFunctionButtonsLayout() {
        mFunctionButtonsLayout.setmWorkoutFunctionButtonsLayoutListener(new WorkoutFunctionButtonLayout.WorkoutFunctionButtonsLayoutInterface() {
            @Override
            public void onLeadersListPressed() {
                showLeaders();
                Toast.makeText(getContext(), "pressed leaders list button.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChallengesPressed() {
                showChallenges();
                Toast.makeText(getContext(), "pressed challenges button.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTrainingSessionHistoryPressed() {
                showTrainingSessionHistory();
                Toast.makeText(getContext(), "pressed training session history button.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClassExplorerPressed() {
                showClassExplorer();
                Toast.makeText(getContext(), "pressed class explorer button.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void showLeaders() {
//        LeadersLayout.newInstance();
        mWorkoutLayoutListener.onLeadersListClicked();
        TrakerLog.d(TrakerLog.getCause() + " showing leaders.");
    }

    private void showChallenges() {
//        ChallengesLayout.newInstance();
        mWorkoutLayoutListener.onChallengesClicked();
        TrakerLog.d(TrakerLog.getCause() + " showing challenges.");
    }

    private void showTrainingSessionHistory() {
//        TrainingSessionHistory.newInstance();
        mWorkoutLayoutListener.onTrainingSessionHistoryCLicked();
        TrakerLog.d(TrakerLog.getCause() + " showing session history.");
    }

    private void showClassExplorer() {
        Fragment fragment = ClassExplorerLayout.newInstance();
        mWorkoutLayoutListener.onClassExplorerClicked(fragment);
        TrakerLog.d(TrakerLog.getCause() + " showing class explorer.");
    }

    public static WorkoutLayout newInstance() {
        WorkoutLayout layout = new WorkoutLayout();
        TrakerLog.d(TrakerLog.getCause() + " created new instance.");
        return layout;
    }

    public interface WorkoutLayoutInterfece{
        void onLeadersListClicked();
        void onChallengesClicked();
        void onTrainingSessionHistoryCLicked();
        void onClassExplorerClicked(Fragment fragment);
    }
}
