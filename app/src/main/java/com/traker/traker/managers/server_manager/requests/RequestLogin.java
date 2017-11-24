package com.traker.traker.managers.server_manager.requests;

import android.content.Context;

import com.traker.traker.beans.TrakerUser;
import com.traker.traker.utils.TrakerLog;

import java.util.HashMap;

/**
 * Created by idoengel on 10/11/17.
 */

public class RequestLogin extends RequestBase<TrakerUser> {

    private String mPhoneNumber;
    private String mUsername;
    private String mPassword;
    private String url = "/login";

    public RequestLogin(Context context, String userPhoneNumber, final RequestListener<TrakerUser> requestListener){
        super(context, requestListener);

        mPhoneNumber = userPhoneNumber;
        TrakerLog.i(TrakerLog.getCause()+" activated RequestLogin constructor" );
    }

    @Override
    String getWsMethod() {
        return url;
    }

    @Override
    HashMap<String, Object> getParameterMap() {
        HashMap<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("phoneNumber", mPhoneNumber);
        TrakerLog.i(TrakerLog.getCause()+" got parameter map!");
        return parameterMap;
    }
}
