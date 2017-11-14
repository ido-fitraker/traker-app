package com.traker.traker.beans;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by idoengel on 7/29/17.
 * this class demonstrate a sample user for checking UI of activity screen in the app.
 */

public class SampleTrainee {
    private double bmi;
    private int weight;
    private double height;
    BigDecimal bd;
    DecimalFormat format;
    Challenge [] myChallenges;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public BigDecimal getBd() {
        return bd;
    }

    public void setBd(BigDecimal bd) {
        this.bd = bd;
    }

    public DecimalFormat getFormat() {
        return format;
    }

    public void setFormat(DecimalFormat format) {
        this.format = format;
    }

    public Challenge[] getMyChallenges() {
        return myChallenges;
    }

    public void setMyChallenges(Challenge[] myChallenges) {
        this.myChallenges = myChallenges;
    }

    public void sampleMethod(){
        format = new DecimalFormat();
    }

}
