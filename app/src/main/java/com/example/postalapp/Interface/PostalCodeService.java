package com.example.postalapp.Interface;

import com.example.postalapp.Model.PostalCodeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostalCodeService {
    @GET("postoffice/Kanpur")
    Call<List<PostalCodeResponse>> getPostalCodes();
}
