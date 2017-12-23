package com.traker.traker.components.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.traker.traker.R;

/**
 * Created by idoroiengel on 12/23/17.
 */

public class CalendarLayout extends Fragment {

    private static View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.calendar_layout, container, false);
        return mRootView;
    }
}
