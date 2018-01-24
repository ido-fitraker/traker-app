package com.traker.traker.components.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TableRow;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;
import com.traker.traker.R;
import com.traker.traker.components.TrakerCalendarView;
import com.traker.traker.components.TrakerLinearLayout;
import com.traker.traker.utils.TrakerApplication;
import com.traker.traker.utils.TrakerLog;

import java.util.Calendar;

/**
 * Created by idoroiengel on 12/23/17.
 */

public class CalendarLayout extends Fragment {

    private static View mRootView;
    private TrakerCalendarView mCalendarLayout;
    private TrakerLinearLayout mNewTrainingSessionLayout;
    private TrakerLinearLayout mDieticianAppointmentLayout, mDietCounselorAppointmentLayout;

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
        mNewTrainingSessionLayout = mRootView.findViewById(R.id.calendar_layout_appointments_layout_personal_training_session_layout_new_training_session_layout);
        mDieticianAppointmentLayout = mRootView.findViewById(R.id.calendar_layout_appointments_layout_dietician_appointment_layout);
        mDietCounselorAppointmentLayout = mRootView.findViewById(R.id.calendar_layout_appointments_layout_fitness_consultant_appointment_layout);
        TrakerLog.d(TrakerLog.getCause() + " binded views.");
    }
    private void initViews() {
//        initCalendar();
        animateButtons();
        TrakerLog.d(TrakerLog.getCause() + " initiated views.");
    }

    private void animateButtons() {
        mNewTrainingSessionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initCalendar() {
        TrakerLog.d(TrakerLog.getCause() + " initiated calendar");
    }

    public static Fragment newInstance() {
        CalendarLayout layout = new CalendarLayout();
        TrakerLog.d(TrakerLog.getCause() + " created new instance.");
        return layout;
    }
}
