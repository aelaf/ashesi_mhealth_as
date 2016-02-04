package com.ashesi.cs.mhealth;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;

import com.ashesi.cs.mhealth.data.R;

import java.util.Locale;

/**
 * Created by deincrediblelowkey on 04/02/16.
 */
public class ChildWelfareRecordActivity extends FragmentActivity implements ActionBar.TabListener{
    ViewPager myViewPager;
    CollectionPagerAdapter mCollectionPagerAdapter;

    int communityMemberId=0;
    int communityId;
    int state=0;
    int choId=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_record);

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mCollectionPagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        myViewPager = (ViewPager) findViewById(R.id.mypager);
        myViewPager.setAdapter(mCollectionPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        myViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        Intent intent = getIntent();
        communityId = intent.getIntExtra("communityId", 0);
        choId = intent.getIntExtra("choId", 0);
        state = intent.getIntExtra("state", 1);
        communityMemberId = intent.getIntExtra("id", 0);

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mCollectionPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(actionBar.newTab().setText(mCollectionPagerAdapter.getPageTitle(i)).setTabListener(this));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.community_member_record, menu);
        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab,FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        myViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab,FragmentTransaction fragmentTransaction) {
    }



    public int getCommunityId(){
        return this.communityId;
    }
    /**
     * use this method to set community id if it changes in the fragments
     * @param id
     */
    public void setCommunityId(int id){
        this.communityId=id;
    }
    /**
     * use this method to set state if it changes in the fragments
     * @param state
     */
    public void setState(int state){
        this.state=state;
    }
    /**
     * get state as stored in the activity
     * @return
     */
    public int getState(){
        return this.state;
    }

    /**
     * use this method to set community member id if it changes in the fragments
     * @param id
     */
    public void setCommunityMemberId(int id){
        this.communityMemberId=id;
    }
    /**
     * get the community member stored in the activity
     * @return
     */
    public int getCommunityMemberId(){
        return this.communityMemberId;//TODO: id change
    }




// Since this is an object collection, use a FragmentStatePagerAdapter,
    // and NOT a FragmentPagerAdapter.

    public class CollectionPagerAdapter extends FragmentPagerAdapter {

        public CollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a DummySectionFragment (defined as a static inner class
            // below) with the page number as its lone argument.

            Fragment fragment = null;
            if (position == 0) {
                fragment = new MainSectionFragment();
            } else if (position == 1) {
                //fragment = new OPDFragment();
            } else if (position == 2) {
                //fragment = new VaccineFragment();
            } else if (position == 3) {
                //fragment = new FamilyPlanFragment();
            } else {
                fragment = new MainSectionFragment(); //default
            }

            Bundle args = new Bundle();
            args.putInt("state", state);
            args.putInt("id", communityMemberId);
            args.putInt("communityId", communityId);
            args.putInt("choId", choId);

            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_cm_record_main).toUpperCase(l);
                case 1:
                    return getString(R.string.title_cm_record_other).toUpperCase(l);
                case 2:
                    return getString(R.string.title_cm_record_vaccine).toUpperCase(l);
                case 3:
                    return "Family Planning";
            }
            return null;
        }
    }

    public static class MainSectionFragment extends Fragment implements DatePicker.OnDateChangedListener, View.OnClickListener, AdapterView.OnItemSelectedListener, View.OnFocusChangeListener {

        private int state=0;
        private int communityMemberId=0;//TODO: id change
        private int communityId;

        private View rootView;
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";

        public MainSectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_children_record, container, false);

            //TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
            //dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));

            communityMemberId = getArguments().getInt("id");
            state = getArguments().getInt("state");
            communityId = getArguments().getInt("communityId");
            this.rootView = rootView;
            //create();
            return rootView;
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onItemSelected(AdapterView<?> arg0, View v, int arg2, long arg3) {
            if (arg0.getId() == R.id.spinnerCommunityMemberAgeUnits) {
                // computeBirthdate();
            }

        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {

        }
    }
}
