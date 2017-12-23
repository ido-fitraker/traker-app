package com.traker.traker.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

public class PersonalProfileGoalLayout extends CustomTrakerLayout {

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
        LayoutInflater.from(context).inflate(R.layout.personal_profile_goal_layout, this, true);
        bindViews();
        TrakerLog.d(TrakerLog.getCause() + "activated context+attributes constructor.");
    }

    public PersonalProfileGoalLayoutEnum getmPersonalProfileGoalLayoutEnum() {
        return mPersonalProfileGoalLayoutEnum;
    }

    public void setmPersonalProfileGoalLayoutEnum(PersonalProfileGoalLayoutEnum mPersonalProfileGoalLayoutEnum) {
        this.mPersonalProfileGoalLayoutEnum = mPersonalProfileGoalLayoutEnum;
        initViews();
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
        mSpecificGoalImage.setImageResource(mPersonalProfileGoalLayoutEnum.getImage());
        mGoalName.setText(getResources().getString(mPersonalProfileGoalLayoutEnum.getString()));
        TrakerLog.d(TrakerLog.getCause() + "initiated views.");
    }

    @Override
    public String toString() {
        return "PersonalProfileGoalLayout{" +
                "mSpecificGoalImage=" + mSpecificGoalImage +
                ", mGoalName=" + mGoalName +
                ", mGoalValue=" + mGoalValue +
                ", mGoalIcon=" + mGoalIcon +
                ", mGoalText=" + mGoalText +
                ", mGoalTextValue=" + mGoalTextValue +
                ", mGoalGraphicScale=" + mGoalGraphicScale +
                ", mPersonalProfileGoalLayoutEnum=" + mPersonalProfileGoalLayoutEnum +
                '}';
    }
}
