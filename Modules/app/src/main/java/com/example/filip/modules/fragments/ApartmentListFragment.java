package com.example.filip.modules.fragments;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import  com.example.filip.modules.R;
import  com.example.filip.modules.core.DataLoader;
import  com.example.filip.modules.core.NavigationItem;
import  com.example.filip.modules.db.Town;
import  com.example.filip.modules.loaders.DbDataLoader;
import  com.example.filip.modules.loaders.WebServiceDataLoader;


import java.util.ArrayList;

/**
 * Created by Filip on 5.12.2015..
 */
public abstract class ApartmentListFragment extends Fragment implements NavigationItem {
    private  int position;
    private  String name = "Apartment List";
    private boolean mAlereadyLoaded = false;
    private ArrayList<Town> towns;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.apartment_list_fragment, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState == null && !mAlereadyLoaded){
            mAlereadyLoaded = true;
            // load data from database
            DataLoader dl = new DbDataLoader();
            dl.LoadData(getActivity());

            //if no data loaded, call ws if allowed
            if(!dl.dataLoaded()){
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                if(preferences.getBoolean("pref_allow_web", true)){
                    dl = new WebServiceDataLoader();
                    dl.LoadData(getActivity());
                }
                else{
                    Toast.makeText(getActivity(), "Local database is empty. Get from web disabled.", Toast.LENGTH_LONG).show();
                }
            }

        } else {
            loadData(towns);
        }
    }
    @Override
    public  String getItemName(){
        return name;
    }
    @Override
    public int getPosition() {
        return position;
    }


    @Override
    public void setPosition(int position) {
        this.position = position;
    }


    @Override
    public Fragment getFragment() {
        return this;
    }
    @Override
    public void loadData(ArrayList<Town> towns) {

    }
}
