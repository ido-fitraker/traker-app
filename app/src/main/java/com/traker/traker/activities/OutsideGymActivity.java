package com.traker.traker.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableRow;

import com.traker.traker.R;
import com.traker.traker.components.TrakerNewsfeedPost;
import com.traker.traker.components.TrakerNewsfeedPostCommentSection;
import com.traker.traker.components.fragments.NewsfeedLayout;
import com.traker.traker.components.OutsideGymLayout;
import com.traker.traker.utils.MainFragmentOrganizer;
import com.traker.traker.utils.TrakerLog;

import java.util.ArrayList;

public class OutsideGymActivity extends AppCompatActivity {

    private OutsideGymLayout mOutsideGymLayout;
    private TableRow mDesignatedRow;
    private FragmentManager fragmentManager;
    private MainFragmentOrganizer fragmentOrganizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outside_gym);
        bindViews();
        initViews();
        TrakerLog.d(TrakerLog.getCause() + " onCreate for OutsideGymActivity.");
    }

    private void bindViews() {
        mOutsideGymLayout = findViewById(R.id.outside_gym_activity_outside_gym_layout);
//        mDesignatedRow = mOutsideGymLayout.getmDynamicRow();
        TrakerLog.d(TrakerLog.getCause() + " binded views in OutsideGymActivity.");
    }

    private void initViews() {
        loadFragmentToScreen();
        TrakerLog.d(TrakerLog.getCause() + " initiated views in OutsideGymActivity.");
    }

    private void loadFragmentToScreen() {
        fragmentManager = getSupportFragmentManager();
        fragmentOrganizer = new MainFragmentOrganizer(fragmentManager);
        mOutsideGymLayout.setmOutsideGymLayoutInterface(new OutsideGymLayout.OutsideGymLayoutInterface() {
            @Override
            public void openPersonalProfileScreen(Fragment fragment) {
                fragmentOrganizer.openFragment(fragment);
            }

            @Override
            public void openNewsfeedScreen(Fragment fragment) {
//                initMockNewsfeed();
                fragmentOrganizer.openFragment(fragment);
            }
        });
        TrakerLog.d(TrakerLog.getCause() + " loaded fragment to screen.");
    }

    private void initMockNewsfeed() {
        ArrayList<TrakerNewsfeedPost> mockPostsList = new ArrayList<>();
        TrakerNewsfeedPost postA = new TrakerNewsfeedPost(this);
        TrakerNewsfeedPost postB = new TrakerNewsfeedPost(this);
        TrakerNewsfeedPostCommentSection sectionA = new TrakerNewsfeedPostCommentSection(this);
        TrakerNewsfeedPostCommentSection sectionB = new TrakerNewsfeedPostCommentSection(this);
        mockPostsList.add(postA);
        mockPostsList.add(postB);
//        mOutsideGymLayout.removeView();
        mOutsideGymLayout.getmDynamicRow().addView(postA);
        mOutsideGymLayout.getmDynamicRow().addView(postB);
        TrakerLog.d(TrakerLog.getCause() + " initiated mock newsfeed.");
    }

    @Override
    public void onBackPressed() {
        if(!fragmentOrganizer.handleBackNavigation()){
            finish();
        }
        TrakerLog.d(TrakerLog.getCause()+" onBackPressed.");
    }

    @Override
    protected void onDestroy() {
        fragmentOrganizer.freeUpResources();
        super.onDestroy();
        TrakerLog.d(TrakerLog.getCause()+" onDestroy.");
    }
    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment instanceof NewsfeedLayout){
            TrakerLog.d(TrakerLog.getCause()+" right kind of fragment.");
        }
    }
}
