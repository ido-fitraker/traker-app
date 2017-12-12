package com.traker.traker.beans.enums;

import android.graphics.drawable.Drawable;

import com.traker.traker.R;

/**
 * Created by idoroiengel on 12/5/17.
 */

public enum PersonalProfileGoalLayoutEnum {

    WEIGHT(R.string.personal_profile_goal_layout_enum_weight,
            R.drawable.weight_goal_icon),

    FAT_PERCENTAGE(R.string.personal_profile_goal_layout_enum_fat_percentage,
            R.drawable.personal_profile_goal_layout_enum_fat_goal),

    WEEKLY_TRAINING_AVERAGE(R.string.personal_profile_goal_layout_enum_weekly_training_average,
            R.drawable.personal_profile_goal_layout_weekly_training_average),

    TRAININGS_OUT_OF_WORKOUT_PLAN(R.string.personal_profile_goal_layout_enum_trainings_out_of_workout_plan,
            R.drawable.bottom_bar_workout_button);

    private final int string;
    private final int drawable;

    PersonalProfileGoalLayoutEnum(int string, int drawable) {
        this.string = string;
        this.drawable = drawable;
    }

    public int getString() {
        return string;
    }

    public int getImage() {
        return drawable;
    }



}