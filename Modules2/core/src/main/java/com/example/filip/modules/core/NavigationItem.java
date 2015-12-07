package com.example.filip.modules.core;

import android.app.Fragment;

import com.example.filip.modules.db.Town;

import java.util.ArrayList;

/**
 * Created by Filip on 1.12.2015..
 */
public interface NavigationItem {
    public String getItemName();
    public int getPosition();
    public void setPosition(int position);
    public Fragment getFragment();
    public void loadData(ArrayList<Town> towns);
}
