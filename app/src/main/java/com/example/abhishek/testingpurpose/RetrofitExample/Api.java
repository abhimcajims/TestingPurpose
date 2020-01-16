package com.example.abhishek.testingpurpose.RetrofitExample;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {


    @FormUrlEncoded
    @POST("marvel")
    Call<List<Hero>> getHeroes(
            @Field("name") String name,
            @Field("list") ArrayList<String> list);




}
