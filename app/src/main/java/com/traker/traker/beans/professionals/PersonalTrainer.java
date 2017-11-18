package com.traker.traker.beans.professionals;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import com.traker.traker.beans.enums.FitnessGoal;
import com.traker.traker.components.TrakerLinearLayout;
import com.traker.traker.util.loggers.TrakerLog;

import static android.R.attr.data;

/**
 * Created by idoengel on 8/30/17.
 */

public class PersonalTrainer implements ProfessionalStaffPerson, Parcelable {

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
        setUpPersonalTrainer(
                fullName,
                rating,
                experience,
                speciality,
                goalSpeciality,
                maleTrainer,
                femaleTrainer,
                trainerOfTheMonth,
                imageUri);
        TrakerLog.d(TrakerLog.getCause()+this.toString());
    }
    public PersonalTrainer(Parcel in){
        setUpPersonalTrainer(
                in.readString(),
                in.readInt(),
                in.readInt(),
                in.readString(),
                (FitnessGoal)in.readSerializable(),
                Boolean.valueOf(in.readString()),
                Boolean.valueOf(in.readString()),
                Boolean.valueOf(in.readString()),
                in.readString()
        );
    }

    private void setUpPersonalTrainer(String fullName, int rating, int experience, String speciality,
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fullName);
        parcel.writeInt(this.rating);
        parcel.writeInt(this.experience);
        parcel.writeString(this.speciality);
        parcel.writeSerializable(this.goalSpeciality);
        parcel.writeString(Boolean.valueOf(this.maleTrainer).toString());
        parcel.writeString(Boolean.valueOf(this.femaleTrainer).toString());
        parcel.writeString(Boolean.valueOf(this.trainerOfTheMonth).toString());
        parcel.writeString(this.imageUri);
        }

    public static final Creator<PersonalTrainer> CREATOR = new Creator<PersonalTrainer>() {
        @Override
        public PersonalTrainer createFromParcel(Parcel in) {
            return new PersonalTrainer(in);
        }

        @Override
        public PersonalTrainer[] newArray(int size) {
            return new PersonalTrainer[size];
        }
    };

}





