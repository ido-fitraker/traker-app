package com.traker.traker.beans.enums;

import android.content.Context;
import android.media.Image;

import com.traker.traker.R;
import com.traker.traker.components.MyGoalsLayout;

/**
 * Created by idoengel on 9/18/17.
 */

public enum FitnessGoal {

    BUILD_MUSCLES_GOAL("בניית שרירים", R.drawable.build_goal_icon),
    WEIGHT_LOSS_GOAL("ירידה במשקל", R.drawable.weight_goal_icon),
    PEACEFUL_LIFE_GOAL("שמירה על אורח חיים בריא ושליו", R.drawable.peaceful_life_goal_icon),
    STAMINA_GOAL("סיבולת לב ריאה", R.drawable.heart_goal_icon),
    GENERAL_GOAL("כללי", R.drawable.general_goal_icon),
    MILITARY_PREPARATION_GOAL("הכשרה לכושר קרבי", R.drawable.military_preparation_goal_icon);

    private final String name;
    private final int imageUri;

    FitnessGoal(String name, int imageUri){
        this.name = name;
        this.imageUri = imageUri;
    }

    public int getImageUri(){
        return imageUri;
    }

    public String getName() {
        return name;
    }
}
