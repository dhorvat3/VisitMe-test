package com.foi.visitme.visitmetest.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by davor on 30.11.2015..
 */
public class Town_ {
    @SerializedName("town_name")
    @Expose
    private String townName;

    @SerializedName("id_town")
    @Expose
    private String idTown;

    public String getIdTown(){
        return idTown;
    }

    public void setIdTown(String id){
        this.idTown = id;
    }

    /**
     *
     * @return
     * The townName
     */
    public String getTownName() {
        return townName;
    }

    /**
     *
     * @param townName
     * The town_name
     */
    public void setTownName(String townName) {
        this.townName = townName;
    }
}
