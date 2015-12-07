package com.example.filip.modules.core;

import com.example.filip.modules.db.Town;

import java.util.ArrayList;

/**
 * Created by Filip on 1.12.2015..
 */


public interface OnDataLoadedListener {
    public void onDataLoaded(ArrayList<Town> towns);
}
