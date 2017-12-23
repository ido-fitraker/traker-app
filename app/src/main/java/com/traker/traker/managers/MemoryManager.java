package com.traker.traker.managers;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.traker.traker.beans.TrakerUser;
import com.traker.traker.beans.business_objects.CacheWrapper;
import com.traker.traker.utils.TrakerApplication;
import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoroiengel on 12/17/17.
 */

public class MemoryManager {

    private static MemoryManager instance = null;
    SharedPreferences mSharedPreferences;

    private MemoryManager() {
        this.mSharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(
                        TrakerApplication.getContext());
        TrakerLog.d(TrakerLog.getCause() + " retrieved MemoryManager.");
    }

    public static MemoryManager getInstance() {
        if (instance == null) {
            synchronized (MemoryManager.class) {
                if (instance == null) {
                    instance = new MemoryManager();
                }
                return instance;
            }
        }
        TrakerLog.d(TrakerLog.getCause() + " got instance of MemoryManager.");
        return instance;
    }

    private void putData(CacheWrapper cacheWrapper, String key){
        Gson gson = new Gson();
        String json = gson.toJson(cacheWrapper.data);
        mSharedPreferences.edit().putString(json, key);
        TrakerLog.d(TrakerLog.getCause() + "activated put data.");
    }

    private CacheWrapper getData(String key){
        Gson gson = new Gson();
        String json = mSharedPreferences.getString(key, null);
        CacheWrapper object = gson.fromJson(json, CacheWrapper.class);
        TrakerLog.d(TrakerLog.getCause() + " activated get data.");
        return object;
    }

    public void setLoggedinUser(TrakerUser user){
        putData(new CacheWrapper(user), "login_logged_in_user");
        TrakerLog.d(TrakerLog.getCause() + " set loggedIn user.");
    }
    public TrakerUser getLoggedinUser(){
        TrakerLog.d(TrakerLog.getCause() + " got loggedIn user.");
        return (TrakerUser) getData("login_logged_in_user").data;
    }
}
