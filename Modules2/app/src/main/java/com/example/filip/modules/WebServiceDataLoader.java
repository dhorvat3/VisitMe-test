package com.example.filip.modules;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.filip.modules.core.DataLoader;
import com.example.filip.modules.core.JsonAdapter;
import com.example.filip.modules.db.Apartment;
import com.example.filip.modules.db.Town;
import com.example.filip.modules.ws.WebServiceAsyncTask;
import com.example.filip.modules.ws.WebServiceParams;
import com.example.filip.modules.ws.WebServiceResultHandler;


/**
 * Created by Filip on 6.12.2015..
 *
 *
 */



public class WebServiceDataLoader extends DataLoader {

    Activity activity = null;

    private boolean townsLoaded = false;
    private boolean apartmentsLoaded = false;



    public void LoadData(Activity activity){
        super.LoadData(activity);
        this.activity = activity;

        WebServiceAsyncTask at = new WebServiceAsyncTask();
        WebServiceParams params = new WebServiceParams();
        params.jsonParams = "";
        params.methodName = "getAll";
        params.serviceName = "towns";
        params.targetAttribute = "items";
        params.resultHandler = getAllTownsHandler;
        at.execute(new WebServiceParams[]{params});


        WebServiceAsyncTask at_apartments = new WebServiceAsyncTask();
        WebServiceParams params_apartments = new WebServiceParams();
        params_apartments.jsonParams = "";
        params_apartments.methodName = "getAll";
        params_apartments.serviceName = "apartments";
        params_apartments.targetAttribute = "items";
        params_apartments.resultHandler = getAllApartmentsHandler;
        at_apartments.execute(new WebServiceParams[]{params_apartments});

    }



    WebServiceResultHandler getAllTownsHandler = new WebServiceResultHandler() {
        @Override
        public void handleResult(String result, boolean ok, long timestamp) {
            if (ok)
            {
                try {
                    towns = JsonAdapter.getTowns(result);
                    for (Town t : towns) {
                        t.save();
                    }
                    Toast.makeText(activity, R.string.data_loaded_stores, Toast.LENGTH_SHORT).show();
                    townsLoaded = true;
                    showLoadedData();

                } catch (Exception e) {
                    Toast.makeText(activity, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    WebServiceResultHandler getAllApartmentsHandler = new WebServiceResultHandler() {
        @Override
        public void handleResult(String result, boolean ok, long timestamp) {
            if (ok)
            {
                try {
                    apartments = JsonAdapter.getApartments(result);
                    for (Apartment a : apartments) {
                        a.save();
                    }
                    Toast.makeText(activity, R.string.data_loaded_discounts, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(activity, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    };
    private void showLoadedData()
    {

        if (townsLoaded && apartmentsLoaded)
        {

            ApartmentsExpendableAdapter adapter= new ApartmentsExpendableAdapter(towns,apartments);
            adapter.setInflater(
                (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE), this.activity);

            ExpandableListView elv = (ExpandableListView)activity.findViewById(R.id.list);

            if (elv != null)
            {
                elv.setAdapter(adapter);
            }

            dataLoaded();

            //reset flags
            townsLoaded = false;
            apartmentsLoaded=false;

        }
    }


    private void bindApartmentsToTowns()
    {
        for (Town t: towns)
        {
            for (Apartment a: apartments)
            {
                if (t.getId_town() == a.getId_town())
                {
                    a.setTown(t);
                    a.save();
                }
            }
        }
    }


}
