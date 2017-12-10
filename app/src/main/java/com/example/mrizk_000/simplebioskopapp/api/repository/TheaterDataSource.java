package com.example.mrizk_000.simplebioskopapp.api.repository;

import com.example.mrizk_000.simplebioskopapp.api.callback.RepositoryCallback;
import com.example.mrizk_000.simplebioskopapp.api.entity.DataTheater;
import com.example.mrizk_000.simplebioskopapp.api.entity.TheaterRemote;
import com.example.mrizk_000.simplebioskopapp.api.mapper.Theater.TheaterRemoteToTheater;
import com.example.mrizk_000.simplebioskopapp.models.Theater;
import com.example.mrizk_000.simplebioskopapp.repository.ITheaterRepository;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public class TheaterDataSource implements ITheaterRepository {

    private RemoteTheaterDataSource remoteTheaterDataSource;
    private Retrofit builder;
    private TheaterRemoteToTheater theaterRemoteToTheaterMapper;

    public TheaterDataSource() {
        // Create retrofit builder
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(interceptor);
        okHttpClient.build();
        builder = new Retrofit.Builder()
                .baseUrl("https://arcane-fjord-39035.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build();

        remoteTheaterDataSource = builder.create(RemoteTheaterDataSource.class);
        theaterRemoteToTheaterMapper = new TheaterRemoteToTheater();
    }

    // Get Theaters from remote
    @Override
    public void getTheater(final RepositoryCallback<List<Theater>> callback) {
        remoteTheaterDataSource.theaters().enqueue(new Callback<DataTheater>() {
            @Override
            public void onResponse(Call<DataTheater> call, Response<DataTheater> response) {
                // jika respon berhasil
                if (response.isSuccessful()) {
                    List<Theater> theaters = new ArrayList<>();
                    List<TheaterRemote> theaterRemotes = response.body().getDataTheater();
                    // merubah TheaterRemote menjadi Theater
                    for (TheaterRemote theaterRemote : theaterRemotes) {
                        Theater theater = theaterRemoteToTheaterMapper.transform(theaterRemote);
                        theaters.add(theater);
                    }
                    callback.onDataReceived(theaters);
                } else {
                    callback.onDataReceived(null);
                }
            }

            @Override
            public void onFailure(Call<DataTheater> call, Throwable t) {
                callback.onDataReceived(null);
            }
        });
    }
}
