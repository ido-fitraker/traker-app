package com.traker.traker.components;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.widget.ImageButton;

import com.traker.traker.beans.enums.MainBottomBarEnum;

/**
 * Created by idoroiengel on 11/26/17.
 */

public class TrakerImageButton extends AppCompatImageButton {

    private MainBottomBarEnum enumValue;

    public TrakerImageButton(Context context) {
        this(context, null);
    }

    public TrakerImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setEnumValue(MainBottomBarEnum enumValue) {
        this.enumValue = enumValue;
    }

    public MainBottomBarEnum getEnumValue() {
        return enumValue;
    }
}
