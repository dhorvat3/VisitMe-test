package com.foi.visitme.visitmetest.db;

/**
 * Created by Filip on 30.11.2015..
 */




        import java.util.ArrayList;
        import java.util.List;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;


public class Apartments {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("apartment")
    @Expose
    private List<Apartment> apartment = new ArrayList<Apartment>();

    /**
     *
     * @return
     * The success
     */
    public Integer getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Integer success) {
        this.success = success;
    }

    /**
     *
     * @return
     * The apartment
     */
    public List<Apartment> getApartment() {
        return apartment;
    }

    /**
     *
     * @param apartment
     * The apartment
     */
    public void setApartment(List<Apartment> apartment) {
        this.apartment = apartment;
    }

}




