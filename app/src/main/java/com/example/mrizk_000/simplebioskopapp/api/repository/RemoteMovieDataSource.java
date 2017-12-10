package com.example.mrizk_000.simplebioskopapp.api.repository;

import com.example.mrizk_000.simplebioskopapp.api.entity.DataMovie;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public interface RemoteMovieDataSource {

    @GET("movie/now")
    Call<DataMovie> nowShowing();

    @GET("movie/upcoming")
    Call<DataMovie> upcoming();
}
