package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.traker.traker.R;
import com.traker.traker.util.loggers.TrakerLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by idoengel on 10/29/17.
 */

public class HealthFormQuestionnaireLayout extends LinearLayout {

    private static final int[] BUTTON_IDS = new int[]{
            R.id.health_form_scroll_view_first_question_layout_buttons_layoutButtonNO,
            R.id.health_form_scroll_view_first_question_layout_buttons_layoutButtonYES,
            R.id.health_form_scroll_view_second_question_layout_buttons_layoutRestOptionButtonNO,
            R.id.health_form_scroll_view_second_question_layout_buttons_layoutRestOptionButtonYES,
            R.id.health_form_scroll_view_second_question_layout_buttons_layoutDailyOptionButtonNO,
            R.id.health_form_scroll_view_second_question_layout_buttons_layoutDailyOptionButtonYES,
            R.id.health_form_scroll_view_second_question_layout_buttons_layoutExerciseOptionButtonNO,
            R.id.health_form_scroll_view_second_question_layout_buttons_layoutExerciseOptionButtonYES,
            R.id.health_form_scroll_view_third_question_layout_buttons_layoutButtonNO,
            R.id.health_form_scroll_view_third_question_layout_buttons_layoutButtonYES,
            R.id.health_form_scroll_view_fourth_question_layout_buttons_layoutHeartDiseaseOptionButtonNO,
            R.id.health_form_scroll_view_fourth_question_layout_buttons_layoutHeartDiseaseOptionButtonYES,
            R.id.health_form_scroll_view_fourth_question_layout_buttons_layoutSuddenDeathOptionButtonNO,
            R.id.health_form_scroll_view_fourth_question_layout_buttons_layoutSuddenDeathOptionButtonYES,
            R.id.health_form_scroll_view_fifth_question_layout_buttons_layoutButtonNO,
            R.id.health_form_scroll_view_fifth_question_layout_buttons_layoutButtonYES,
            R.id.health_form_scroll_view_sixth_question_layout_buttons_layoutButtonNO,
            R.id.health_form_scroll_view_sixth_question_layout_buttons_layoutButtonYES
    };
    private ArrayList<TrakerButton> mHealthFormButtons;
    private HealthFormQuestionnaireLayoutInterface mHealthFormListener;
    private HashMap<Integer, Boolean> mSelectedButtons;

    public HealthFormQuestionnaireLayout(Context context) {
        this(context, null);
        TrakerLog.d(TrakerLog.getCause()+" activated context-only constructor.");
    }

    public HealthFormQuestionnaireLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater
                .from(context)
                .inflate(R.layout.health_form_questionnaire_layout,
                this,
                true);
        initializeHealthForm(BUTTON_IDS);
        TrakerLog.d(TrakerLog.getCause()+" activated contet+attributes constructor.");
    }

    public void setmHealthFormListener(HealthFormQuestionnaireLayoutInterface mHealthFormListener) {
        this.mHealthFormListener = mHealthFormListener;
        mSelectedButtons = new HashMap<>();
        TrakerLog.d(TrakerLog.getCause()+" activated setter for mHealthFormListener.");
    }

    public HashMap<Integer, Boolean> getmSelectedButtons() {
        TrakerLog.i(TrakerLog.getCause() + mSelectedButtons);
        return mSelectedButtons;
    }

    public ArrayList<TrakerButton> getmHealthFormButtons() {
        return mHealthFormButtons;
    }

    private void initializeHealthForm(int[] buttons) {
        mHealthFormButtons = new ArrayList<TrakerButton>();
        for(int id : buttons){
            final TrakerButton button = findViewById(id);
            // fixing buttons' size to Sympli measurements.
//            button.setWidth(49);
//            button.setHeight(32);
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    TrakerLog.d(TrakerLog.getCause() +" parent is: " + view.getParent());
                    buttonClicked(button);
                    TrakerLog.d(TrakerLog.getCause()+" buttonClicked method activated.");
                }
            });
            mHealthFormButtons.add(button);
        }
        TrakerLog.d(TrakerLog.getCause()+" health form initialized.");
    }



    private void buttonClicked(TrakerButton button) {
        mHealthFormListener.onPressed(button);
        TrakerLog.d(TrakerLog.getCause()+" onPressed method activated.");
    }

    public interface HealthFormQuestionnaireLayoutInterface{
        void onPressed(TrakerButton button);
    }
}
