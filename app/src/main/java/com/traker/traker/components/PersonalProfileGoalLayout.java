package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.traker.traker.R;
import com.traker.traker.beans.enums.PersonalProfileGoalLayoutEnum;
import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoroiengel on 12/5/17.
 */

public class PersonalProfileGoalLayout extends CustomTrakerLayout{

    // UI
    private ImageView mSpecificGoalImage;
    private TextView mGoalName;
    private TextView mGoalValue;
    private ImageView mGoalIcon;
    private TextView mGoalText;
    private TextView mGoalTextValue;
    private ImageView mGoalGraphicScale;
    private PersonalProfileGoalLayoutEnum mPersonalProfileGoalLayoutEnum;


    public PersonalProfileGoalLayout(Context context) {
        this(context, null);
        TrakerLog.d(TrakerLog.getCause() + "activated context-only constructor.");
    }

    public PersonalProfileGoalLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        try {
            LayoutInflater.from(context).inflate(R.layout.personal_profile_goal_layout, this, true);
        }catch (Exception e){
            TrakerLog.w(TrakerLog.getCause() + e.toString());
        }finally {
            TrakerLog.w(TrakerLog.getCause() + "went through inflater.");
        }
        bindViews();
        initViews();
        TrakerLog.d(TrakerLog.getCause() + "activated context+attributes constructor.");
    }

    public PersonalProfileGoalLayoutEnum getmPersonalProfileGoalLayoutEnum() {
        return mPersonalProfileGoalLayoutEnum;
    }

    public void setmPersonalProfileGoalLayoutEnum(PersonalProfileGoalLayoutEnum mPersonalProfileGoalLayoutEnum) {
        this.mPersonalProfileGoalLayoutEnum = mPersonalProfileGoalLayoutEnum;
        TrakerLog.d(TrakerLog.getCause() + "activated set method for enum value.");
    }

    private void bindViews() {
        mSpecificGoalImage = findViewById(R.id.personal_profile_goal_layout_goal_image);
        mGoalName = findViewById(R.id.personal_profile_goal_layout_goal_name);
        mGoalValue = findViewById(R.id.personal_profile_goal_layout_goal_value);
        mGoalIcon = findViewById(R.id.personal_profile_goal_layout_goal_icon);
        mGoalText = findViewById(R.id.personal_profile_goal_layout_goal_text);
//        TrakerLog.d(TrakerLog.getCause() + mSpecificGoalImage.toString());
        TrakerLog.d(TrakerLog.getCause() + " binded views.");
    }

    private void initViews() {
        mSpecificGoalImage.setImageResource(R.drawable.personal_profile_goal_layout_fat_percentage_icon);
        mGoalName.setText(mPersonalProfileGoalLayoutEnum.getString());
        TrakerLog.d(TrakerLog.getCause() + "initiated views.");
    }



}
