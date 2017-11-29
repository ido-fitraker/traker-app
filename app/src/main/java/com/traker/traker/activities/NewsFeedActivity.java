package com.traker.traker.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableRow;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.components.NewsfeedLayout;
import com.traker.traker.components.OutsideGymLayout;
import com.traker.traker.utils.TrakerLog;

public class NewsFeedActivity extends AppCompatActivity {

    private OutsideGymLayout mOutsideGymLayout;
    private TableRow mDesignatedRow;
    private NewsfeedLayout mNewsfeedLayout;

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
        TrakerLog.d(TrakerLog.getCause() + " entered initViews().");
        mOutsideGymLayout.setmOutsideGymLayoutInterface(new OutsideGymLayout.OutsideGymLayoutInterface() {
            @Override
            public void openMenuScreen() {
                openMenu();
//                openMenu();
            }

            @Override
            public void goToHomeScreen() {
//                switchToHomeScreen();
            }

            @Override
            public void goToProfileScreen() {

            }

            @Override
            public void goToWorkoutScreen() {

            }

            @Override
            public void goToCalendarScreen() {

            }
        });

        TrakerLog.d(TrakerLog.getCause() + " after setDynamicRow.");
        TrakerLog.d(TrakerLog.getCause() + " initiated views.");
    }

    private void switchToHomeScreen() {
        Toast.makeText(this, "you pressed bottom_bar_home_button screen", Toast.LENGTH_SHORT).show();
        TrakerLog.d(TrakerLog.getCause() + " switched to bottom_bar_home_button screen.");
    }

    private void openMenu() {
//        Toast.makeText(this, "you pressed menu", Toast.LENGTH_SHORT).show();
//        Intent i = new Intent(this, PersonalProfileActivity.class);
//        TrakerLog.d(TrakerLog.getCause()+" opened menu.");
    }

    private void loadContentToScreen() {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        NewsfeedLayout fragment = new NewsfeedLayout();
        mNewsfeedLayout = new NewsfeedLayout();
        fragmentTransaction.add(R.id.outside_gym_layout_dynamic_table_row, mNewsfeedLayout, "news_feed");
        fragmentTransaction.commit();

//        mDesignatedRow.addView();


        // get newsfeed from server.
        // maybe use some TableRowBuilder class for this.
        TrakerLog.d(TrakerLog.getCause() + " loaded contentRow.");
    }

    private void clickMethod() {
        Toast.makeText(this, "should have been me!", Toast.LENGTH_SHORT).show();
    }

}
