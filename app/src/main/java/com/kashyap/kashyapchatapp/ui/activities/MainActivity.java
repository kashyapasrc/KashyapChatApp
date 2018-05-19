package com.kashyap.kashyapchatapp.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.kashyap.kashyapchatapp.R;
import com.kashyap.kashyapchatapp.ui.ViewPager.Pager;
import com.kashyap.kashyapchatapp.ui.fragments.calls.CallsContract;
import com.kashyap.kashyapchatapp.ui.fragments.calls.CallsFragment;
import com.kashyap.kashyapchatapp.ui.fragments.calls.CallsPresenter;
import com.kashyap.kashyapchatapp.ui.fragments.chats.ChatContract;
import com.kashyap.kashyapchatapp.ui.fragments.chats.ChatPresenter;
import com.kashyap.kashyapchatapp.ui.fragments.chats.ChatsFragment;
import com.kashyap.kashyapchatapp.ui.fragments.status.StatusContract;
import com.kashyap.kashyapchatapp.ui.fragments.status.StatusFragment;
import com.kashyap.kashyapchatapp.ui.fragments.status.StatusPresenter;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {


    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(this);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {
        Pager adapter = new Pager(getSupportFragmentManager(), 3);

        Fragment chatsFragment = new ChatsFragment();
        ChatContract.View chatView = (ChatContract.View) chatsFragment;
        chatView.setPresenter(new ChatPresenter(chatView));

        Fragment statusFragment = new StatusFragment();
        StatusContract.View statusView = (StatusContract.View) statusFragment;
        statusView.setPresenter(new StatusPresenter(statusView));

        Fragment callsFragment = new CallsFragment();
        CallsContract.View callsView = (CallsContract.View) callsFragment;
        callsView.setPresenter(new CallsPresenter(callsView));


        adapter.addFrag(chatsFragment, getString(R.string.tab_title_chats));
        adapter.addFrag(statusFragment,getString(R.string.tab_title_status));
        adapter.addFrag(callsFragment,getString(R.string.tab_title_calls));

        viewPager.setAdapter(adapter);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

//        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
