package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.components.fragments.NewsfeedLayout;
import com.traker.traker.components.fragments.PersonalProfileLayout;
import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoroiengel on 11/25/17.
 */

public class OutsideGymLayout extends TableLayout {

    private MainTopBar mTopBar;
    private MainBottomBar mBottomBar;
    private TableRow mDynamicRow;
    private OutsideGymLayoutInterface mOutsideGymLayoutInterface;

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

    public TableRow getmDynamicRow() {
        return mDynamicRow;
    }

    public void setmDynamicRow(TableRow mDynamicRow) {
        this.mDynamicRow = mDynamicRow;
    }

    public OutsideGymLayoutInterface getmOutsideGymLayoutInterface() {
        return mOutsideGymLayoutInterface;
    }

    public void setmOutsideGymLayoutInterface(OutsideGymLayoutInterface mOutsideGymLayoutInterface) {
        this.mOutsideGymLayoutInterface = mOutsideGymLayoutInterface;
    }

    private void bindViews() {
        mTopBar = findViewById(R.id.outside_gym_layout_main_top_bar);
        mBottomBar = findViewById(R.id.outside_gym_layout_main_bottom_bar);
        mDynamicRow =findViewById(R.id.outside_gym_layout_dynamic_table_row);
        TrakerLog.d(TrakerLog.getCause()+" binded views.");
    }
    private void initViews() {
        implementBottomBarListeners();
        implementTopBarListeners();
        TrakerLog.d(TrakerLog.getCause()+" initiated views.");
    }

    private void implementTopBarListeners() {
        mTopBar.setmMainTopBarInterface(new MainTopBar.MainTopBarInterface() {
            @Override
            public void onNotificationClicked() {
                Toast.makeText(OutsideGymLayout.super.getContext(), "notifications pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void implementBottomBarListeners() {
        mBottomBar.setMainBottomBarListener(new MainBottomBar.MainBottomBarInterface() {
            @Override
            public void onMenuButtonClicked() {
                Toast.makeText(OutsideGymLayout.super.getContext(), "menu fragment", Toast.LENGTH_SHORT).show();
                MenuLayout.newInstance();
                TrakerLog.d(TrakerLog.getCause()+" new instance of MenuLayout");
            }

            @Override
            public void onHomeButtonClicked() {
                Fragment fragment = NewsfeedLayout.newInstance();
                mOutsideGymLayoutInterface.openNewsfeedScreen(fragment);
                Toast.makeText(OutsideGymLayout.super.getContext(), "newsfeed fragment", Toast.LENGTH_SHORT).show();
                TrakerLog.d(TrakerLog.getCause()+" new instance of NewsfeedLAyout");
            }

            @Override
            public void onProfileButtonClicked() {
                Fragment fragment = PersonalProfileLayout.newInstance();
                mOutsideGymLayoutInterface.openPersonalProfileScreen(fragment);
                Toast.makeText(OutsideGymLayout.super.getContext(), "profile fragment", Toast.LENGTH_SHORT).show();
                TrakerLog.d(TrakerLog.getCause()+" new instance of PersonalProfileLayout");
            }

            @Override
            public void onWorkoutButtonClicked() {
                Toast.makeText(OutsideGymLayout.super.getContext(), "workout fragment", Toast.LENGTH_SHORT).show();

//                WorkoutLayout.newInstance();
//                mOutsideGymLayoutInterface.goToWorkoutScreen();
                TrakerLog.d(TrakerLog.getCause()+" new instance of WorkoutLayout");
            }

            @Override
            public void onCalendarButtonClicked() {
                Toast.makeText(OutsideGymLayout.super.getContext(), "calendar fragment", Toast.LENGTH_SHORT).show();

//                CalendarLayout.newInstance();
//                mOutsideGymLayoutInterface.goToCalendarScreen();
                TrakerLog.d(TrakerLog.getCause()+" new instance of CalendarLayout");
            }
        });
    }
    public interface OutsideGymLayoutInterface {
        void openPersonalProfileScreen(Fragment fragment);
        void openNewsfeedScreen(Fragment fragment);
    }
}
