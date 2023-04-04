package com.example.postalapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostalCodeResponse {
    @SerializedName("PostOffice")
    private List<PostOffice> postOffices;

    public List<PostOffice> getPostOffices() {
        return postOffices;
    }



}

