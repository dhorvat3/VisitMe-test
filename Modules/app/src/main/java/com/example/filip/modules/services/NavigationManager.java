package com.example.filip.modules.services;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.example.filip.modules.R;
import com.example.filip.modules.core.NavigationItem;
import com.example.filip.modules.db.Town;

import java.util.ArrayList;

/**
 * Created by Filip on 5.12.2015..
 */
public class NavigationManager {
    public ArrayList<NavigationItem> navigationItems;
    private  static  NavigationManager instance;
    private Activity mHandlerActivity;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private NavigationItem activeItem;

    private  ArrayList<Town> towns;

    private NavigationManager(){ navigationItems = new ArrayList<NavigationItem>();}
    public  static  NavigationManager getInstance(){
        if(instance==null)
            instance= new NavigationManager();
        return  instance;
    }

    public  ArrayList<String> getNavigationItemsAsStrings(){
        ArrayList<String> navigationItemStrings = new ArrayList<>();
        for (NavigationItem item : navigationItems){
            navigationItemStrings.add(item.getItemName());
        }return navigationItemStrings;
    }

    public void setDependencies(Activity mHandlerActivity,DrawerLayout drawerLayout, NavigationView navigationView){
        this.mHandlerActivity=mHandlerActivity;
        this.mNavigationView=navigationView;
        this.mDrawerLayout=drawerLayout;

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                selectItem(menuItem);
                return true;
            }
        });

    }
    private  void selectItem(MenuItem menuItem){

        NavigationItem clickedItem = navigationItems.get(menuItem.getItemId());
        FragmentManager fragmentManager = mHandlerActivity.getFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, clickedItem.getFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("")
                .commit();
        clickedItem.loadData(towns);
        menuItem.setChecked(true);
        mDrawerLayout.closeDrawer(GravityCompat.START);


    }

    public void addItem(NavigationItem newItem) {
        newItem.setPosition(navigationItems.size());
        navigationItems.add(newItem);
        mNavigationView.getMenu().add(0, newItem.getPosition(), 0, newItem.getItemName());
    }
    public void loadDefaultFragment() {
        activeItem =navigationItems.get(0);
        FragmentManager fragmentManager = mHandlerActivity.getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, activeItem.getFragment())
                .commit();
    }
    public void makeDataChange(ArrayList<Town> stores){
        this.towns = towns;

        activeItem.loadData(towns);
    }
}
