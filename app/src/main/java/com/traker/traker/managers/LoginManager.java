package com.traker.traker.managers;

import com.traker.traker.activities.login_flow.ChosenTrainerActivity;
import com.traker.traker.activities.login_flow.CodeVerificationActivity;
import com.traker.traker.activities.login_flow.HealthFormActivity;
import com.traker.traker.activities.login_flow.MyGoalsActivity;
import com.traker.traker.activities.login_flow.PersonalDetailsActivity;
import com.traker.traker.activities.login_flow.RegistrationActivity;
import com.traker.traker.activities.login_flow.TrainerChoosingActivity;
import com.traker.traker.beans.TrakerUser;
import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoengel on 10/11/17.
 */

public class LoginManager {

    private static volatile LoginManager instance = new LoginManager();
    private static TrakerUser loggedinUser = new TrakerUser();
    private Object parcel;


    public static LoginManager getInstance(){
        if  (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }
    private LoginManager(){ }

    public static final Class[] LOGIN_ACTIVITIES = new Class[]{
        RegistrationActivity.class,
        CodeVerificationActivity.class,
        PersonalDetailsActivity.class,
        HealthFormActivity.class,
        MyGoalsActivity.class,
        TrainerChoosingActivity.class,
        ChosenTrainerActivity.class
    };

    public void attemptLogin(String phoneNumber){
//        new RequestLogin(null, phoneNumber, new RequestBase.RequestListener<TrakerUser>() {
//            @Override
//            public void onSuccess(TrakerUser trakerUser){
//                TrakerLog.d(TrakerLog.getCause()+" onSuccess");
//            }
//
//            @Override
//            public void onFail(int resultCode, String message) {
//                TrakerLog.d(TrakerLog.getCause()+" onFail");
//            }
//        })
//                .traker_newsfeed_post_comment_send_icon();
        loggedinUser.setPhone(Long.valueOf(phoneNumber));
        TrakerLog.d(TrakerLog.getCause()+" attempt login sent.");
    }

    public void attemptRegister(){

    }
    public static TrakerUser getLoggedinUser(){
        return loggedinUser;
    }


    public boolean verifyCode(long code) {
        // compare code to the sms code sent to the phone.
        TrakerLog.d(TrakerLog.getCause()+" code verified.");
        return true;
    }

    public Object getObject() {
        return parcel;
    }

    public void setObject(Object parcel) {
        this.parcel = parcel;
    }


}
