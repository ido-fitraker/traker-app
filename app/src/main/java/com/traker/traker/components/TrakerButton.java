package com.traker.traker.components;

import android.content.Context;
import android.util.AttributeSet;

import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoengel on 10/11/17.
 */

public class TrakerButton extends android.support.v7.widget.AppCompatButton {

    public TrakerButton(Context context) {
        super(context);
        TrakerLog.d(TrakerLog.getCause()+" activated only-context constructor.");
    }

    public TrakerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TrakerLog.d(TrakerLog.getCause()+" activated context+attributes constructor.");
    }

}
