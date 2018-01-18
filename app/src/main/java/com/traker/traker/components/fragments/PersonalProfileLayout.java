package com.traker.traker.components.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.traker.traker.R;
import com.traker.traker.beans.TrakerUser;
import com.traker.traker.beans.enums.PersonalProfileGoalLayoutEnum;
import com.traker.traker.components.PersonalProfileGoalLayout;

import com.traker.traker.utils.TrakerApplication;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;

/**
 * Created by idoroiengel on 12/4/17.
 */

public class PersonalProfileLayout extends android.support.v4.app.Fragment {

//    private static View mRootView;
    private TrakerUser mTrakerUser;
    private TextView mUserheight;
    private TextView mUserWeight;
    private static LinearLayout mManagerView;

    private ArrayList<PersonalProfileGoalLayout> mGoalLayouts = new ArrayList<>();
    private static final int[] LAYOUT_IDS = {
            R.id.personal_profile_layout_current_weight_layout,
            R.id.personal_profile_layout_current_fat_percentage_layout,
            R.id.personal_profile_layout_weekly_training_average_layout,
            R.id.personal_profile_layout_trainings_completed_layout
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mManagerView = (LinearLayout) inflater.inflate(R.layout.personal_profile_layout, container, false);
        TrakerLog.d(TrakerLog.getCause() + "this is mManagerView:"+mManagerView.toString());
        bindViews();
        initFragment();
        TrakerLog.d(TrakerLog.getCause() + " onCreateView for PersonalProfileLayout.");
        return mManagerView;
    }

    private void bindViews() {
        mUserWeight = mManagerView.findViewById(R.id.personal_profile_layout_personal_details_layout_content_content_personal_measurements_layout_initial_weight_value);
        mUserheight = mManagerView.findViewById(R.id.personal_profile_layout_personal_details_layout_content_content_personal_measurements_layout_height_layout_value);
        bindGoalsLayouts(LAYOUT_IDS);
        TrakerLog.d(TrakerLog.getCause() + "binded views.");
    }

    /*
    make changes to fit the same logic as in workout layout binding methods.
     */
    private void bindGoalsLayouts(int[] layouts) {
        for(int i = 0; i < layouts.length; i++){
        PersonalProfileGoalLayout currentLayout = mManagerView.findViewById(layouts[i]);
        TrakerLog.d(TrakerLog.getCause() + " my enum: " + currentLayout.toString());
        mGoalLayouts.add(currentLayout);
//        mManagerView.addView(currentLayout);
        }
        TrakerLog.d(TrakerLog.getCause() + "binded goals layouts.");
    }
    private void initFragment() {
        initGoalsEnumValues();
        TrakerLog.d(TrakerLog.getCause() + "initiated fragment.");
    }

    private void initGoalsEnumValues() {
        PersonalProfileGoalLayoutEnum[] values = PersonalProfileGoalLayoutEnum.values();
        TrakerLog.d(TrakerLog.getCause() + " values is: " + values);
        TrakerLog.d(TrakerLog.getCause() + "mGoalLayouts size is : " + mGoalLayouts.size());
        for(int i = 0; i < mGoalLayouts.size(); i++){
            mGoalLayouts.get(i).setmPersonalProfileGoalLayoutEnum(values[i]);
            TrakerLog.d(TrakerLog.getCause() + mGoalLayouts.get(i).getmPersonalProfileGoalLayoutEnum().getString());
            TrakerLog.d(TrakerLog.getCause() + " my enum: " + mGoalLayouts.get(i).toString());
        }
        TrakerLog.d(TrakerLog.getCause() + " initiated goals enum values.");
    }
    public static PersonalProfileLayout newInstance() {
        PersonalProfileLayout layout = new PersonalProfileLayout();
        TrakerLog.d(TrakerLog.getCause()+" created new instance: "+layout);
        return layout;
    }
}