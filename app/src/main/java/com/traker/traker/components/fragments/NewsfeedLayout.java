package com.traker.traker.components.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.beans.TrakerUser;
import com.traker.traker.components.TrakerButton;
import com.traker.traker.components.TrakerNewsfeedPost;
import com.traker.traker.managers.LoginManager;
import com.traker.traker.managers.server_manager.ServerManager;
import com.traker.traker.managers.server_manager.requests.RequestBase;
import com.traker.traker.managers.server_manager.requests.RequestLogin;
import com.traker.traker.utils.NewsfeedLayoutArrayAdapter;
import com.traker.traker.utils.TrakerApplication;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;

/**
 * Created by idoroiengel on 11/26/17.
 */

public class NewsfeedLayout extends android.support.v4.app.Fragment {

    private ArrayList<TrakerNewsfeedPost> mPosts;
    private static ListView mListView;
    private NewsfeedLayoutArrayAdapter mPostAdapter;
    private static int postNumber;
    private TrakerNewsfeedPost postA;
    private TrakerNewsfeedPost postB;
    private ProgressBar mProgressBar;

    private TrakerNewsfeedPost.TrakerNewsfeedPostInterface mTrakerNewsfeedPostInterface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = null;
        rootView = inflater.inflate(R.layout.newsfeed_layout, container, false);
        mListView = rootView.findViewById(R.id.newsfeed_layout_linear_layout_container);
        mListView.setAdapter(mPostAdapter);
        bindViews(mListView);
        initFragment();
        TrakerLog.d(TrakerLog.getCause() + " onCreateView for NewsfeedLayout.");
//        TrakerLog.d(TrakerLog.getCause() + "this is mPostsLayout: "+mPostsLayout.toString());

        return rootView;
    }

    private void initFragment() {
//        initPosts();
        TrakerLog.d(TrakerLog.getCause() + "NewsfeedLayout fragment initiated.");
    }

    private void bindViews(View rootView) {

//        postA = new TrakerNewsfeedPost(TrakerApplication.getContext());
//        mPostAdapter.add(postA);
//        postB = new TrakerNewsfeedPost(getContext());
//        mPostsLayout.addView(postA);
//        mPostsLayout.addView(postB);
//        mProgressBar = rootView.findViewById(R.id.newsfeed_layout_progress_bar);
        TrakerLog.d(TrakerLog.getCause() + "binded views for fragment.");
    }

    private void initPosts() {
//        mPosts.add(postA);
        TrakerLog.d(TrakerLog.getCause() + "post A: " + postA);
//        mPosts.add(postB);
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
//        mPosts = new ArrayList<>();
//        layout.startSpinner();
//        layout.getDataFromServer();
        TrakerLog.d(TrakerLog.getCause()+" created new instance: "+layout);
        return layout;
    }

    private void getDataFromServer() {
        ServerManager.from(getContext()).sendRequest(new RequestLogin(getContext(), "posts number",
                new RequestBase.RequestListener<TrakerUser>() {
                    @Override
                    public void onSuccess(TrakerUser trakerUser) {
//                        mPosts = trakerUser;
                        updateNewsfeed(mPosts);
//                        stopSpinner();
                    }

                    @Override
                    public void onFail(int resultCode, String message) {

                    }
                }));
    }

//    private void startSpinner() {
//        mProgressBar.setVisibility(View.VISIBLE);
//
//    }
//    private void stopSpinner() {
//        mProgressBar.setVisibility(View.INVISIBLE);
//    }

    private void updateNewsfeed(ArrayList<TrakerNewsfeedPost> mPosts) {
        for(TrakerNewsfeedPost post : mPosts){
            mListView.addView(post);
        }
    }
}

