package com.traker.traker.beans.enums;

import com.traker.traker.R;

/**
 * Created by idoroiengel on 11/26/17.
 */

public enum MainBottomBarEnum {

    MENU_BUTTON(R.drawable.bottom_bar_menu_button, R.drawable.bottom_bar_menu_button_chosen),
    HOME_BUTTON(R.drawable.bottom_bar_home_button, R.drawable.bottom_bar_home_button_chosen),
    PERSONAL_PROFILE_BUTTON(R.drawable.bottom_bar_personal_profile_button, R.drawable.bottom_bar_personal_profile_button_chosen),
    WORKOUT_BUTTON(R.drawable.bottom_bar_workout_button, R.drawable.bottom_bar_workout_button_chosen),
    CALENDAR_BUTTON(R.drawable.bottom_bar_calendar_button, R.drawable.bottom_bar_calendar_button_chosen),;

    private final int id;
    private final int chosenId;

    MainBottomBarEnum(int id, int chosenId) {
        this.id = id;
        this.chosenId = chosenId;
    }

    public int getId() {
        return id;
    }

    public int getChosenId() {
        return chosenId;
    }
}

