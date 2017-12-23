package com.traker.traker.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.traker.traker.beans.models.NewsfeedPostModel;
import com.traker.traker.components.MainTopBar;
import com.traker.traker.components.PersonalProfileGoalLayout;
import com.traker.traker.components.fragments.NewsfeedLayout;
import com.traker.traker.components.OutsideGymLayout;
import com.traker.traker.components.fragments.PersonalProfileLayout;
import com.traker.traker.components.fragments.WorkoutLayout;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by idoroiengel on 12/2/17.
 */

public class MainFragmentOrganizer extends FragmentOrganizer {

    public MainFragmentOrganizer(FragmentManager fragmentManager){
        super(fragmentManager);
        TrakerLog.d(TrakerLog.getCause()+" initiated constructor.");
    }

    @Override
    protected Fragment getInitialFragment() {
        TrakerLog.d(TrakerLog.getCause()+" got initial fragment.");
        return WorkoutLayout.newInstance();
    }

    @Subscribe
    @Override
    public void onEvent(Object event) {
        if(event instanceof OutsideGymLayout){

            TrakerLog.d(TrakerLog.getCause()+" onEvent of OutsideGymLayout in MainFragmentOrganizer.");
//            openFragment();
        }
        if(event instanceof MainTopBar.MainTopBarInterface){
            TrakerLog.d(TrakerLog.getCause()+" onEvent of MainTopBar in MainFragmentOrganizer.");
        }

    }
    @Subscribe
    @Override
    public void freeUpResources() {
        super.freeUpResources();
        TrakerLog.d(TrakerLog.getCause() + " freed-up resourcesd.");
    }

    @Override
    public boolean handleBackNavigation() {
        Fragment fragment = getOpenFragment();
        if(fragment instanceof NewsfeedLayout){
            TrakerLog.d(TrakerLog.getCause()+" handled back navigation, instanceof NewsfeedLayout.");
            return false;
        }else{
            fragmentManager.popBackStack();
            TrakerLog.d(TrakerLog.getCause()+" handled back navigation, NOT instanceof NewsfeedLayout.");
            return true;
        }
    }
}
