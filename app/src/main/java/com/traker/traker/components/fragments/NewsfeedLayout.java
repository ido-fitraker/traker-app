package com.traker.traker.components.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.components.TrakerButton;
import com.traker.traker.components.TrakerNewsfeedPost;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;

/**
 * Created by idoroiengel on 11/26/17.
 */

public class NewsfeedLayout extends android.support.v4.app.Fragment {

    private static ArrayList<TrakerNewsfeedPost> mPosts;
    private LinearLayout mPostsLayout;
    private static int postNumber;
    private TrakerNewsfeedPost postA;
    private TrakerNewsfeedPost postB;

    private TrakerNewsfeedPost.TrakerNewsfeedPostInterface mTrakerNewsfeedPostInterface;

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        TrakerLog.d(TrakerLog.getCause() + "context: " + getContext());
//        TrakerLog.d(TrakerLog.getCause() + "activity: " + getActivity());
//        TrakerLog.d(TrakerLog.getCause() + "view: " + getView());
//        View v = getActivity().findViewById(R.id.outside_gym_activity_outside_gym_layout);
//
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = null;
        try {
            rootView = inflater.inflate(R.layout.newsfeed_layout, container, false);
        }catch (Exception e){
            TrakerLog.d(TrakerLog.getCause() + e.toString());
        }
        mPostsLayout = rootView.findViewById(R.id.newsfeed_layout_linear_layout_container);
        bindViews();
        initFragment();
        TrakerLog.d(TrakerLog.getCause() + " onCreateView for NewsfeedLayout.");
        TrakerLog.d(TrakerLog.getCause() + "this is mPostsLayout: "+mPostsLayout.toString());

        return rootView;
    }

    private void initFragment() {
        initPosts();
        TrakerLog.d(TrakerLog.getCause() + "NewsfeedLayout fragment initiated.");
    }

    private void bindViews() {
        postA = new TrakerNewsfeedPost(getContext());
        postB = new TrakerNewsfeedPost(getContext());
        mPostsLayout.addView(postA);
        mPostsLayout.addView(postB);
        TrakerLog.d(TrakerLog.getCause() + "binded views for fragment.");
    }

    private void initPosts() {
        mPosts.add(postA);
        TrakerLog.d(TrakerLog.getCause() + "post A: " + postA);
        mPosts.add(postB);
        for(final TrakerNewsfeedPost post : mPosts){
            post.setMtrakerNewsfeedPostListener(new TrakerNewsfeedPost.TrakerNewsfeedPostInterface() {
                @Override
                public void onProfileImagePressed() {

                }

                @Override
                public void onPostImagePressed() {

                }

                @Override
                public void onLikePressed() {
                    Toast.makeText(NewsfeedLayout.super.getActivity(), "pressed like", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCommentPressed() {
                    commentOnPost(post);
                    Toast.makeText(NewsfeedLayout.super.getActivity(), "pressed comment", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSharePressed() {
                    Toast.makeText(NewsfeedLayout.super.getActivity(), "pressed share", Toast.LENGTH_SHORT).show();
                }
            });
        }
        TrakerLog.d(TrakerLog.getCause() + " initiated posts in newsfeed layout.");
    }

    private void commentOnPost(TrakerNewsfeedPost post) {
        post.getmCommentsSection().setVisibility(View.VISIBLE);
        TrakerLog.d(TrakerLog.getCause() + " activated commentOnPost method.");
    }

    public static NewsfeedLayout newInstance() {
        NewsfeedLayout layout = new NewsfeedLayout();
        mPosts = new ArrayList<>();
        TrakerLog.d(TrakerLog.getCause()+" created new instance: "+layout);
        return layout;
    }
}

