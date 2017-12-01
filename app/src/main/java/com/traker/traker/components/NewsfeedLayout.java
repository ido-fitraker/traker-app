package com.traker.traker.components;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.traker.traker.R;

/**
 * Created by idoroiengel on 11/26/17.
 */

public class NewsfeedLayout extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.newsfeed_layout, container, false);
    }
}

