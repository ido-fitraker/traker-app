package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CalendarView;

import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.traker.traker.R;
import com.traker.traker.utils.EventDecorator;
import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoroiengel on 12/23/17.
 */

public class TrakerCalendarView extends MaterialCalendarView {

    private EventDecorator eventDecorator;

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
        eventDecorator = new EventDecorator();
        initDecorators();

    }

    public void initDecorators(){
        addDecorator(eventDecorator.getClassDecorator());
        addDecorator(eventDecorator.getCoinDecorator());
    }
}
