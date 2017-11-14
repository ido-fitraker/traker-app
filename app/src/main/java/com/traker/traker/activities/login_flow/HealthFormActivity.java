package com.traker.traker.activities.login_flow;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.components.HealthFormQuestionnaireLayout;
import com.traker.traker.components.TrakerButton;
import com.traker.traker.util.loggers.TrakerLog;

import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HealthFormActivity extends AppCompatActivity {

    private LinearLayout mBackButton;
    private TrakerButton mContinueButton;
    private HealthFormQuestionnaireLayout mQuestionnaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_form);
        bindViews();
        initViews();
        TrakerLog.d(TrakerLog.getCause()+" activated activity onCreate method.");
    }

    private void bindViews() {
        mBackButton = (LinearLayout)findViewById(R.id.health_form_linear_layout_back_screen);
        mContinueButton = (TrakerButton)findViewById(R.id.health_form_continue_button);
        mQuestionnaire =
                (HealthFormQuestionnaireLayout) findViewById(R.id.health_form_scroll_view_main_layout);
//        TextView backView = (TextView)findViewById(R.id)
        TrakerLog.d(TrakerLog.getCause()+" binded views.");
    }

    private void initViews(){
        assignBackButtonListener();
        assignContinueButtonListener();
        mQuestionnaire.setmHealthFormListener(
                new HealthFormQuestionnaireLayout.HealthFormQuestionnaireLayoutInterface() {
            @Override
            public void onPressed(TrakerButton button) {
                LinearLayout layout = (LinearLayout) button.getParent();
                changeButtonUI(button);
                appendBoolean(button, layout);
            }
        });
        TrakerLog.d(TrakerLog.getCause()+" initiated views.");
    }

    private void changeButtonUI(TrakerButton button) {
        ArrayList list = mQuestionnaire.getmHealthFormButtons();
        for(int i = 0; i < list.size(); i++){
            TrakerButton b = (TrakerButton) list.get(i);
            if((b.getParent().equals(button.getParent())) && (!b.equals(button))){
                b.setBackgroundResource(R.drawable.traker_button_border);
                b.setTextColor(Color.WHITE);
                button.setBackgroundColor(getResources().getColor(R.color.colorTraker));
                button.setTextColor(Color.BLACK);
            }
        }
        TrakerLog.d(TrakerLog.getCause()+" button UI changed for button "+ button);
    }

    private void appendBoolean(TrakerButton button, LinearLayout layout) {
        HashMap map = mQuestionnaire.getmSelectedButtons();
//        int buttonId = button.getParent();
//        ViewParent l = button.getParent();
        if(map.containsKey(layout.getId())){
            map.remove(layout);
        }
        else {
            if (button.getText().toString().contains(getResources().getString(R.string.yes_button))) {
                map.put(layout, false);
            } else if (button.getText().toString().contains(getResources().getString(R.string.no_button))) {
                map.put(layout, true);
            }
        }
        TrakerLog.d(TrakerLog.getCause()+" appended boolean to HashMap.");
    }

    private void assignBackButtonListener() {
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToPreviousScreen();
            }
        });
        TrakerLog.d(TrakerLog.getCause()+" assigned backButton listener.");
    }

    private void assignContinueButtonListener() {
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forwardToNextScreen();
            }
        });
        TrakerLog.d(TrakerLog.getCause()+" assigned continueButton listener.");
    }

    private void forwardToNextScreen() {
        if(healthFormIsValid()) {
            Intent i = new Intent(this, MyGoalsActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "עליך לענות על השאלון.", Toast.LENGTH_SHORT).show();
        }
        TrakerLog.d(TrakerLog.getCause()+" forward to next screen method.");
    }

    private boolean healthFormIsValid() {
        HashMap map = mQuestionnaire.getmSelectedButtons();
        // seek a better condition for this command. the map's size can presumably be reached
        // programmatically. perhaps with an XmlResourceParser object.
        if((map.size() == 9) && !map.containsValue(Boolean.FALSE)) {
            TrakerLog.d(TrakerLog.getCause()+" health form is valid.");
            return true;
        }
        else {
            TrakerLog.d(TrakerLog.getCause()+" health form is invalid.");
            return false;
        }
    }

    private void returnToPreviousScreen(){
        Intent i = new Intent(this, PersonalDetailsActivity.class);
        startActivity(i);
        finish();
        TrakerLog.d(TrakerLog.getCause()+" returning to previous screen.");
    }

}
