package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;

import com.traker.traker.R;
import com.traker.traker.beans.enums.FitnessGoal;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;

/**
 * Created by idoengel on 10/30/17.
 */

public class MyGoalsLayout extends TableLayout {
    private static final int[] GOALS_BUTTONS = {
            R.id.my_goals_table_layout_first_row_build_muscles_layout,
            R.id.my_goals_table_layout_first_row_weight_loss_layout,
            R.id.my_goals_table_layout_second_row_peaceful_life_layout,
            R.id.my_goals_table_layout_second_row_stamina_layout,
            R.id.my_goals_table_layout_third_row_general_goal_layout,
            R.id.my_goals_table_layout_third_row_military_goal_layout,
    };

    private ArrayList<TrakerLinearLayout> mGoalsButtons;
    private MyGoalsInterface mGoalsListener;

    public MyGoalsLayout(Context context) {
        this(context, null);
        TrakerLog.d(TrakerLog.getCause()+" activated context-only constructor.");
    }

    public MyGoalsLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(
                R.layout.my_goals_layout,
                this,
                true);
        initGoals(GOALS_BUTTONS);
        TrakerLog.d(TrakerLog.getCause()+" activated context+attributes constructor.");
    }

    public ArrayList<TrakerLinearLayout> getmGoalsButtons() {
        return mGoalsButtons;
    }

    private void initGoals(int[] goalsButtons) {
        mGoalsButtons = new ArrayList<>();
        for(int i = 0; i < goalsButtons.length; i++){
            final TrakerLinearLayout layout = findViewById(goalsButtons[i]);
            layout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    goalSelected(layout);
                }
            });
            assignEnumValue(layout, i);
            mGoalsButtons.add(layout);
        }
        TrakerLog.d(TrakerLog.getCause()+" initiated goals.");
    }

    private void assignEnumValue(TrakerLinearLayout layout, int index) {
        FitnessGoal[] myGoals = FitnessGoal.values();
        layout.setFitnessGoal(myGoals[index]);
//        for(int j = 0; j < myGoals.length; j++){
//            FitnessGoal tempMatch = myGoals[j];
//            if(tempMatch.ordinal() == index)
//                layout.setFitnessGoal(tempMatch);
//        }
        TrakerLog.d(TrakerLog.getCause()+" enum value "+
                layout.getFitnessGoal().toString()+" assigend to TrakerLineaLayout.");
    }

    public void setmGoalsListener(MyGoalsInterface mGoalsListener) {
        this.mGoalsListener = mGoalsListener;
        TrakerLog.i(TrakerLog.getCause()+" activated setter for MyGoalsInterface.");
    }

    private void goalSelected(TrakerLinearLayout layout) {
        mGoalsListener.onPressed(layout);
        TrakerLog.i(TrakerLog.getCause()+" activated goalSelected method.");
    }

    public interface MyGoalsInterface{
        void onPressed(TrakerLinearLayout layout);
    }
}
