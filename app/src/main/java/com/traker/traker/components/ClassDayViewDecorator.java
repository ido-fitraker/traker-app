package com.traker.traker.components;

import android.graphics.drawable.ColorDrawable;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.traker.traker.managers.LoginManager;
import com.traker.traker.managers.server_manager.ServerManager;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by idoroiengel on 1/11/18.
 */

public class ClassDayViewDecorator implements DayViewDecorator {

    private static final String DECORATOR_COLOR = "0xFFC18BE4";
    private HashSet<CalendarDay> dates; // =ServerManager.getClassesDates()

    public ClassDayViewDecorator() {
        this.dates = new HashSet<>();
//        dates = LoginManager.getLoggedinUser().getClasses();
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        // if a class is scheduled in this day. take this information from the server.
//        return dates.contains(day);
        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(new ColorDrawable(0xFFC18BE4));

    }


}
