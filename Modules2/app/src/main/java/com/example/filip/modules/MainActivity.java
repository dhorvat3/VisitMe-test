package com.example.filip.modules;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;


import com.activeandroid.ActiveAndroid;
import com.example.filip.modules.core.DataLoader;
import com.example.filip.modules.db.Apartment;
import com.example.filip.modules.db.Town;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActiveAndroid.initialize(this);
        setContentView(R.layout.activity_main);

        DataLoader dataLoader = new WebServiceDataLoader();
        dataLoader.LoadData(this);

    }


}
