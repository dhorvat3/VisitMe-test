package com.example.filip.modules;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filip.modules.db.Apartment;
import com.example.filip.modules.db.Town;

import java.util.ArrayList;

/**
 * Created by Filip on 6.12.2015..
 */
public class ApartmentsExpendableAdapter extends BaseExpandableListAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<Town> parentItems;
    private ArrayList<Apartment> childItems;



    public ApartmentsExpendableAdapter(ArrayList<Town> towns,
                                       ArrayList<Apartment> apartments)
    {
        this.parentItems = towns;
        this.childItems = apartments;
    }

    public void setInflater(LayoutInflater inflater, Activity activity)
    {
        this.activity = activity;
        this.inflater = inflater;
    }
    @Override
    public int getGroupCount() {
        if (parentItems == null)
            return 0;
        else
            return parentItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        int size = 0;
        for (Apartment apartment : childItems)
        {
            if (apartment.getId_town() ==
                    parentItems.get(groupPosition).getId_town())
            {
                size++;
            }
        }
        return size;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentItems.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childItems.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return ((Town)getGroup(groupPosition)).getId_town();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return ((Apartment)getChild(groupPosition, childPosition)).getId_apartment();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // to be added
        return null;
    }




    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.towns, null);

        TextView nameView = null;


        nameView = (TextView)convertView.findViewById(R.id.town_name);


        nameView.setText(((Town) getGroup(groupPosition)).getTown_name());

        //imageView... - Homework. Check possible solutions at: http://tiny.cc/air2015vj4hs


        return convertView;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}