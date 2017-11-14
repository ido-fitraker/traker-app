package com.traker.traker.managers;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.traker.traker.util.loggers.TrakerLog;
import com.traker.traker.util.requests.RequestBase;

/**
 * Created by idoengel on 10/11/17.
 */

public class ServerManager {
    private static ServerManager instance = null;
    private RequestQueue mRequestQueue = null;

    public static ServerManager from(Context context) {
        if(instance == null){
            instance = new ServerManager(context);
        }
        return instance;
    }

    private ServerManager(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        TrakerLog.d(TrakerLog.getCause()+" instantiated a new request queue.");
    }

    public RequestQueue getmRequestQueue() {
        return mRequestQueue;
    }

    public void sendRequest(RequestBase requestBase){
        mRequestQueue.add(requestBase.getRequest());
        TrakerLog.i(TrakerLog.getCause()+" added new request to queue.");
    }
}
