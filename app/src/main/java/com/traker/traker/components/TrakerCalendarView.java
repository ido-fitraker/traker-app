package com.traker.traker.components;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import com.traker.traker.R;
import com.traker.traker.utils.EventDecorator;
import com.traker.traker.utils.TrakerApplication;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by idoroiengel on 12/23/17.
 */

public class TrakerCalendarView extends MaterialCalendarView {

    private EventDecorator eventDecorator;
    private char[] mWeekdaysLabels;

    public TrakerCalendarView(@NonNull Context context) {
        this(context, null);
        TrakerLog.d(TrakerLog.getCause() + " activated context-only constructor.");
    }

    public TrakerCalendarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.traker_calendar_view_layout, this, true);
        initCalendar();
        TrakerLog.d(TrakerLog.getCause() + " activated context+attributes constructor.");
    }

    private void initCalendar() {
        adjustCalendar();
        eventDecorator = new EventDecorator();
        initDecorators();
        TrakerLog.d(TrakerLog.getCause() + " initiated calendar.");
    }

    private void adjustCalendar() {
        adjustStateParams();
        adjustParams();
        TrakerLog.d(TrakerLog.getCause() + " adjusted calendar.");
    }

    private void adjustStateParams() {
        state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                // an experimental feature of mcv.
                .setCalendarDisplayMode(CalendarMode.WEEKS)
                .commit();
        TrakerLog.d(TrakerLog.getCause() + " adjusted state params.");
    }

    private void adjustParams() {
        setSelectionColor(getResources().getColor(R.color.colorTraker));
        setWeekDayTextAppearance(R.style.CalendarViewCustomWeekLabel);
        setWeekDayLabels(R.array.week_days_array);
        setHeaderTextAppearance(R.style.CalendarViewCustomWeekLabel);
        TrakerLog.d(TrakerLog.getCause() + " adjusted params.");
    }

    public void initDecorators(){
        addDecorator(eventDecorator.getClassDecorator());
        addDecorator(eventDecorator.getCoinDecorator());
        TrakerLog.d(TrakerLog.getCause() + " initiated decorators.");
    }
}
