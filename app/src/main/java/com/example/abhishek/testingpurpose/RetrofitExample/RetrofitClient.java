package com.example.abhishek.testingpurpose.RetrofitExample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    String BASE_URL = "https://simplifiedcoding.net/demos/";
    Retrofit retro;
    private static RetrofitClient mInstance;

    public RetrofitClient() {
        retro = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {

        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Api getApi() {
        Api ap = retro.create(Api.class);
        return ap;
    }

}
