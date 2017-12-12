package com.traker.traker.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.traker.traker.R;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;

/**
 * Created by idoroiengel on 12/7/17.
 */

public class TrakerNewsfeedPostCommentSection extends CustomTrakerLayout {

    private ArrayList<TrakerNewsfeedPostComment> mComments;

    public TrakerNewsfeedPostCommentSection(Context context) {
        this(context, null);
        TrakerLog.d(TrakerLog.getCause() + " activated context-only constructor.");
    }

    public TrakerNewsfeedPostCommentSection(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (getmComments() != null) {
            inflateComments(mComments);
    }
        LayoutInflater.from(context).inflate(R.layout.traker_newsfeed_post_comments_section, this, true);
        TrakerLog.d(TrakerLog.getCause() + " activated context+attributes constructor.");
    }

    private void inflateComments(ArrayList<TrakerNewsfeedPostComment> commentsList) {
        for(TrakerNewsfeedPostComment comment : commentsList){
            this.addView(comment, 0);
        }
        TrakerLog.d(TrakerLog.getCause() + " inflated comments in comments section.");
    }

    public ArrayList<TrakerNewsfeedPostComment> getmComments() {
        return mComments;
    }

    public void setmComments(ArrayList<TrakerNewsfeedPostComment> mComments) {
        this.mComments = mComments;
    }
}
