package com.traker.traker.components;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.traker.traker.R;
import com.traker.traker.beans.enums.MainBottomBarEnum;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;

/**
 * Created by idoroiengel on 11/25/17.
 */

public class MainBottomBar extends CustomTrakerLayout {

    private MainBottomBarInterface mainBottomBarInterface;
    private static final int[] BUTTON_IDS = new int[]{
            R.id.main_bottom_bar_menu_button,
            R.id.main_bottom_bar_home_button,
            R.id.main_bottom_bar_profile_button,
            R.id.main_bottom_bar_workout_button,
            R.id.main_bottom_bar_calendar_button
    };
    private ArrayList<TrakerImageButton> mButtonsList;

    private TrakerImageButton mMenuButton;
    private TrakerImageButton mHomeButton;
    private TrakerImageButton mProfileButton;
    private TrakerImageButton mWorkoutButton;
    private TrakerImageButton mCalendarButton;

    public MainBottomBar(Context context) {
        this(context, null);
        TrakerLog.i(TrakerLog.getCause()+" activated only-context constructor");
    }

    public MainBottomBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.main_bottom_bar_layout, this, true);
        bindViews();
        populateBar(BUTTON_IDS);

        TrakerLog.i(TrakerLog.getCause()+" activated context+attributes constructor");

    }

    public ArrayList<TrakerImageButton> getmButtonsList() {
        return mButtonsList;
    }

    private void populateBar(int[] buttons) {
        mButtonsList = new ArrayList<>();
        for(int i = 0; i < buttons.length; i++){
            final TrakerImageButton button = findViewById(buttons[i]);
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonClicked(button);
                }
            });
            mButtonsList.add(button);
            assignEnumValue(button, i);
        }
    }

    private void assignEnumValue(TrakerImageButton button, int index) {
        MainBottomBarEnum[] values = MainBottomBarEnum.values();
        button.setEnumValue(values[index]);
    }

    public void setMainBottomBarListener(MainBottomBarInterface mainBottomBarListener) {
        this.mainBottomBarInterface = mainBottomBarListener;
        TrakerLog.d(TrakerLog.getCause()+" activated setMainBottomBarListener.");
    }

    private void bindViews() {
        mMenuButton = findViewById(R.id.main_bottom_bar_menu_button);
        mHomeButton = findViewById(R.id.main_bottom_bar_home_button);
        mProfileButton = findViewById(R.id.main_bottom_bar_profile_button);
        mWorkoutButton = findViewById(R.id.main_bottom_bar_workout_button);
        mCalendarButton = findViewById(R.id.main_bottom_bar_calendar_button);
        TrakerLog.d(TrakerLog.getCause()+" binded views.");
    }

    private void buttonClicked(TrakerImageButton button){
        updateBarButtons(button);
        activateSuperListener(button);
        }



    private void updateBarButtons(TrakerImageButton button) {
        for (TrakerImageButton imageButton : mButtonsList) {
            if (imageButton.equals(button)) {
                imageButton.setImageResource(imageButton.getEnumValue().getChosenId());
            } else {
                imageButton.setImageResource(imageButton.getEnumValue().getId());
            }
        }
    }
    private void activateSuperListener(TrakerImageButton button) {
        switch(button.getId()){
            case R.id.main_bottom_bar_menu_button: {
                mainBottomBarInterface.onMenuButtonClicked();
                TrakerLog.d(TrakerLog.getCause()+" bottom_bar_menu_button button clicked.");
                break;

            }
            case R.id.main_bottom_bar_home_button: {
                mainBottomBarInterface.onHomeButtonClicked();
                TrakerLog.d(TrakerLog.getCause()+" bottom_bar_home_button_chosen button clicked.");
                break;

            }
            case R.id.main_bottom_bar_profile_button: {
//                Intent i = new Intent(this, PersonalProfileActivity.class);
                mainBottomBarInterface.onProfileButtonClicked();
                TrakerLog.d(TrakerLog.getCause()+" bottom_bar_personal_profile_button button clicked.");
                break;

            }
            case R.id.main_bottom_bar_workout_button: {
                mainBottomBarInterface.onWorkoutButtonClicked();
                TrakerLog.d(TrakerLog.getCause()+" bottom_bar_workout_button button clicked.");
                break;

            }
            case R.id.main_bottom_bar_calendar_button: {
                mainBottomBarInterface.onCalendarButtonClicked();
                TrakerLog.d(TrakerLog.getCause()+" bottom_bar_calendar_button button clicked.");
                break;
            }
        }
    }


    public interface MainBottomBarInterface{
        void onMenuButtonClicked();
        void onHomeButtonClicked();
        void onProfileButtonClicked();
        void onWorkoutButtonClicked();
        void onCalendarButtonClicked();
    }

}

