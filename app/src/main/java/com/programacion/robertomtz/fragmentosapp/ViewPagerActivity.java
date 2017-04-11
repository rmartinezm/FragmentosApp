package com.programacion.robertomtz.fragmentosapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

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

        if (id == R.id.github_rmartinezm) {
            String urlGit = "https://github.com/rmartinezm/FragmentosApp";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlGit));
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
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
            View rootView = inflater.inflate(R.layout.list_fragment_business, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.list_item_bussines);

            BusinessAdapter adapter = new BusinessAdapter(MainActivity.negocios.getNegocios(), rootView.getContext());

            listView.setAdapter(adapter);
            return rootView;
        }
    }

    public static class PreferenciasFragment extends Fragment {

        private EditText user;
        private EditText pass;
        private Switch aSwitch;

        public PreferenciasFragment() {}

        public static PreferenciasFragment newInstance() {
            return new PreferenciasFragment();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.preferencias_fragment, container, false);

            user = (EditText) rootView.findViewById(R.id.preferencias_et_nombre);
            pass = (EditText) rootView.findViewById(R.id.preferencias_et_password);
            aSwitch = (Switch) rootView.findViewById(R.id.preferencias_switch);

            // Tomamos las preferencias
            SharedPreferences sp = rootView.getContext().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
            aSwitch.setChecked(sp.getBoolean("switch", false));
            user.setText(sp.getString("user", ""));
            pass.setText(sp.getString("pass", ""));
            return rootView;
        }

        @Override
        public void onStart() {
            SharedPreferences sp = getContext().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
            aSwitch.setChecked(sp.getBoolean("switch", false));
            user.setText(sp.getString("user", ""));
            pass.setText(sp.getString("pass", ""));
            user.requestFocus();
            super.onStart();
        }

        @Override
        public void onStop() {
            SharedPreferences sp = getContext().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            if (aSwitch.isChecked()){
                editor.putBoolean("switch",aSwitch.isChecked());
                editor.putString("user", user.getText().toString());
                editor.putString("pass", pass.getText().toString());
            }else {
                editor.putBoolean("switch", false);
                editor.putString("user", "");
                editor.putString("pass", "");
            }
            editor.apply();
            editor.commit();
            super.onStop();
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
                case (2):
                    return PreferenciasFragment.newInstance();
                default:
                    return TimelineFragment.newInstance();
            }
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
                    return "PREFERENCIAS";
            }
            return null;
        }
    }
}
