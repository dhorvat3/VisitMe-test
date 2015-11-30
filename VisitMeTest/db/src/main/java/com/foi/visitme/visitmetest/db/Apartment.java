package com.foi.visitme.visitmetest.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Filip on 30.11.2015..
 */
public class Apartment {

    @SerializedName("apartment_name")
    @Expose
    private String apartmentName;
    @SerializedName("town_name")
    @Expose
    private String townName;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("free")
    @Expose
    private String free;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("long")
    @Expose
    private String _long;

    /**
     *
     * @return
     * The apartmentName
     */
    public String getApartmentName() {
        return apartmentName;
    }

    /**
     *
     * @param apartmentName
     * The apartment_name
     */
    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
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

    /**
     *
     * @return
     * The price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The free
     */
    public String getFree() {
        return free;
    }

    /**
     *
     * @param free
     * The free
     */
    public void setFree(String free) {
        this.free = free;
    }

    /**
     *
     * @return
     * The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The _long
     */
    public String getLong() {
        return _long;
    }

    /**
     *
     * @param _long
     * The long
     */
    public void setLong(String _long) {
        this._long = _long;
    }

}
