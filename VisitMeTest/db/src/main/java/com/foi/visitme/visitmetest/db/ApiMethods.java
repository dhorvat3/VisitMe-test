package com.foi.visitme.visitmetest.db;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Filip on 30.11.2015..
 */
public interface ApiMethods {

    //LOGIN
    @GET("/apartments_in_town.php")
    public void getApartments(@Query("id_town") String id_town, Callback<Apartments> callback);

    @GET("/towns.php")
    void getTowns(Callback<Town> callback);

//    REGISTER
//    @POST("/post_user.php")
//    void setUser(@Body User_ user, Callback<Response> callback);
}
