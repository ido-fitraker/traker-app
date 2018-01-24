package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.traker.traker.R;
import com.traker.traker.beans.TrakerUser;
import com.traker.traker.beans.enums.FitnessGoal;
import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoroiengel on 11/18/17.
 */

public class MainTopBar extends CustomTrakerLayout {

    private TextView mCurrentLevelLayout;
    private TrakerLevelStar mCurrentLevelImage;
    private TextView mCoinsNumber;
    private TextView mFitnessGoal;
    private ImageView mNotificationsNumber;
    private LinearLayout mNotificationsLayout;
    private MainTopBarInterface mMainTopBarInterface;

    public MainTopBar(Context context) {
        this(context, null);
        TrakerLog.i(TrakerLog.getCause()+" activated only-context constructor");
    }

    public MainTopBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.main_top_bar_layout, this, true);
        bindViews();
        initViews();
        TrakerLog.i(TrakerLog.getCause()+" activated context+attributes constructor");
    }
    private void bindViews() {
        mCurrentLevelLayout = findViewById(R.id.main_top_bar_current_level_layout_levels_layout_road_to_next_level);
        mCurrentLevelImage = findViewById(R.id.main_top_bar_current_level_layout_levels_layout_current_level_image);
        mCoinsNumber = findViewById(R.id.main_top_bar_coins_layout_coin_layout_text);
        mFitnessGoal = findViewById(R.id.main_top_bar_layout_goals_layout_goal_layout_text);
        mNotificationsNumber = findViewById(R.id.main_top_bar_layout_notifications_layout_number_image);
        mNotificationsLayout = findViewById(R.id.main_top_bar_layout_notifications_layout);
        TrakerLog.d(TrakerLog.getCause()+" binded views.");
    }

    private void initViews() {
        mNotificationsLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainTopBarInterface.onNotificationClicked();
            }
        });
        initiate(new TrakerUser());
        TrakerLog.d(TrakerLog.getCause() + " initiated views.");
    }

    public void setmMainTopBarInterface(MainTopBarInterface mMainTopBarInterface) {
        this.mMainTopBarInterface = mMainTopBarInterface;
    }

    public void initiate(TrakerUser user) {
        // take needed points to next level.
        // take current level number and add it to image top_bar_star_no_number.


//        mCoinsNumber.setText(user.getCoins());
        mCoinsNumber.setText("15");
//        mCurrentLevelImage.setmLevel(user.getLevel());
        mCurrentLevelImage.setmLevel(7);
//        mFitnessGoal.setText(user.getFitnessGoal().toString());
        mFitnessGoal.setText(FitnessGoal.BUILD_MUSCLES_GOAL.getName());
        // take notifications number from user.
        TrakerLog.d(TrakerLog.getCause()+" initiated main top bar.");
    }

    public interface MainTopBarInterface {
        void onNotificationClicked();

    }
}
