package com.traker.traker.activities.login_flow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.widget.EditText;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.components.LoginKeyboard;
import com.traker.traker.managers.LoginManager;
import com.traker.traker.utils.TrakerLog;


public class RegistrationActivity extends AppCompatActivity {
    /*
    what else need to be done in this class:
    1. fix the layout to be aligned in all directions.
    2. check that onClick methods work properly for all buttons.
    3. check JSON sending via API, and receiving a valid answer.
    4. solve problem with hebrew text reversed. - seems fine
    5. add login_keyboard_arrow_back_icon icon to back_screen_button_arrow_icon button.
    6. OK button needs to be tourquise only when the number entered is valid!
     */

    // UI
    private EditText mUserPhoneNumber;
    private LoginKeyboard mKeyboard;

    // data
    private String mStringNumber;
    private int mAccessCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        bindViews();
        initViews();
    }

    private void bindViews(){
        mUserPhoneNumber = (EditText)findViewById(R.id.registration_signupUserPhoneNumber);
        mKeyboard = (LoginKeyboard)findViewById(R.id.registration_loginKeyboard);
    }

    private void initViews(){
        mKeyboard.setmLoginKeyboardListener(new LoginKeyboard.LoginKeyboardInterface() {
            @Override
            public void onNextPressed() {
                submitPhoneNumber();
                TrakerLog.d(TrakerLog.getCause()+"next pressed");
            }

            @Override
            public void onBackPressed() {
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(mUserPhoneNumber, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                TrakerLog.d(TrakerLog.getCause()+"back_screen_button_arrow_icon pressed");

            }

            @Override
            public void onDigitPressed(String digit) {
                mUserPhoneNumber.append(digit);
                TrakerLog.d(TrakerLog.getCause()+"digit: "+digit+" pressed");
//                if(PhoneNumberUtils.isGlobalPhoneNumber(mUserPhoneNumber.getText().toString())){
//                    TrakerLog.i(TrakerLog.getCause()+" inside while loop.");
//                    onValidNumber();
//                }

            }

            @Override
            public void onValidNumber() {
//                TrakerLog.d(TrakerLog.getCause()+" inside onValidNumber method.");
//                // this method will notify the user when the number is valid by changing ok button color
//                // to tourquise.
//                mKeyboard.reactivateOkButton();
//                //mUserPhoneNumber.length();
//                PhoneNumberUtils.isWellFormedSmsAddress(mUserPhoneNumber.toString());
            }
        });
//        if(PhoneNumberUtils.isGlobalPhoneNumber("0523581786")){
//            Toast.makeText(this, "great number",Toast.LENGTH_SHORT).show();
//        }
    }

    private void submitPhoneNumber(){
        if(mUserPhoneNumber.getText().length() != 0) {
            mStringNumber = mUserPhoneNumber.getText().toString();
            LoginManager.getInstance().attemptLogin(mStringNumber);
            Intent i = new Intent(this, CodeVerificationActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "נא הזן מספר טלפון", Toast.LENGTH_SHORT).show();
        }
        TrakerLog.d(TrakerLog.getCause()+"phone number is: "+mStringNumber);
    }

}
