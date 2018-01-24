package com.traker.traker.components;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;
import com.traker.traker.managers.LoginManager;
import com.traker.traker.managers.server_manager.ServerManager;
import com.traker.traker.utils.TrakerApplication;
import com.traker.traker.utils.TrakerLog;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by idoroiengel on 1/11/18.
 */

public class ClassDayViewDecorator implements DayViewDecorator {

    private static final String DECORATOR_COLOR = "0xFFC18BE4";
    private HashSet<CalendarDay> dates; // =ServerManager.getClassesDates()

    public ClassDayViewDecorator() {
        this.dates = new HashSet<>();
//        dates = LoginManager.getLoggedinUser().getClasses();
        TrakerLog.d(TrakerLog.getCause() +" initiated ClassDayViewDecorator." );
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        // if a class is scheduled in this day. take this information from the server.
//        return dates.contains(day);
//        TrakerLog.d(TrakerLog.getCause() + " checked shouldDecorate.");
        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(new ColorDrawable(0xFFC18BE4));
        TrakerLog.d(TrakerLog.getCause() + " activated decoration.");
    }


}
