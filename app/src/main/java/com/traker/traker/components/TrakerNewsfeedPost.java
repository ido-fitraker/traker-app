package com.traker.traker.components;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.traker.traker.R;
import com.traker.traker.beans.TrakerUser;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by idoroiengel on 12/1/17.
 */

public class TrakerNewsfeedPost extends CustomTrakerLayout {

    // UI
    private CircleImageView mPostPublisherImage;
    private TextView mPostPublisherName;
    private TextView mPostTimestamp;
    private TextView mPostContent;
    private ImageView mPostImage;
    private TextView mPostLikesNumber;
    private TextView mPostCommentsNumber; // equals mComments.size()
    private TextView mPostSharesNumber;

    // data
    private TrakerUser mPublisher;
    private String mText;
    private int mLikesNumber;
    private ArrayList<TrakerNewsfeedPostComment> mComments;
    private int mShareNumber;
    private long mTimestamp;
    // add image member for post image.

    public TrakerNewsfeedPost(Context context) {
        this(context, null);
    }

    public TrakerNewsfeedPost(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.traker_newsfeed_post, this,true);
        bindViews();
//        initViews();

    }

    private void bindViews() {
        mPostPublisherImage = findViewById(R.id.newsfeed_post_publisher_image);
        mPostPublisherName = findViewById(R.id.newsfeed_post_publisher_name);
        mPostTimestamp = findViewById(R.id.newsfeed_post_timestamp);
        mPostContent = findViewById(R.id.newsfeed_post_content_text);
        mPostImage = findViewById(R.id.newsfeed_post_image_post);
        mPostLikesNumber = findViewById(R.id.newsfeed_post_likes_layout_likes_number);
        mPostCommentsNumber = findViewById(R.id.newsfeed_post_comments_layout_comments_number);
        mPostSharesNumber = findViewById(R.id.newsfeed_post_shares_layout_shares_number);
    }

    private void initViews() {
        fillPostdetailsFromServer();

    }

    private void fillPostdetailsFromServer() {
        // verify this line of code.
        mPostPublisherImage.setImageURI(Uri.parse(mPublisher.getProfileImageURI()));
        mPostPublisherName.setText(mPublisher.getFullName());
        mPostTimestamp.setText(Long.valueOf(mTimestamp).toString()); // need to be concanated with human readable text e.g "xxx *hours ago*"
        mPostContent.setText(mText);
//        mPostImage.setImageBitmap();
        mPostLikesNumber.setText(mLikesNumber);
        mPostCommentsNumber.setText(mComments.size());
        mPostSharesNumber.setText(mShareNumber);
    }
}
