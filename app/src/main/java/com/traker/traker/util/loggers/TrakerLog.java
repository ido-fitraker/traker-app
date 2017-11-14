package com.traker.traker.util.loggers;

import android.util.Log;

/**
 * Created by idoengel on 10/11/17.
 */

public class TrakerLog {

    private static final boolean DEBUG = true;
    private static String TAG = "TRAKER";

    public static void d(String string){
        if(DEBUG)
            Log.d(TAG, string);
    }
    public static void v(String string){
        if(DEBUG)
            Log.v(TAG, string);
    }
    public static void i(String string){
        if(DEBUG)
            Log.i(TAG, string);
    }
    public static void e(String string){
        if(DEBUG)
            Log.e(TAG, string);
    }
    public static void w(String string){
        if(DEBUG)
            Log.w(TAG, string);
    }
    public static void wtf(String string){
        Log.wtf(TAG, string);
    }
    public static String getCause(){
        return getMessagePrefix();
    }



    // this method retrieves the class name and the method name that caused the exception.
    private static String getMessagePrefix(){
        String messagePrefix = "";
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if(stackTraceElements != null && stackTraceElements.length > 4) {
            String fileName = Thread.currentThread().getStackTrace()[4].getFileName().split("\\.")[0];
            String methodName = Thread.currentThread().getStackTrace()[4].getMethodName();
            messagePrefix += fileName + "." + methodName + " - ";
        }
        return messagePrefix;
    }

    public TrakerLog() {
    }
}
