package com.traker.traker.beans.professionals;

import com.traker.traker.beans.enums.FitnessGoal;
import com.traker.traker.components.TrakerLinearLayout;
import com.traker.traker.util.loggers.TrakerLog;

/**
 * Created by idoengel on 8/30/17.
 */

public class PersonalTrainer implements ProfessionalStaffPerson {

    private String fullName;
    private int rating;
    private int experience;
    private String speciality;
    private FitnessGoal goalSpeciality;
    private boolean maleTrainer;
    private boolean femaleTrainer;
    private boolean trainerOfTheMonth;
    private String imageUri;

    public PersonalTrainer(){

    }

    public PersonalTrainer(String fullName, int rating, int experience, String speciality,
                           FitnessGoal goalSpeciality, boolean maleTrainer, boolean femaleTrainer,
                           boolean trainerOfTheMonth, String imageUri) {
        this.fullName = fullName;
        this.rating = rating;
        this.experience = experience;
        this.speciality = speciality;
        this.goalSpeciality = goalSpeciality;
        this.maleTrainer = maleTrainer;
        this.femaleTrainer = femaleTrainer;
        this.trainerOfTheMonth = trainerOfTheMonth;
        this.imageUri = imageUri;
        TrakerLog.d(TrakerLog.getCause()+this.toString());
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public FitnessGoal getGoalSpeciality() {
        return goalSpeciality;
    }

    public void setGoalSpeciality(FitnessGoal goalSpeciality) {
        this.goalSpeciality = goalSpeciality;
    }

    public boolean isMaleTrainer() {
        return maleTrainer;
    }

    public void setMaleTrainer(boolean maleTrainer) {
        this.maleTrainer = maleTrainer;
    }

    public boolean isFemaleTrainer() {
        return femaleTrainer;
    }

    public void setFemaleTrainer(boolean femaleTrainer) {
        this.femaleTrainer = femaleTrainer;
    }

    public boolean isTrainerOfTheMonth() {
        return trainerOfTheMonth;
    }

    public void setTrainerOfTheMonth(boolean trainerOfTheMonth) {
        this.trainerOfTheMonth = trainerOfTheMonth;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @Override
    public String toString() {
        return "PersonalTrainer{" +
                "fullName='" + fullName + '\'' +
                ", rating=" + rating +
                ", experience=" + experience +
                ", speciality='" + speciality + '\'' +
                ", goalSpeciality=" + goalSpeciality +
                ", maleTrainer=" + maleTrainer +
                ", femaleTrainer=" + femaleTrainer +
                ", trainerOfTheMonth=" + trainerOfTheMonth +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }
}