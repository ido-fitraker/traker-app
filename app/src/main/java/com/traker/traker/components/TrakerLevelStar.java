package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.traker.traker.R;
import com.traker.traker.utils.TrakerLog;

/**
 * Created by idoroiengel on 1/21/18.
 */

public class TrakerLevelStar extends FrameLayout {

    private TrakerImageView mStarImage;
    private TrakerTextView mLevelNumber;
    private int mLevel;

    public TrakerLevelStar(@NonNull Context context) {
        this(context, null);
        TrakerLog.d(TrakerLog.getCause() + " activated context-only constructor.");
    }

    public TrakerLevelStar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.traker_level_star, this, true);
        bindViews();
        TrakerLog.d(TrakerLog.getCause() + " activated context+attributes constructor.");
    }

    public void setmLevelNumber(TrakerTextView mLevelNumber) {
        this.mLevelNumber = mLevelNumber;
    }

    public void setmLevel(int mLevel) {
        this.mLevel = mLevel;
        initViews();
        TrakerLog.d(TrakerLog.getCause() + " activated setter for mLevel.");
    }

    private void bindViews() {
        mStarImage = findViewById(R.id.traker_level_star_image_star);
        mLevelNumber = findViewById(R.id.traker_level_star_level_text);
        TrakerLog.d(TrakerLog.getCause() + " binded views.");
    }

    private void initViews() {
        mLevelNumber.setText(Integer.toString(mLevel));
        TrakerLog.d(TrakerLog.getCause() + " initiated views.");
    }


}
