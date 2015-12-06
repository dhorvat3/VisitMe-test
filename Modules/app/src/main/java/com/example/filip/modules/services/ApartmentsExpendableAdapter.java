package com.example.filip.modules.services;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.BaseExpandableListAdapter;

import com.example.filip.modules.db.Town;

import java.util.ArrayList;

/**
 * Created by Filip on 6.12.2015..
 */
public abstract class ApartmentsExpendableAdapter extends BaseExpandableListAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<Town> parentItems;


}
