package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.traker.traker.beans.enums.FitnessGoal;

/**
 * Created by idoengel on 10/30/17.
 */

public class TrakerLinearLayout extends CustomTrakerLayout {
    private FitnessGoal fitnessGoal;


    public TrakerLinearLayout(Context context) {
        this(context, null);
    }

    public TrakerLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public void setBackgroundResource(int resid) {
        int pL = getPaddingLeft();
        int pT = getPaddingTop();
        int pR = getPaddingRight();
        int pB = getPaddingBottom();

        super.setBackgroundResource(resid);

        this.setPadding(pL, pT, pR, pB);
    }

    public FitnessGoal getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(FitnessGoal goal) {
        this.fitnessGoal = goal;
    }
}
