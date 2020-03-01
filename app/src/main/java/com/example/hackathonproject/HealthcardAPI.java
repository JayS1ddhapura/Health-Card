package com.example.hackathonproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HealthcardAPI {

    @GET("report/LR000002")
    Call<List<Post>> getLabReport();

    @GET("bill/MB000001")
    Call<List<Post>> getMedicine();

    @POST("patient/verify")
    Call<Post> verify(@Body Post post);

    @POST("patient/login")
    Call<Post> createPost(@Body Post post);

    @POST("patient")
    Call<Post> register (@Body Post post);

    @GET("patient/case/C000001")
    Call<List<Post>> getCase();

}
