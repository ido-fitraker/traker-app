package com.traker.traker.utils;


import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.traker.traker.components.ClassDayViewDecorator;
import com.traker.traker.components.CoinDayViewDecorator;

/**
 * Created by idoroiengel on 1/11/18.
 */

public class EventDecorator{

    private ClassDayViewDecorator classDecorator;
    private CoinDayViewDecorator coinDecorator;
//    private DayViewDecorator dayViewDecorator;

    public EventDecorator() {
        classDecorator = new ClassDayViewDecorator();
        coinDecorator = new CoinDayViewDecorator();
    }

    public ClassDayViewDecorator getClassDecorator() {
        return classDecorator;
    }

    public CoinDayViewDecorator getCoinDecorator() {
        return coinDecorator;
    }

    public void setClassDecorator(ClassDayViewDecorator classDecorator) {
        this.classDecorator = classDecorator;
    }

    public void setCoinDecorator(CoinDayViewDecorator coinDecorator) {
        this.coinDecorator = coinDecorator;
    }
}
