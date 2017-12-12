package com.traker.traker.components;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.traker.traker.R;
import com.traker.traker.beans.TrakerUser;
import com.traker.traker.utils.TrakerLog;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by idoroiengel on 12/1/17.
 */

public class TrakerNewsfeedPostComment extends CustomTrakerLayout {
    // UI
    private CircleImageView mCommentPublisherImage;
    private TextView mCommentPublisherName;
    private TextView mCommentPublisherContent;
    private TextView mCommentTimestamp;

    // data
    private TrakerUser mCommentPublisher;
    private long timestamp;
    private String commentText;

    public TrakerNewsfeedPostComment(Context context) {
        this(context, null);
        TrakerLog.d(TrakerLog.getCause() + " activated context-only constructor.");
    }

    public TrakerNewsfeedPostComment(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.traker_newsfeed_post_comment, this, true);
        bindViews();
//        initViews();
        TrakerLog.d(TrakerLog.getCause() + " activated context+attributes constructor.");
    }
    private void bindViews() {
        mCommentPublisherImage = findViewById(R.id.traker_newsfeed_post_comment_publisher_image);
        mCommentPublisherName = findViewById(R.id.traker_newsfeed_post_comment_publisher_name);
        mCommentPublisherContent = findViewById(R.id.traker_newsfeed_post_comment_text);
        mCommentTimestamp = findViewById(R.id.traker_newsfeed_post_comment_timestamp_text);
        TrakerLog.d(TrakerLog.getCause() + " binded views for TrakerNewsfeedPostComment.");
    }

    private void initViews() {
        mCommentPublisherImage.setImageURI(Uri.fromFile(new File(mCommentPublisher.getProfileImageURI())));
        mCommentPublisherName.setText(mCommentPublisher.getFullName());
        mCommentPublisherContent.setText(commentText);
        mCommentTimestamp.setText(Long.valueOf(timestamp).toString());
        TrakerLog.d(TrakerLog.getCause() + " initiated views for TrakerNewsfeedPostComment.");
    }

}
