package com.traker.traker.components;

import android.graphics.drawable.Drawable;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.traker.traker.R;
import com.traker.traker.managers.LoginManager;
import com.traker.traker.utils.TrakerApplication;

import java.util.HashSet;

/**
 * Created by idoroiengel on 1/11/18.
 */

public class CoinDayViewDecorator implements DayViewDecorator {

    private static final int COIN_IMAGE = R.drawable.top_bar_coin_image;
    private Drawable coinDrawable;
    private HashSet<CalendarDay> dates;

    public CoinDayViewDecorator() {
        coinDrawable = TrakerApplication.getContext().getResources().getDrawable(COIN_IMAGE);
        dates = new HashSet<>();
//        dates = LoginManager.getLoggedinUser().getChallengesCompleted();
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
//        return dates.contains(day);
        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(coinDrawable);
    }
}
