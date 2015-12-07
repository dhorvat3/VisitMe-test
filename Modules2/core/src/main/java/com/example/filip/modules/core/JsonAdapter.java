package com.example.filip.modules.core;

/**
 * Created by Filip on 1.12.2015..
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.example.filip.modules.db.Apartment;
import com.example.filip.modules.db.Town;


public class JsonAdapter {


    public static ArrayList<Town> getTowns(String jsonString) {
        ArrayList<Town> towns = new ArrayList<Town>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            int size = jsonArray.length();

            for (int i = 0; i < size; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Town town = new Town(
                        jsonObject.getInt("id_town"),
                        jsonObject.getString("town_name")

                );
                towns.add(town);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return towns;
    }

    public static ArrayList<Apartment> getApartments(String jsonString) {
        ArrayList<Apartment> apartments = new ArrayList<Apartment>();
        try {
            JSONArray jsonArr = new JSONArray(jsonString);
            int size = jsonArr.length();

            for (int i = 0; i < size; i++) {
                JSONObject jsonObj = jsonArr.getJSONObject(i);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                Apartment apartment = new Apartment(
                        jsonObj.getInt("id_apartment"));

                        apartments.add(apartment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return apartments;
    }
}