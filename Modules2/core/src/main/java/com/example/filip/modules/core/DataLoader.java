package com.example.filip.modules.core;

import java.util.ArrayList;
import android.app.Activity;

import java.util.ArrayList;

import com.example.filip.modules.db.Apartment;
import com.example.filip.modules.db.Town;

/**
 * Created by Filip on 1.12.2015..
 */
public abstract class DataLoader {

    public ArrayList<Town> towns;
    public ArrayList<Apartment> apartments;
    OnDataLoadedListener dataLoadedListener;

    public void LoadData(Activity activity){
        if(dataLoadedListener == null)
            dataLoadedListener = (OnDataLoadedListener) activity;
    }
    public boolean dataLoaded(){
        if(towns == null){
            return false;
        }
        else{
            dataLoadedListener.onDataLoaded(towns);
            return true;
        }
    }
}
