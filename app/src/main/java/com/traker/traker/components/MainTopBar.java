package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.traker.traker.R;

/**
 * Created by idoroiengel on 11/18/17.
 */

public class MainTopBar extends CustomTrakerLayout {

    private TextView mCurrentLevelLayout;
    private ImageView mCurrentLevelImage;
    private TextView mCoinsNumber;
    private TextView mFitnessGoal;
    private TextView mNotificationsNumber;

    public MainTopBar(Context context) {
        this(context, null);
    }

    public MainTopBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.main_top_bar_layout, this, true);
        bindViews();
//        ViewGroup.LayoutParams params = mCurrentLevelLayout.getLayoutParams();
//
//        params.width = 578/1000;
    }

    private void bindViews() {
        mCurrentLevelLayout = findViewById(R.id.main_top_bar_current_level_layout_levels_layout_road_to_next_level);
        mCurrentLevelImage = findViewById(R.id.main_top_bar_current_level_layout_levels_layout_current_level_image);
        mCoinsNumber = findViewById(R.id.main_top_bar_coins_layout_coin_layout_text);
        mFitnessGoal = findViewById(R.id.main_top_bar_layout_goals_layout_goal_layout_text);
        mNotificationsNumber = findViewById(R.id.main_top_bar_layout_notifications_layout_number_image);
    }
}
