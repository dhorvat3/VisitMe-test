package com.foi.visitme.visitmetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.foi.visitme.visitmetest.db.Apartments;
import com.foi.visitme.visitmetest.db.ApiMethods;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    private static final String API_URL = "http://domotehnika.hr/visitme/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
        ApiMethods apiMethods = restAdapter.create(ApiMethods.class);

        apiMethods.getApartments("1", new Callback<Apartments>() {
            @Override
            public void success(Apartments apartments, Response response) {
                TextView ispis=(TextView) findViewById(R.id.ispis);
                ispis.setText(apartments.getApartment().get(0).getApartmentName());

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


}
