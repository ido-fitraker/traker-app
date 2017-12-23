package com.traker.traker.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by idoroiengel on 12/14/17.
 */

public class WorkoutFragmentOrganizer extends FragmentOrganizer {

    public WorkoutFragmentOrganizer(FragmentManager fragmentManager) {
        super(fragmentManager);
        TrakerLog.d(TrakerLog.getCause()+" initiated constructor.");
    }

    @Override
    protected Fragment getInitialFragment() {
        TrakerLog.d(TrakerLog.getCause()+" got initial fragment.");
        return null;
    }

    @Override
    protected void onEvent(Object event) {

    }

    @Override
    public boolean handleBackNavigation() {
        Fragment fragment = getOpenFragment();
//        if(fragment instanceof )
        return false;
    }

    @Override
    public void freeUpResources() {
        super.freeUpResources();
        TrakerLog.d(TrakerLog.getCause() + " freed-up resourcesd.");
    }
}
