package com.traker.traker.components.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TableRow;

import com.prolificinteractive.materialcalendarview.spans.DotSpan;
import com.traker.traker.R;
import com.traker.traker.components.TrakerCalendarView;
import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoroiengel on 12/23/17.
 */

public class CalendarLayout extends Fragment {

    private static View mRootView;
    private TrakerCalendarView mCalendarLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.calendar_layout, container, false);
        bindViews();
        initViews();
        TrakerLog.d(TrakerLog.getCause() + " onCreateView for CalendarLayout.");
        return mRootView;
    }

    private void bindViews() {
        mCalendarLayout = mRootView.findViewById(R.id.calendar_layout_calendar_layout_traker_calendar_view);
        TrakerLog.d(TrakerLog.getCause() + " binded views.");
    }
    private void initViews() {
        TrakerLog.d(TrakerLog.getCause() + " initiated views.");
    }

    public static Fragment newInstance() {
        CalendarLayout layout = new CalendarLayout();
        TrakerLog.d(TrakerLog.getCause() + " created new instance.");
        return layout;
    }
}
