package com.foi.visitme.visitmetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.foi.visitme.visitmetest.db.Apartment;
import com.foi.visitme.visitmetest.db.Apartments;
import com.foi.visitme.visitmetest.db.ApiMethods;
import com.foi.visitme.visitmetest.db.Town;
import com.foi.visitme.visitmetest.db.Town_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    private static final String API_URL = "http://domotehnika.hr/visitme/";
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
        ApiMethods apiMethods = restAdapter.create(ApiMethods.class);

        spinner = (Spinner) findViewById(R.id.town);

        apiMethods.getTowns(new Callback<Town>() {
            @Override
            public void success(Town town, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });

        apiMethods.getApartments("1", new Callback<Apartments>() {
            @Override
            public void success(Apartments apartments, Response response) {
                TextView ispis = (TextView) findViewById(R.id.ispis);
                //ispis.setText(apartments.getApartment().get(0).getApartmentName());
                String sApartment = "";

                for (Apartment apartment : apartments.getApartment()) {
                    sApartment += apartment.getApartmentName() + ", ";
                }
                ispis.setText(sApartment);

            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }


}
