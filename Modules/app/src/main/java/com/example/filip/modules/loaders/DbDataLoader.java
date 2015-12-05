package com.example.filip.modules.loaders;
import android.app.Activity;
import android.widget.Toast;

import com.activeandroid.query.Select;

import com.example.filip.modules.core.DataLoader;
import com.example.filip.modules.db.Town;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 5.12.2015..
 */
public class DbDataLoader extends DataLoader {
    @Override
    public void LoadData(Activity activity) {
        super.LoadData(activity);

        List<Town> townsFromDb = null;

        boolean databaseQuerySuccessful = false;

        try {
            townsFromDb = new Select().all().from(Town.class).execute();

            databaseQuerySuccessful=true;

        }catch (NullPointerException e){

            e.printStackTrace();
        }
        if(databaseQuerySuccessful == true && townsFromDb.size() > 0 ){
            Toast.makeText(activity,"Loading data forom database", Toast.LENGTH_SHORT).show();

            towns = (ArrayList<Town>) townsFromDb;


            dataLoaded();
        }
    }

}