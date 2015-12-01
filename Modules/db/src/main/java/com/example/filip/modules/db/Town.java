package com.example.filip.modules.db;

/**
 * Created by Filip on 1.12.2015..
 */
import android.graphics.AvoidXfermode;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;
public class Town extends Model{

    @Column(name = "id_town")
    private int id_town;

    @Column(name = "town_name", index = true)
    private String town_name;

    @Override
    public String toString() {
        return this.town_name;
    }

    public Town() {
        super();
    }

    public Town(int id_town, String town_name) {
        super();
        this.id_town = id_town;
        this.town_name = town_name;

    }

    public int getId_town() {
        return id_town;
    }


    public String getTown_name() {
        return town_name;
    }

    public void updateDiscount(Town updatedTown)
    {
        this.id_town = updatedTown.getId_town();
        this.town_name = updatedTown.getTown_name();


        this.save();
    }
}

