package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.CalendarView;

/**
 * Created by idoroiengel on 12/23/17.
 */

public class TrakerCalendarView extends CalendarView {
    public TrakerCalendarView(@NonNull Context context) {
        super(context);
    }

    public TrakerCalendarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
