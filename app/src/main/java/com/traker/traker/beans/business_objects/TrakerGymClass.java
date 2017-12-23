package com.traker.traker.beans.business_objects;

import com.traker.traker.R;
import com.traker.traker.beans.enums.TrakerClassEnum;
import com.traker.traker.beans.professionals.TrakerInstructor;

import java.util.Date;

/**
 * Created by idoroiengel on 12/13/17.
 */
public class TrakerGymClass {

    private TrakerInstructor classInstructor;
    private int numberOfPeople;
    private String classLocation;
    private Date classDate;
    private long classTime;
    private TrakerClassEnum classCategory;

    public TrakerInstructor getClassInstructor() {
        return classInstructor;
    }

    public void setClassInstructor(TrakerInstructor classInstructor) {
        this.classInstructor = classInstructor;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    public Date getClassDate() {
        return classDate;
    }

    public void setClassDate(Date classDate) {
        this.classDate = classDate;
    }

    public long getClassTime() {
        return classTime;
    }

    public void setClassTime(long classTime) {
        this.classTime = classTime;
    }

    public TrakerClassEnum getClassCategory() {
        return classCategory;
    }

    public void setClassCategory(TrakerClassEnum classCategory) {
        this.classCategory = classCategory;
    }
}

