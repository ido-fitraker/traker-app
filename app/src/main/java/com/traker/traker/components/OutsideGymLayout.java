package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoroiengel on 11/25/17.
 */

public class OutsideGymLayout extends TableLayout {

    private MainTopBar mTopBar;
    private MainBottomBar mBottomBar;
    private OutsideGymLayoutInterface mOutsideGymLayoutInterface;
    private TableRow mDynamicRow;


    public OutsideGymLayout(Context context) {
        this(context, null);
        TrakerLog.i(TrakerLog.getCause()+" activated only-context constructor");
    }

    public OutsideGymLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.outside_gym_layout, this, true);
        bindViews();
        initViews();
        TrakerLog.i(TrakerLog.getCause()+" activated context+attributes constructor");
    }

    public MainTopBar getmTopBar() {
        return mTopBar;
    }

    public void setmTopBar(MainTopBar mTopBar) {
        this.mTopBar = mTopBar;
    }

    public MainBottomBar getmBottomBar() {
        return mBottomBar;
    }

    public void setmBottomBar(MainBottomBar mBottomBar) {
        this.mBottomBar = mBottomBar;
    }

    public OutsideGymLayoutInterface getmOutsideGymLayoutInterface() {
        return mOutsideGymLayoutInterface;
    }

    public void setmOutsideGymLayoutInterface(OutsideGymLayoutInterface mOutsideGymLayoutInterface) {
        this.mOutsideGymLayoutInterface = mOutsideGymLayoutInterface;
    }

    public TableRow getmDynamicRow() {
        return mDynamicRow;
    }

    public void setmDynamicRow(TableRow mDynamicRow) {
        this.mDynamicRow = mDynamicRow;
    }

    private void bindViews() {
        mTopBar = (MainTopBar) findViewById(R.id.outside_gym_layout_main_top_bar);
        mBottomBar = (MainBottomBar) findViewById(R.id.outside_gym_layout_main_bottom_bar);
        mDynamicRow = (TableRow)findViewById(R.id.outside_gym_layout_dynamic_table_row);
        TrakerLog.d(TrakerLog.getCause()+" binded views.");
    }
    private void initViews() {
//        mTopBar.initiate(LoginManager.getLoggedinUser());
        mBottomBar.setMainBottomBarListener(new MainBottomBar.MainBottomBarInterface() {
            @Override
            public void onMenuButtonClicked() {
                // open bottom_bar_menu_button screen
                mOutsideGymLayoutInterface.openMenuScreen();
                Toast.makeText(OutsideGymLayout.super.getContext(), "pressed menu button.", Toast.LENGTH_SHORT).show();
                TrakerLog.d(TrakerLog.getCause()+" openMenuScreen()");
//                Intent i = new Intent(this, MenuScreenActivity.class);
            }

            @Override
            public void onHomeButtonClicked() {
                mOutsideGymLayoutInterface.goToHomeScreen();
                TrakerLog.d(TrakerLog.getCause()+" openHomeScreen()");
                // go to bottom_bar_home_button_chosen screen

            }

            @Override
            public void onProfileButtonClicked() {
                // go to personal bottom_bar_personal_profile_button screen
                mOutsideGymLayoutInterface.goToProfileScreen();
                TrakerLog.d(TrakerLog.getCause()+" openProfileScreen()");
            }

            @Override
            public void onWorkoutButtonClicked() {
                // go to bottom_bar_workout_button screen
                mOutsideGymLayoutInterface.goToWorkoutScreen();
                TrakerLog.d(TrakerLog.getCause()+" openWorkoutScreen()");
            }

            @Override
            public void onCalendarButtonClicked() {
                //go to calnedar screen
                mOutsideGymLayoutInterface.goToCalendarScreen();
                TrakerLog.d(TrakerLog.getCause()+" openCalendarScreen()");
            }
        });
        TrakerLog.d(TrakerLog.getCause()+" initiated views.");
    }
    void tweakLayout(){
        TableRow.LayoutParams rowLp = new TableRow.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);

    }


    public interface OutsideGymLayoutInterface  {
        void openMenuScreen();
        void goToHomeScreen();
        void goToProfileScreen();
        void goToWorkoutScreen();
        void goToCalendarScreen();
    }
}
