package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by idoroiengel on 11/12/17.
 */

public abstract class CustomTrakerLayout extends LinearLayout {
    public CustomTrakerLayout(Context context) {
        super(context);
    }

    public CustomTrakerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


}
