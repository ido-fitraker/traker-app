package com.traker.traker.components;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.traker.traker.R;
import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoroiengel on 12/3/17.
 */

public class MenuLayout extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_layout, container, true);
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static MenuLayout newInstance(){
        MenuLayout layout = new MenuLayout();
        TrakerLog.d(TrakerLog.getCause()+" created new instance of MenuLayout.");
        return layout;
    }
}
