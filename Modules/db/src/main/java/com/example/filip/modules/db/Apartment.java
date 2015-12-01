package com.example.filip.modules.db;

/**
 * Created by Filip on 1.12.2015..
 */

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

public class Apartment extends Model{

    @Column(name="id_apartment")
    private int id_apartment;

}
