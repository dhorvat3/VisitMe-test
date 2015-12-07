package com.example.filip.modules.loaders;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;


import com.example.filip.modules.core.DataLoader;
import com.example.filip.modules.core.JsonAdapter;
import com.example.filip.modules.db.Town;
import com.example.filip.modules.ws.WebServiceAsyncTask;
import com.example.filip.modules.ws.WebServiceParams;
import com.example.filip.modules.ws.WebServiceResultHandler;

/**
 * Created by Filip on 5.12.2015..
 */
public class WebServiceDataLoader extends DataLoader {
    Activity activity = null;
    private boolean townsLoaded = false;

    public  void  LoadData(Activity activity){
        super.LoadData(activity);
        this.activity=activity;

        WebServiceAsyncTask at = new WebServiceAsyncTask();
        WebServiceParams params = new WebServiceParams();
        params.jsonParams="";
        params.methodName="getAll";
        params.serviceName="towns";
        params.targetAttribute="items";
        params.resultHandler= getAllTownsHandler;
        at.execute(new WebServiceParams[]{params});

    }
    WebServiceResultHandler getAllTownsHandler = new WebServiceResultHandler() {
        @Override
        public void handleResult(String result, boolean ok, long timestamp) {
            if (ok)
            {
                try {
                    towns = JsonAdapter.getTowns(result);
                    for (Town t : towns){
                        t.save();
                    }
                    Toast.makeText(activity,"Towns loaded sucessfuly!", Toast.LENGTH_SHORT).show();
                    townsLoaded = true;
                    showLoadedData();

                }catch (Exception e){
                    Toast.makeText(activity, result, Toast.LENGTH_SHORT).show();
                }

            }
        }};


    private  void showLoadedData()
    {
        if (townsLoaded)
        {
            dataLoaded();
            townsLoaded=false;
        }
    }

}
