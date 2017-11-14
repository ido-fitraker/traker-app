package com.traker.traker.util.requests;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.traker.traker.util.loggers.TrakerLog;

import java.util.Map;

/**
 * Created by idoengel on 10/16/17.
 */

public class GsonRequest<T> extends Request<T> {

    private final Response.Listener<T> listener;
    private final Map<String, String> headers;

    public GsonRequest(int method, String url, Map<String, String> headers, Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.headers = headers;
        this.listener = listener;
        TrakerLog.i(TrakerLog.getCause()+" activated GsonRequest constructor.");
    }


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }
}
