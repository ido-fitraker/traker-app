package com.traker.traker.activities.login_flow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

import android.widget.TextView;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.components.LoginKeyboard;
import com.traker.traker.managers.LoginManager;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;
import java.util.Arrays;


public class CodeVerificationActivity extends AppCompatActivity {

    //UI
    private TextView[] mCodeDigits;
    private LoginKeyboard mKeyboard;

    private ArrayList<TextView> boxesList;

    private static final int[] CODE_DIGITS= {
        R.id.code_verification_FirstDigit,
        R.id.code_verification_SecondDigit,
        R.id.code_verification_ThirdDigit,
        R.id.code_verification_FourthDigit
    };

    private SmsManager manager;
    private SmsMessage code_message;
    private String mSampleVerificationMessage;
    private long mSmsCode;

    // should check whether there's a logged-in user. if so, transfer straight to NewsfeedActivity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        bindViews();
        initViews();
        initData();
        TrakerLog.d(TrakerLog.getCause()+" inside onCreate method.");
    }

    private void bindViews() {
        mKeyboard = (LoginKeyboard)findViewById(R.id.code_verification_loginKeyboard);
        TrakerLog.d(TrakerLog.getCause()+" binded views.");
    }
    /*  this method is for mock use only
        delete it once the server can traker_newsfeed_post_comment_send_icon the sms verification messages!
    */
    private void initData() {

        mSampleVerificationMessage = "welcome to Traker, your code is:3456";
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.putExtra("sms_body", mSampleVerificationMessage);
//        mSmsCode = extractCodeFromSmsMessage(mSampleVerificationMessage);
        TrakerLog.i(mSmsCode+"");
        TrakerLog.d(TrakerLog.getCause()+" initiated data.");
    }

    private void initViews() {
        mKeyboard.setmLoginKeyboardListener(new LoginKeyboard.LoginKeyboardInterface() {
            @Override
            public void onNextPressed() {
                submitCode();
            }

            @Override
            public void onBackPressed() {
                TextView emptyBox = checkAvailableViewToDelete();
                if(emptyBox != null) {
                    emptyBox.setText(null);
                }
                TrakerLog.d(TrakerLog.getCause()+" inside onBackPressed.");
            }

            @Override
            public void onDigitPressed(String digit) {
                TextView emptyBox = checkAvailableViewToAppend();
                if(emptyBox != null) {
                    emptyBox.setText(digit);
                }
                TrakerLog.d(TrakerLog.getCause()+" inside onDigitPressed.");
            }

            @Override
            public void onValidNumber() {

            }
        });
        inflateBoxes(CODE_DIGITS);
        boxesList = new ArrayList<>(Arrays.asList(mCodeDigits));
        TrakerLog.d(TrakerLog.getCause()+" initiated views.");
    }
    protected void inflateBoxes(int[] board) {
        mCodeDigits = new TextView[4];
        for(int i = 0; i < mCodeDigits.length; i++){
            TextView e = (TextView) findViewById(board[i]);
            mCodeDigits[i] = e;
        }
        TrakerLog.d(TrakerLog.getCause()+" inflated boxes.");
    }
    private TextView checkAvailableViewToAppend() {
        TextView et = null;
        for (TextView e : boxesList) {
            if (!e.getText().toString().isEmpty()) {
                continue;
            } else {
                et = e;
                break;
            }
        }
        TrakerLog.d(TrakerLog.getCause()+" checked if can append.");
//        TrakerLog.i(TrakerLog.getCause()+et.toString());
        return et;
    }

    private TextView checkAvailableViewToDelete(){
        TextView et = null;
        for(int j = boxesList.size() - 1; j >= 0; j--){
            if(boxesList.get(j).getText().toString().isEmpty()){
                continue;
            }else{
                et = boxesList.get(j);
                break;
            }

        }TrakerLog.d(TrakerLog.getCause()+" checked if can delete.");
//        TrakerLog.i(TrakerLog.getCause()+et.toString());
        return et;
    }
    private void submitCode() {
        if(LoginManager.getInstance().verifyCode(mSmsCode)) {
            // LoginManager.getInstance().sendCode()......
            Intent i = new Intent(this, PersonalDetailsActivity.class);
            startActivity(i);
            TrakerLog.d(TrakerLog.getCause()+" code submitted.");
        }

    }


    // temporarily receives String for testing, should receive an SmsMessage object.
    protected long extractCodeFromSmsMessage(String message){
        String[] str = message.split(":");
        String codeInString = str[1];
        Long code = new Long(codeInString);
        Toast.makeText(this, code.toString(), Toast.LENGTH_SHORT).show();
        char[] codeDigits = code.toString().toCharArray();
        TrakerLog.d(codeDigits.length+"");
        for(int i = 0; i < codeDigits.length; i++){
            mCodeDigits[i].setText(String.valueOf(codeDigits[i]));
        }
        TrakerLog.d(TrakerLog.getCause()+"extractCodeFromSmsMessage.");
        return code;
    }

}
