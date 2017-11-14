package com.traker.traker.util.requests;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.traker.traker.managers.ServerManager;
import com.traker.traker.util.loggers.TrakerLog;

import java.util.HashMap;

/**
 * Created by idoengel on 10/11/17.
 */

public abstract class RequestBase<T> {

    public static final String BASE_URL = "https://www.fitraker.com/api";
    public static final String MOCK_BASE_URL = "localhost:8080";
    protected Context mContext;
    protected RequestListener<T> mRequestListener;
    private String wsRequestUrl;
    private HashMap<String, Object> parameterMap;
    private int method = Request.Method.GET;

    public RequestBase(Context context,int method, RequestListener<T> requestListener){
        this(context, requestListener);

        this.method = method;
        TrakerLog.i(TrakerLog.getCause()+" activated 3 parameter constructor.");
    }
    public RequestBase(Context context, RequestListener<T> requestListener){
        mContext = context;
        mRequestListener = requestListener;
        TrakerLog.i(TrakerLog.getCause()+" activated 2 parameters constructor.");
    }
    public void send(){
        sendRequest();
        TrakerLog.d(TrakerLog.getCause()+" sent request to ServerManager.");
    }

    protected void sendRequest() {
//        wsRequestUrl = BASE_URL + getWsMethod();
        wsRequestUrl = MOCK_BASE_URL;
        parameterMap = getParameterMap();

        ServerManager.from(mContext).sendRequest(this);
        TrakerLog.d(TrakerLog.getCause()+"Request object ready to be sent to ServerManager.");
    }

    public GsonRequest<T> getRequest(){
        GsonRequest gsonRequest = new GsonRequest(method, "", null, new Response.Listener<T>() {

            @Override
            public void onResponse(T t) {
                if(mRequestListener != null){
                    mRequestListener.onSuccess(t);
                    TrakerLog.d(TrakerLog.getCause()+" onResponse for GsonRequest.");
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                TrakerLog.d(TrakerLog.getCause()+" onError for GsonRequest.");


            }
        });
        return gsonRequest;
    }

    abstract String getWsMethod();
    abstract HashMap<String, Object> getParameterMap();

    public interface RequestListener<T> {
        public void onSuccess(T t);
        public void onFail(int resultCode, String message);
    }
}
