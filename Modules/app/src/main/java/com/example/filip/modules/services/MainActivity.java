package com.example.filip.modules.services;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.filip.modules.R;
import com.example.filip.modules.core.DataLoader;
import com.example.filip.modules.core.JsonAdapter;
import com.example.filip.modules.db.Town;
import com.example.filip.modules.fragments.ApartmentListFragment;
import com.example.filip.modules.core.OnDataLoadedListener;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar mToolbar; // from android.support.v7.widget.Toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentManager mFm;
    NavigationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);




        View.OnClickListener navigationClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getFragmentManager().getBackStackEntryCount() == 0) {
                    mDrawer.openDrawer(GravityCompat.START);
                }
                else{
                    onBackPressed();
                }
            }
        };
    }

}