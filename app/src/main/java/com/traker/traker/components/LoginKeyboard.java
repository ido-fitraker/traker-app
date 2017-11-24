package com.traker.traker.components;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;

import com.traker.traker.R;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;


/**
 * Created by idoengel on 10/11/17.
 */

public class LoginKeyboard extends TableLayout {

    private static final int[] BUTTON_IDS = new int[]{
            R.id.codeButtonOne,
            R.id.codeButtonTwo,
            R.id.codeButtonThree,
            R.id.codeButtonFour,
            R.id.codeButtonFive,
            R.id.codeButtonSix,
            R.id.codeButtonSeven,
            R.id.codeButtonEight,
            R.id.codeButtonNine,
            R.id.codeVerificationNextButton,
            R.id.codeButtonZero,
            R.id.codeArrowBackButton
    };
    private LoginKeyboardInterface mLoginKeyboardListener;
    private ArrayList<TrakerButton> mButtons;

    public LoginKeyboard(Context context) {
        this(context, null);
        TrakerLog.i(TrakerLog.getCause()+" activated only-context constructor");
    }
    public LoginKeyboard(Context context, AttributeSet attr){
        super(context, attr);
        LayoutInflater.from(context).inflate(R.layout.login_keyboard_layout, this, true);
        populateKeyboard(BUTTON_IDS);
        TrakerLog.i(TrakerLog.getCause()+" activated context+attributes constructor");
    }
    public void setmLoginKeyboardListener(LoginKeyboardInterface mLoginKeyboardListener) {
        this.mLoginKeyboardListener = mLoginKeyboardListener;
        TrakerLog.i(TrakerLog.getCause()+ " activated setmLoginKeyboardListener");
    }

    // InitUI method
    protected void populateKeyboard(int[] keyboard){
        mButtons = new ArrayList();
        for(int id : keyboard){
            final TrakerButton button = findViewById(id);
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    TrakerLog.d(TrakerLog.getCause()+" activated setOnClick for button: "+view);
                    buttonClicked(button);
                }
            });
            mButtons.add(button);
        }
        TrakerLog.d(TrakerLog.getCause()+" populated view login_keyboard");
    }

    private void buttonClicked(TrakerButton button) {
        switch (button.getId()) {
            case R.id.codeVerificationNextButton: {
                mLoginKeyboardListener.onNextPressed();
                TrakerLog.d(TrakerLog.getCause()+" code verification button clicked");
                break;
            }
            case R.id.codeArrowBackButton: {
                mLoginKeyboardListener.onBackPressed();
                TrakerLog.d(TrakerLog.getCause()+" code login_keyboard_arrow_back_icon back_screen_button_arrow_icon button clicked");

                break;
            }
            default: {
                mLoginKeyboardListener.onDigitPressed(button.getText().toString());
                TrakerLog.d(TrakerLog.getCause()+" code digit button clicked");
                break;
            }

        }
    }
    public void reactivateOkButton(){
        TrakerLog.d(TrakerLog.getCause()+"entered reactivating ok button.");
        TrakerButton okButton = mButtons.get(9);
        okButton.setClickable(true);
        okButton.setBackgroundColor(Color.parseColor("#00E5EE"));

    }


    public interface LoginKeyboardInterface{
        void onNextPressed();
        void onBackPressed();
        void onDigitPressed(String digit);

        // make sure to implement this method properly.
        void onValidNumber();

    }


}
