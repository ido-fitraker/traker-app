package com.traker.traker.beans.business_objects;

import android.provider.Settings;
import android.text.method.DateTimeKeyListener;

import com.traker.traker.utils.TrakerApplication;
import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoroiengel on 12/17/17.
 */

public class CacheWrapper {

    public Object data;
    public long timestamp;

    public CacheWrapper(Object object){
        this.data = object;
        timestamp = System.currentTimeMillis();
        TrakerLog.d(TrakerLog.getCause() + " activated CacheWrapper constructor.");
    }
}
