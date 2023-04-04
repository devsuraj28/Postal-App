package com.example.postalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.postalapp.Adapter.PostalcodeAdapter;
import com.example.postalapp.Interface.PostalCodeService;
import com.example.postalapp.Model.PostOffice;
import com.example.postalapp.Model.PostalCodeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.postalpincode.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostalCodeService postalCodeService = retrofit.create(PostalCodeService.class);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postalCodeService.getPostalCodes().enqueue(new Callback<List<PostalCodeResponse>>() {
            @Override
            public void onResponse(Call<List<PostalCodeResponse>> call, Response<List<PostalCodeResponse>> response) {
                List<PostalCodeResponse> postalCodeResponse = response.body();
                List<PostOffice> postOffices = postalCodeResponse.get(0).getPostOffices();

                recyclerView.setAdapter(new PostalcodeAdapter(postOffices,MainActivity.this));
            }

            @Override
            public void onFailure(Call<List<PostalCodeResponse>> call, Throwable t) {

            }
        });

    }
}