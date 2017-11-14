package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.traker.traker.R;
import com.traker.traker.beans.professionals.PersonalTrainer;
import com.traker.traker.util.loggers.TrakerLog;

import java.util.ArrayList;

/**
 * Created by idoroiengel on 11/12/17.
 */

public class TrakerPersonalTrainerLayout extends CustomTrakerLayout {

    // UI
    private ImageView trainerImage;
    private TextView trainerName;
    private TextView trainerExperience;
    private LinearLayout trainerRating;
    private ImageButton trainerChoosingButton;

    // data
    private static PersonalTrainer trainer = new PersonalTrainer();

    public TrakerPersonalTrainerLayout(Context context) {
        this(context, null);
    }


    public TrakerPersonalTrainerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.traker_personal_trainer_layout, this, true);
        bindViews();
        initViews();
        dumpTrainerDetails(trainer);

    }

    public PersonalTrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(PersonalTrainer trainer) {
        this.trainer = trainer;
    }

    private void bindViews(){
        trainerImage = findViewById(R.id.traker_personal_trainer_layour_trainer_image);
        trainerName = findViewById(R.id.traker_personal_trainer_layour_trainer_name);
        trainerExperience = findViewById(R.id.traker_personal_trainer_layour_trainer_experience);
        trainerRating = findViewById(R.id.traker_personal_trainer_layour_trainer_rating_layout);
        trainerChoosingButton = findViewById(R.id.traker_personal_trainer_layour_trainer_choose_button);

    }
    private void initViews() {
        trainerChoosingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseTrainer();
            }
        });
        initRating();
    }

    private void initRating() {
        for(int i = 0; i < trainerRating.getChildCount(); i++){
            trainerRating.getChildAt(i).setBackgroundResource(R.drawable.personal_trainer_star_rating_off);
        }
    }

    private void dumpTrainerDetails(PersonalTrainer trainer){
//            trainerImage.setBackgroundResource(Integer.valueOf(trainer.getImageUri()));
            trainerName.setText(trainer.getFullName());
            trainerExperience.setText(trainer.getExperience()
                    + " "
                    + getResources().getString(R.string.trainer_choosing_auto_completion_for_trainer_experience)
                    +" "
                    + trainer.getSpeciality());
            applyRatingToTrainer(trainer.getRating());
    }

    private void applyRatingToTrainer(int rating) {
        for(int j = 0; j < rating; j++){
            trainerRating.getChildAt(rating).setBackgroundResource(R.drawable.personal_trainer_star_rating_on);

        }
    }

    private void chooseTrainer() {
        // TODO implement this method.
    }
}
