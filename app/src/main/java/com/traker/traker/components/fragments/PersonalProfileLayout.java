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

import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;

/**
 * Created by idoroiengel on 12/4/17.
 */

public class PersonalProfileLayout extends android.support.v4.app.Fragment {

    private TrakerUser mTrakerUser;
    private TextView mUserheight;
    private TextView mUserWeight;
    private LinearLayout mManagerView;

    private ArrayList<PersonalProfileGoalLayout> mGoalLayouts = new ArrayList<>();
//    private static final int[] LAYOUT_IDS = {
//            R.id.personal_profile_layout_current_weight_layout,
//            R.id.personal_profile_layout_current_fat_percentage_layout,
//            R.id.personal_profile_layout_weekly_training_average_layout,
//            R.id.personal_profile_layout_trainings_completed_layout
//    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        TrakerLog.d(TrakerLog.getCause() + "onAttach PersonalProfilefragment.");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TrakerLog.d(TrakerLog.getCause() + "onCreate PersonalProfileFragment.");
    }

    public PersonalProfileLayout() {
        super();
        TrakerLog.d(TrakerLog.getCause() + "went through constructor.");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = null;
        try {
            rootView = inflater.inflate(R.layout.personal_profile_layout, container, false);
        }catch (Exception e){
            TrakerLog.d(TrakerLog.getCause() + e.toString());
        }
        mManagerView = rootView.findViewById(R.id.personal_profile_layout_root_view);
        TrakerLog.d(TrakerLog.getCause() + "this is mManagerView:"+mManagerView.toString());
        bindViews(rootView);
        initFragment();
        TrakerLog.d(TrakerLog.getCause() + " onCreateView for PersonalProfileLayout.");
        return rootView;
    }

    private void bindViews(View rootView) {
        mUserWeight = rootView.findViewById(R.id.personal_profile_layout_personal_details_layout_content_content_personal_measurements_layout_initial_weight_value);
        mUserheight = rootView.findViewById(R.id.personal_profile_layout_personal_details_layout_content_content_personal_measurements_layout_height_layout_value);
        bindGoalsLayouts();
        TrakerLog.d(TrakerLog.getCause() + "binded views.");
    }

    private void bindGoalsLayouts() {
//        for (int id : LAYOUT_IDS) {
        for(int i = 0; i < 4; i++){
        PersonalProfileGoalLayout currentLayout = new PersonalProfileGoalLayout(getContext());
        mGoalLayouts.add(currentLayout);
        mManagerView.addView(currentLayout);
        }
        TrakerLog.d(TrakerLog.getCause() + "binded goals layouts.");
    }
    private void initFragment() {
        initGoalsEnumValues();
        TrakerLog.d(TrakerLog.getCause() + "initiated fragment.");
    }

    private void initGoalsEnumValues() {
        PersonalProfileGoalLayoutEnum[] values = PersonalProfileGoalLayoutEnum.values();
        for(int i = 0; i < mGoalLayouts.size(); i++){
            mGoalLayouts.get(i).setmPersonalProfileGoalLayoutEnum(values[i]);
        }
        TrakerLog.d(TrakerLog.getCause() + " initiated goals enum values.");
    }
    public static PersonalProfileLayout newInstance() {
        PersonalProfileLayout layout = new PersonalProfileLayout();
        TrakerLog.d(TrakerLog.getCause()+" created new instance: "+layout);
        return layout;
    }
}
















































//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        View rootView = null;
//        try {
//            rootView = inflater.inflate(R.layout.personal_profile_layout, container, false);
//        }catch (Exception e){
//            TrakerLog.w(TrakerLog.getCause() + e.toString());
//        }
//        bindViews(rootView);
//        initFragment(rootView);
//        TrakerLog.d(TrakerLog.getCause()+" onCreateView.");
//        return rootView;
//    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
////        bindViews(view);
////        initFragment(view);
//        TrakerLog.d(TrakerLog.getCause() + "onViewCreated.");
//    }

//    private void bindViews(View view) {
//        bindGoals(view);
//        mUserheight = view.findViewById(R.id.personal_profile_layout_personal_details_layout_content_content_personal_measurements_layout_height_layout_value);
//        mUserWeight = view.findViewById(R.id.personal_profile_layout_personal_details_layout_content_content_personal_measurements_layout_initial_weight_value);
//        TrakerLog.d(TrakerLog.getCause() + " binded views for PersonalProfileLayout.");
//    }
//
//    private void bindGoals(View view) {
//        for (int i = 0; i < LAYOUT_IDS.length; i++) {
//            PersonalProfileGoalLayout currentLayout = view.findViewById(LAYOUT_IDS[i]);
//            mGoalLayouts.add(currentLayout);
//
//        }
//    }
//
//    private void initFragment(View view){
//        loadDifferentGoalLayouts(mGoalLayouts);
//        loadDataToLayouts(view);
////        mTrakerUser = LoginManager.getLoggedinUser();
////        mUserheight.setText(Long.valueOf(mTrakerUser.getHeight()).toString() + R.string.height_cm);
////        mUserWeight.setText(Long.valueOf(mTrakerUser.getWeight()).toString() + R.string.weight_kg);
//         TrakerLog.d(TrakerLog.getCause() + " initiated fragment PersonalProfileLayout.");
//    }
//
//    private void loadDataToLayouts(View view) {
////        mTrakerUser = LoginManager.getLoggedinUser();
//        TrakerLog.d(TrakerLog.getCause() + " loaded data to PersonalProfile layouts.");
//    }
//
//    private void loadDifferentGoalLayouts(ArrayList<PersonalProfileGoalLayout> layoutList) {
//        for(PersonalProfileGoalLayout currentLayout : layoutList) {
//            PersonalProfileGoalLayoutEnum enumValue = assignEnumValue(currentLayout, i);
//        }
//
//        if (enumValue.equals(currentLayout.getmPersonalProfileGoalLayoutEnum())) {
//            TrakerLog.d(TrakerLog.getCause() + "found match between enum values.");
//        }
//
////            final PersonalProfileGoalLayout currentLayout = view.findViewById(layouts[i]);
////            TrakerLog.d(TrakerLog.getCause() + "current layout is: "+currentLayout);
////            mGoalLayouts.add(currentLayout);
//            PersonalProfileGoalLayoutEnum value = assignEnumValue(currentLayout, i);
////            currentLayout.setmPersonalProfileGoalLayoutEnum(value);
//
////            TrakerLog.i(TrakerLog.getCause() + "current layout enum value is: "+currentLayout.getmPersonalProfileGoalLayoutEnum());
//        }
//        TrakerLog.i(TrakerLog.getCause() + "ArrayList is:"+mGoalLayouts.toString());
//        TrakerLog.d(TrakerLog.getCause() + " loaded different goal layouts in PersonalProfileLayout.");
//    }
//
//    private PersonalProfileGoalLayoutEnum assignEnumValue(PersonalProfileGoalLayout layout, int index) {
//        PersonalProfileGoalLayoutEnum[] manager = PersonalProfileGoalLayoutEnum.values();
//        PersonalProfileGoalLayoutEnum enumValue = manager[index];
//        layout.setmPersonalProfileGoalLayoutEnum(enumValue);
//        TrakerLog.d(TrakerLog.getCause() + " assigned this value: " + enumValue +" to PersonalProfileGoalLayout.");
//        return enumValue;
//    }


