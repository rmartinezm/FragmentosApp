package com.programacion.robertomtz.fragmentosapp;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ViewPagerActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_pager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** FRAGMENTS **/
    public static class TimelineFragment extends Fragment {

        public TimelineFragment() {}

        public static TimelineFragment newInstance() {
            return new TimelineFragment();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.list_fragment_timeline, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.list_item_fragment);
            TimelineAdapter adapter = new TimelineAdapter(MainActivity.timeline.getHistorias(), rootView.getContext());

            listView.setAdapter(adapter);
            return rootView;
        }
    }

    public static class BussinesFragment extends Fragment{
        public BussinesFragment() {}

        public static BussinesFragment newInstance(){
            return new BussinesFragment();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.list_fragment_bussines, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.list_item_bussines);
            BussinesAdapter adapter = new BussinesAdapter(MainActivity.negocios.getNegocios(), rootView.getContext());

            listView.setAdapter(adapter);
            return rootView;
        }
    }

    /** ADAPTADOR **/
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case (0):
                    return TimelineFragment.newInstance();
                case (1):
                    return BussinesFragment.newInstance();
            }
            return TimelineFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "TIMELINE";
                case 1:
                    return "NEGOCIOS";
                case 2:
                    return "Fragment 3";
            }
            return null;
        }
    }
}
