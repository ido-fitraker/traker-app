package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.traker.traker.R;
import com.traker.traker.beans.professionals.PersonalTrainer;
import com.traker.traker.util.loggers.TrakerLog;

/**
 * Created by idoroiengel on 11/14/17.
 */

public class VerticalTrakerPersonalTrainerLayout extends CustomTrakerLayout {

    // UI
    private ImageView trainerImage;
    private TextView trainerName;
    private TextView trainerExperience;
    private LinearLayout trainerRating;
    private TrakerLinearLayout trainerGoalSpeciality;
    private TrakerLinearLayout trainerExpertise;
    private TrakerLinearLayout trainerMaleFemaleTraining;

    // data
    private PersonalTrainer trainer;

    public VerticalTrakerPersonalTrainerLayout(Context context) {
        this(context, null);
        TrakerLog.d(TrakerLog.getCause()+" activated only-context constructor.");
    }

    public VerticalTrakerPersonalTrainerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.vertical_traker_personal_trainer_layout, this, true);
        bindViews();
        initViews();
        TrakerLog.d(TrakerLog.getCause()+" activated context+attributes constructor.");
    }
    public PersonalTrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(PersonalTrainer trainer) {
        this.trainer = trainer;
        dumpTrainerDetails(trainer);
        TrakerLog.d(TrakerLog.getCause()+" activated setTrainer.");
    }
    private void bindViews() {
        trainerImage = findViewById(R.id.vertical_traker_personal_trainer_layout_trainer_image);
        trainerName = findViewById(R.id.vertical_traker_personal_trainer_layout_trainer_name);
        trainerExperience = findViewById(R.id.vertical_traker_personal_trainer_layout_trainer_practical_experience);
        trainerRating = findViewById(R.id.vertical_traker_personal_trainer_layout_trainer_rating_layout);
        trainerGoalSpeciality = findViewById(R.id.vertical_traker_personal_trainer_layout_trainer_goal_speciality_layout);
        trainerExpertise = findViewById(R.id.vertical_traker_personal_trainer_layout_trainer_expertise_layout);
        trainerMaleFemaleTraining = findViewById(R.id.vertical_traker_personal_trainer_layout_male_female_trainer_layout);
        TrakerLog.d(TrakerLog.getCause()+" binded views.");
    }
    private void initViews() {
        initRating();
        TrakerLog.d(TrakerLog.getCause()+" initiated views.");
    }

    private void initRating() {
        for(int i = 0; i < trainerRating.getChildCount(); i++){
            trainerRating.getChildAt(i).setBackgroundResource(R.drawable.personal_trainer_star_rating_off);
        }
        TrakerLog.d(TrakerLog.getCause()+" rating intiated.");
    }
    private void dumpTrainerDetails(PersonalTrainer trainer){
        applyPersonalDetailsToTrainer();
        applyRatingToTrainer(trainer.getRating());
        applyGoalSpecialityToTrainer();
        applyExpertiseToTrainer();
        applyMaleFemaleTrainingToTrainer();
        applyExperienceToTrainer();
        TrakerLog.d(TrakerLog.getCause()+" dumped trainer details.");
    }
    private void applyPersonalDetailsToTrainer(){
        trainerImage.setBackgroundResource(Integer.valueOf(trainer.getImageUri()));
        trainerName.setText(trainer.getFullName());
        TrakerLog.d(TrakerLog.getCause()+" applied personal details to trainer.");
    }

    private void applyExperienceToTrainer() {
        trainerExperience.setText(trainer.getExperience()
                + " "
                + getResources().getString(R.string.trainer_choosing_auto_completion_for_trainer_experience)
        );
        TrakerLog.d(TrakerLog.getCause()+"applied experience to trainer.");
    }

    private void applyMaleFemaleTrainingToTrainer() {
        for(int i = 0; i < trainerMaleFemaleTraining.getChildCount(); i++){
            View currentView = trainerMaleFemaleTraining.getChildAt(i);
            if(currentView instanceof TextView){
                ((TextView) currentView).setText(
                        String.valueOf("male:" + trainer.isMaleTrainer())+
                        String.valueOf("female: " + trainer.isFemaleTrainer()));
            }

        }
        TrakerLog.d(TrakerLog.getCause()+" applied female-male training to trainer.");
    }

    private void applyExpertiseToTrainer() {
        for(int i = 0; i < trainerExpertise.getChildCount(); i++){
            View currentView = trainerExpertise.getChildAt(i);
            if(currentView instanceof TextView){
                ((TextView) currentView).setText(trainer.getSpeciality());
            }
        }
        TrakerLog.d(TrakerLog.getCause()+" applied expertise to trainer.");
    }

    private void applyGoalSpecialityToTrainer() {
        for(int i = 0; i < trainerGoalSpeciality.getChildCount(); i++){
                View currentView = trainerGoalSpeciality.getChildAt(i);
            if(currentView instanceof TextView){
                ((TextView) currentView).setText(trainer.getGoalSpeciality().getName());
            }else{
                currentView.setBackgroundResource(trainer.getGoalSpeciality().getImageUri());
            }
        }
        TrakerLog.d(TrakerLog.getCause()+" applied goalSpeciality to trainer.");
    }

    private void applyRatingToTrainer(int rating) {
        for(int i = 0; i < rating; i++){
            trainerRating.getChildAt(i).setBackgroundResource(R.drawable.personal_trainer_star_rating_on);

        }
        TrakerLog.d(TrakerLog.getCause()+" applied rating to trainer.");
    }

}
