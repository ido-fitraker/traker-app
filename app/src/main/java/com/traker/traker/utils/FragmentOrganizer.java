package com.traker.traker.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.traker.traker.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by idoroiengel on 12/2/17.
 */
public abstract class FragmentOrganizer {
    protected FragmentManager fragmentManager;

    public FragmentOrganizer(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        openFragment(getInitialFragment());
        EventBus.getDefault().register(this);
        TrakerLog.d(TrakerLog.getCause()+" initiated FragmentOrganizer object.");
    }

    protected abstract Fragment getInitialFragment();
    protected abstract void onEvent(Object event);
    public abstract boolean handleBackNavigation();

    @Subscribe
    public void freeUpResources(){
        EventBus.getDefault().unregister(this);
        TrakerLog.d(TrakerLog.getCause()+" freed-up resources.");
    }


    protected Fragment getOpenFragment(){
        String tag = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() -1).getName();
        TrakerLog.d(TrakerLog.getCause()+" got open fragment.");
        return fragmentManager.findFragmentByTag(tag);
    }


    protected boolean isFragmentOpen(Fragment fragment){
        TrakerLog.d(TrakerLog.getCause()+" checked if fragment is open.");
        return isFragmentOpen(fragment, true);
    }

    protected boolean isFragmentOpen(Fragment fragment, boolean useArgs){
        String fragmentTag = createFragmentTag(fragment, useArgs);

        if (fragmentManager.getBackStackEntryCount() != 0) {
            String name = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();

            if(!useArgs)
                name = name.substring(0, name.indexOf("-"));

            return name.equals(fragmentTag);
        }

        return false;
    }


    private String createFragmentTag(Fragment fragment, boolean addArgs) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fragment.getClass().getSimpleName());
        if(addArgs) {
            stringBuilder.append("-");
            if (fragment.getArguments() != null)
                stringBuilder.append(fragment.getArguments().toString());
        }
        TrakerLog.d(TrakerLog.getCause()+" created fragment from tag.");
        return stringBuilder.toString();
    }

    public void openFragment(Fragment fragment) {
        if(isFragmentOpen(fragment))
            return;

        String fragmentTag = createFragmentTag(fragment, true);
        if(fragmentTag == null){
            TrakerLog.d(TrakerLog.getCause()+" fragment tag is null, ergo fragment is null.");
        }else{
            TrakerLog.d(TrakerLog.getCause()+" this is fragment:"+fragmentTag);
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.outside_gym_layout_dynamic_table_row, fragment, fragmentTag);
        transaction.addToBackStack(fragmentTag).commit();
        TrakerLog.d(TrakerLog.getCause()+" opened fragment.");
    }


}
