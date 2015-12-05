package com.example.filip.modules.core;

/**
 * Created by Filip on 1.12.2015..
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
}