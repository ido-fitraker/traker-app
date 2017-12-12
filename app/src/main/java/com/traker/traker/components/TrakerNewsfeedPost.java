package com.traker.traker.components;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.traker.traker.R;
import com.traker.traker.beans.TrakerUser;
import com.traker.traker.beans.enums.TrakerNewsfeedPostEnum;
import com.traker.traker.utils.TrakerLog;

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
    private TrakerImageView mPostImage;
    private TextView mPostLikesNumber;
    private TextView mPostCommentsNumber; // equals mComments.size()
    private TextView mPostSharesNumber;
    private TrakerNewsfeedPostCommentSection mCommentsSection;

    private static final int[] CLICKABLE_BUTTONS = {
            R.id.newsfeed_post_likes_layout_likes_image,
            R.id.newsfeed_post_comments_layout_comments_image,
            R.id.newsfeed_post_shares_layout_shares_image
    };

    // clickable
    private TrakerImageButton mLikesImage;
    private TrakerImageButton mCommentsImage;
    private TrakerImageButton mSharesImage;

    private ArrayList<TrakerImageButton> mClickeableButtonsList;

    // data
    private TrakerUser mPublisher;
    private String mText;
    private int mLikesNumber;
//    private ArrayList<TrakerNewsfeedPostComment> mComments;

    private int mShareNumber;
    private long mTimestamp;

    private TrakerNewsfeedPostInterface mTrakerNewsfeedPostListener;

    public TrakerNewsfeedPost(Context context) {
        this(context, null);
        TrakerLog.d(TrakerLog.getCause() + " activated context-only constructor.");
    }

    public TrakerNewsfeedPost(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.traker_newsfeed_post, this,true);
        bindViews();
        initViews();
        TrakerLog.d(TrakerLog.getCause() + " activated context+attributes constructor.");
    }

    public void setMtrakerNewsfeedPostListener(TrakerNewsfeedPostInterface mTrakerNewsfeedPostListener) {
        this.mTrakerNewsfeedPostListener = mTrakerNewsfeedPostListener;
    }

    public void setmCommentsSection(TrakerNewsfeedPostCommentSection mCommentsSection) {
        this.mCommentsSection = mCommentsSection;
    }

    public TrakerNewsfeedPostCommentSection getmCommentsSection() {
        return mCommentsSection;
    }

    private void bindViews() {
        bindUI();
        bindClickables();
        TrakerLog.d(TrakerLog.getCause() + " binded views for TrakerNewsfeedPost.");
    }

    private void bindClickables() {
        mLikesImage = findViewById(R.id.newsfeed_post_likes_layout_likes_image);
        mCommentsImage = findViewById(R.id.newsfeed_post_comments_layout_comments_image);
        mSharesImage = findViewById(R.id.newsfeed_post_shares_layout_shares_image);
        TrakerLog.d(TrakerLog.getCause() + " binded clickables for TrakerNewsfeedPost.");
    }

    private void bindUI() {
        mPostPublisherImage = findViewById(R.id.newsfeed_post_publisher_image);
        mPostPublisherName = findViewById(R.id.newsfeed_post_publisher_name);
        mPostTimestamp = findViewById(R.id.newsfeed_post_timestamp);
        mPostContent = findViewById(R.id.newsfeed_post_content_text);
        mPostImage = findViewById(R.id.newsfeed_post_image_post);
        mPostLikesNumber = findViewById(R.id.newsfeed_post_likes_layout_likes_number);
        mPostCommentsNumber = findViewById(R.id.newsfeed_post_comments_layout_comments_number);
        mPostSharesNumber = findViewById(R.id.newsfeed_post_shares_layout_shares_number);
        mCommentsSection = findViewById(R.id.traker_newsfeed_post_comments_section);
        TrakerLog.d(TrakerLog.getCause() + " binded UI for TrakerNewsfeedPost.");
    }

    private void initViews() {
        animatePost(CLICKABLE_BUTTONS);
//        fillPostdetailsFromServer();
        TrakerLog.d(TrakerLog.getCause() + " initiated views for TrakerNewsfeedPost.");
    }

    private void animatePost(int[] clickables) {
        mClickeableButtonsList = new ArrayList<>();
        for(int i = 0; i < clickables.length; i++){
            final TrakerImageButton view = findViewById(clickables[i]);
            if(view != null){
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonClicked(view);
                }
            });
            mClickeableButtonsList.add(view);
            assignEnumValue(view, i);

        TrakerLog.d(TrakerLog.getCause() + " animated post TrakerNewsfeedPost.");
    }else{
                TrakerLog.d(TrakerLog.getCause() + "NULL NULL NULL");
            }
        }
    }

    private void buttonClicked(View view) {
        updateNewsfeedPostButton((TrakerImageButton) view);
        activateSuperListener((TrakerImageButton)view);
//        TrakerNewsfeedPostEnum[] enumValues = TrakerNewsfeedPostEnum.values();
//        for(TrakerNewsfeedPostEnum value : enumValues){
//            if(view.getId() == value.getId()){
//                changeIconUI(view);
//            }else{
//                // do something with profile image or post image.
//            }
//        }
        TrakerLog.d(TrakerLog.getCause() + "button clicked.");
    }

    private void activateSuperListener(TrakerImageButton view) {
        switch (view.getId()){
            case R.id.newsfeed_post_likes_layout_likes_image: {
                mTrakerNewsfeedPostListener.onLikePressed();
                break;
            }
            case R.id.newsfeed_post_comments_layout_comments_image: {
                mTrakerNewsfeedPostListener.onCommentPressed();
                break;
            }
            case R.id.newsfeed_post_shares_layout_shares_image: {
                mTrakerNewsfeedPostListener.onSharePressed();
                break;
            }
        }
    }

    private void updateNewsfeedPostButton(TrakerImageButton view) {
        for(TrakerImageButton imageButton : mClickeableButtonsList){
            if(imageButton.equals(view)){
                imageButton.setImageResource(imageButton.getNewsfeedPostEnumValue().getPressedId());
            }
        }
    }

    private void assignEnumValue(TrakerImageButton view, int index) {
        TrakerNewsfeedPostEnum[] values = TrakerNewsfeedPostEnum.values();
        view.setNewsfeedPostEnumValue(values[index]);
        TrakerLog.d(TrakerLog.getCause() + " assigned enum value.");
    }

    private void fillPostdetailsFromServer() {
        // verify this line of code.
        mPostPublisherImage.setImageURI(Uri.parse(mPublisher.getProfileImageURI()));
        mPostPublisherName.setText(mPublisher.getFullName());
        mPostTimestamp.setText(Long.valueOf(mTimestamp).toString()); // need to be concanated with human readable text e.g "xxx *hours ago*"
        mPostContent.setText(mText);
//        mPostImage.setImageBitmap();
        mPostLikesNumber.setText(mLikesNumber);
        mPostCommentsNumber.setText(mCommentsSection.getmComments().size());
        mPostSharesNumber.setText(mShareNumber);
        TrakerLog.d(TrakerLog.getCause() + " filled post details from server.");
    }
    public interface TrakerNewsfeedPostInterface {
        void onProfileImagePressed();
        void onPostImagePressed();
        void onLikePressed();
        void onCommentPressed();
        void onSharePressed();
    }
}
