package com.traker.traker.components;

import android.content.Context;
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
    private PersonalTrainer trainer;

    private TrakerPersonalTrainerLayoutInterface trakerPersonalTrainerLayoutInterface;

    public TrakerPersonalTrainerLayout(Context context) {
        this(context, null);
    }

    public TrakerPersonalTrainerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.traker_personal_trainer_layout, this, true);
//        LayoutInflater.from(context).inflate(getmLayoutOrientation().getId(), this, true);
        bindViews();
        initViews();
    }
//    public TrakerPersonalTrainerLayout(){
//        LayoutInflater.from(getContext()).inflate(getmLayoutOrientation().getId(), this, true);
//    }


    public PersonalTrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(PersonalTrainer trainer) {
        this.trainer = trainer;
        dumpTrainerDetails(trainer);
    }

    public void setTrakerPersonalTrainerLayoutInterface(TrakerPersonalTrainerLayoutInterface
                                                                trakerPersonalTrainerLayoutInterface) {
        this.trakerPersonalTrainerLayoutInterface = trakerPersonalTrainerLayoutInterface;
    }

    private void bindViews(){
        trainerImage = findViewById(R.id.traker_personal_trainer_layout_trainer_image);
        trainerName = findViewById(R.id.traker_personal_trainer_layout_trainer_name);
        trainerExperience = findViewById(R.id.traker_personal_trainer_layout_trainer_practical_experience);
        trainerRating = findViewById(R.id.traker_personal_trainer_layout_trainer_rating_layout);
        trainerChoosingButton = findViewById(R.id.traker_personal_trainer_layout_trainer_choose_button);

    }
    private void initViews() {
        setTrakerPersonalTrainerLayoutInterface(trakerPersonalTrainerLayoutInterface);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                trakerPersonalTrainerLayoutInterface.onChooseTrainer(trainer);
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
            trainerImage.setBackgroundResource(Integer.valueOf(trainer.getImageUri()));
            trainerName.setText(trainer.getFullName());
            trainerExperience.setText(trainer.getExperience()
                    + " "
                    + getResources().getString(R.string.trainer_choosing_auto_completion_for_trainer_experience)
                    + ", "
                    + trainer.getSpeciality());
            applyRatingToTrainer(trainer.getRating());
    }

    private void applyRatingToTrainer(int rating) {
        for(int i = 0; i < rating; i++){
            trainerRating.getChildAt(i).setBackgroundResource(R.drawable.personal_trainer_star_rating_on);

        }
    }

    public interface TrakerPersonalTrainerLayoutInterface{
        void onChooseTrainer(PersonalTrainer personalTrainer);
    }
//    public enum LayoutOrientation {
//        VERTICAL(R.layout.vertical_traker_personal_trainer_layout),
//        HORIZONTAL(R.layout.traker_personal_trainer_layout);
//
//        private final int id;
//
//        LayoutOrientation(int id){
//            this.id = id;
//        }
//        public int getId(){
//            return id;
//        }
//    };
}
