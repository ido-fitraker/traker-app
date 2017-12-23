package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.beans.business_objects.TrakerGymClass;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by idoroiengel on 12/14/17.
 */

public class TrakerGymClassLayout extends CustomTrakerLayout {

    // data
    private TrakerGymClass mClass;

    // UI
    private TextView mClassTime;
    private TextView mClassInstructor;
    private TextView mClassLocation;
    private TextView mClassSubscribers;
    private ImageButton mSignupToClassButton;
    private CircleImageView mClassInstructorImage;

    public TrakerGymClassLayout(Context context) {
        this(context, null);
    }

    public TrakerGymClassLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.traker_gym_class_layout, this, true);
        bindViews();
        initViews();
    }

    public TrakerGymClass getmClass() {
        return mClass;
    }

    public void setmClass(TrakerGymClass mClass) {
        this.mClass = mClass;
    }

    private void bindViews() {
        mClassTime = findViewById(R.id.traker_gym_class_layout_class_information_layout_time);
        mClassInstructor = findViewById(R.id.traker_gym_class_layout_class_information_layout_instructor);
        mClassLocation = findViewById(R.id.traker_gym_class_layout_class_information_layout_location);
        mClassSubscribers = findViewById(R.id.traker_gym_class_layout_class_information_layout_subscribers_number);
        mSignupToClassButton = findViewById(R.id.traker_gym_class_layout_signup_button);
        mClassInstructorImage = findViewById(R.id.traker_gym_class_layout_instructor_image);
    }
    private void initViews(){
//        injectData();
        animateClass();
    }

    private void injectData() {
        mClassTime.setText(String.valueOf(mClass.getClassTime()));
        mClassInstructor.setText(mClass.getClassInstructor().getName());
        mClassLocation.setText(mClass.getClassLocation());
        mClassSubscribers.setText(String.valueOf(mClass.getNumberOfPeople()));
        mClassInstructorImage.setImageURI(mClass.getClassInstructor().getImageUri());
    }

    private void animateClass() {
        mSignupToClassButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                signupToClass();
            }
        });
    }

    private void signupToClass() {
        Toast.makeText(getContext(), "wanna signup to class?", Toast.LENGTH_SHORT).show();
    }
}
