package com.traker.traker.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableRow;

import com.traker.traker.R;
import com.traker.traker.components.fragments.NewsfeedLayout;
import com.traker.traker.components.OutsideGymLayout;
import com.traker.traker.utils.MainFragmentOrganizer;
import com.traker.traker.utils.TrakerLog;
@Deprecated
public class NewsFeedActivity extends AppCompatActivity {

    private OutsideGymLayout mOutsideGymLayout;
    private TableRow mDesignatedRow;
    private NewsfeedLayout mNewsfeedLayout;
    private FragmentManager fragmentManager;
    private MainFragmentOrganizer fragmentOrganizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        bindViews();
        initViews();
        TrakerLog.d(TrakerLog.getCause() + " activated onCreate method.");
    }

    private void bindViews() {
        mOutsideGymLayout = (OutsideGymLayout) findViewById(R.id.newsfeed_activity_outside_gym_layout);
        mDesignatedRow = mOutsideGymLayout.getmDynamicRow();
        TrakerLog.d(TrakerLog.getCause() + " binded views.");
    }

    private void initViews() {
        loadContentToScreen();
        TrakerLog.d(TrakerLog.getCause() + " initiated views.");
    }

    private void loadContentToScreen() {
        fragmentManager = getSupportFragmentManager();
        fragmentOrganizer = new MainFragmentOrganizer(fragmentManager);

//        android.menu_layout_support_icon.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
//        android.menu_layout_support_icon.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////        NewsfeedLayout fragment = new NewsfeedLayout();
//        mNewsfeedLayout = new NewsfeedLayout();
//        fragmentTransaction.add(R.id.outside_gym_layout_dynamic_table_row, mNewsfeedLayout, "news_feed");
//        fragmentTransaction.addToBackStack("news_feed").commit();
//        fragmentTransaction.commit();

//        mDesignatedRow.addView();


        // get newsfeed from server.
        // maybe use some TableRowBuilder class for this.
        TrakerLog.d(TrakerLog.getCause() + " loaded contentRow.");
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
