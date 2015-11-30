package com.foi.visitme.visitmetest.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davor on 30.11.2015..
 */
public class Town {

    @SerializedName("towns")
    @Expose
    private List<Town_> towns = new ArrayList<Town_>();

    /**
     *
     * @return
     * The towns
     */
    public List<Town_> getTowns() {
        return towns;
    }

    /**
     *
     * @param towns
     * The towns
     */
    public void setTowns(List<Town_> towns) {
        this.towns = towns;
    }
}
