package com.traker.traker.components.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.traker.traker.R;

/**
 * Created by idoroiengel on 12/14/17.
 */

public class ClassExplorerLayout extends android.support.v4.app.Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.class_explorer_layout, container, false);
        return rootView;
    }

    public static ClassExplorerLayout newInstance() {
        ClassExplorerLayout layout = new ClassExplorerLayout();
        return layout;
    }
}
