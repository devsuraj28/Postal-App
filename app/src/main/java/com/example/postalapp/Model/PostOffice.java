package com.example.postalapp.Model;

import com.google.gson.annotations.SerializedName;

public class PostOffice {
    @SerializedName("Name")
    private String name;

    @SerializedName("Description")
    private String description;

    @SerializedName("Pincode")
    private String pincode;

    @SerializedName("District")
    private String district;

    @SerializedName("State")
    private String state;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPincode() {
        return pincode;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }
}
