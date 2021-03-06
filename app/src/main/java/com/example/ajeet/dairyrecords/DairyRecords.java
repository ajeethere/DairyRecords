package com.example.ajeet.dairyrecords;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class DairyRecords extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    LinearLayout linearLayout;
    DairyDBHelper dairyDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_records);
        dairyDBHelper=new DairyDBHelper(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        linearLayout= (LinearLayout)findViewById(R.id.list_view_layout_main_activity);
        setSupportActionBar(toolbar);

        final FrameLayout frameLayout=(FrameLayout)findViewById(R.id.fram_layout_main_activity);
        android.support.v4.app.Fragment fragment=null;
        Class fragmentClass=null;
        fragmentClass=WelcomeFragment.class;
        try {
            fragment= (android.support.v4.app.Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment!=null){
            android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fram_layout_main_activity,fragment);
            ft.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header =navigationView.getHeaderView(0);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                android.support.v4.app.Fragment fragment=null;
                Class fragmentClass=null;
                fragmentClass=WelcomeFragment.class;
                try {
                    fragment= (android.support.v4.app.Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (fragment!=null){
                    android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fram_layout_main_activity,fragment);
                    ft.commit();

                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_add_new_buyer) {
            android.support.v4.app.Fragment fragment=null;
            Class fragmentClass=null;
            fragmentClass=NewBuyerFragment.class;
            try {
                fragment= (android.support.v4.app.Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fragment!=null){
                String backStateName = fragment.getClass().getName();
                android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fram_layout_main_activity,fragment);
                ft.addToBackStack(backStateName);
                ft.commit();

            }



        } else if (id == R.id.nav_unpaid_orders) {

            android.support.v4.app.Fragment fragment=null;
            Class fragmentClass=null;
            fragmentClass=UnpaidFragment.class;
            try {
                fragment= (android.support.v4.app.Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fragment!=null){
                String backStateName = fragment.getClass().getName();
                android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fram_layout_main_activity,fragment);
                ft.addToBackStack(backStateName);
                ft.commit();

            }
        } else if (id == R.id.nav_paid_orders) {
            android.support.v4.app.Fragment fragment=null;
            Class fragmentClass=null;
            fragmentClass=PaidOrderFragment.class;
            try {
                fragment= (android.support.v4.app.Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fragment!=null){
                String backStateName = fragment.getClass().getName();
                android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fram_layout_main_activity,fragment);
                ft.addToBackStack(backStateName);
                ft.commit();

            }

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
