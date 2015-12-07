package com.example.filip.modules.db;

/**
 * Created by Filip on 1.12.2015..
 */
import android.graphics.AvoidXfermode;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;
public class Apartment extends Model{

    @Column(name = "id_apartment")
    private int id_apartment;

    @Column(name = "apartment_name", index = true)
    private String apartment_name;

    @Column(name = "id_town", index = true)
    private int id_town;


    @Override
    public String toString() {
        return this.apartment_name;
    }
    @Column(name = "town")
    private Town town;

    public Apartment(int id_apartment) {
        super();
    }

    public Apartment(int id_apartment, String apartment_name, int id_town) {
        super();
        this.id_apartment= id_apartment;
        this.apartment_name = apartment_name;
        this.id_town= id_town;

    }

    public int getId_apartment() {
        return id_apartment;
    }

    public int getId_town() {
        return id_town;
    }


    public String getApartment_name() {
        return apartment_name;
    }



    public void updateApartment(Apartment updatedApartment)
    {
        this.id_apartment = updatedApartment.getId_apartment();
        this.apartment_name=updatedApartment.getApartment_name();
        this.id_town=updatedApartment.getId_town();
        this.save();
    }
    public void setTown(Town t) {
        this.town = t;
    }

}
