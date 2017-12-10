package com.example.mrizk_000.simplebioskopapp.api.repository;

import com.example.mrizk_000.simplebioskopapp.api.callback.RepositoryCallback;
import com.example.mrizk_000.simplebioskopapp.api.entity.DataMovie;
import com.example.mrizk_000.simplebioskopapp.api.entity.MovieRemote;
import com.example.mrizk_000.simplebioskopapp.api.mapper.Movie.MovieRemoteToMovie;
import com.example.mrizk_000.simplebioskopapp.api.mapper.Theater.TheaterRemoteToTheater;
import com.example.mrizk_000.simplebioskopapp.models.Movie;
import com.example.mrizk_000.simplebioskopapp.repository.IMovieRepository;

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

public class MovieDataSource implements IMovieRepository {
    private RemoteMovieDataSource remoteMovieDataSource;
    private Retrofit builder;
    private MovieRemoteToMovie movieRemoteToMovieMapper;

    public MovieDataSource() {
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

        remoteMovieDataSource = builder.create(RemoteMovieDataSource.class);
        movieRemoteToMovieMapper= new MovieRemoteToMovie();
    }

    @Override
    public void getNowShowingMovies(final RepositoryCallback<List<Movie>> callback) {
        remoteMovieDataSource.nowShowing().enqueue(new Callback<DataMovie>() {
            @Override
            public void onResponse(Call<DataMovie> call, Response<DataMovie> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = new ArrayList<>();
                    List<MovieRemote> movieRemotes = new ArrayList<>();
                    for (MovieRemote movieRemote : movieRemotes) {
                        Movie movie = movieRemoteToMovieMapper.transform(movieRemote);
                        movies.add(movie);
                    }
                    callback.onDataReceived(movies);
                } else {
                    callback.onDataReceived(null);
                }
            }

            @Override
            public void onFailure(Call<DataMovie> call, Throwable t) {
                callback.onDataReceived(null);
            }
        });
    }

    @Override
    public void getUpcomingMovies(final RepositoryCallback<List<Movie>> callback) {
        remoteMovieDataSource.upcoming().enqueue(new Callback<DataMovie>() {
            @Override
            public void onResponse(Call<DataMovie> call, Response<DataMovie> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = new ArrayList<>();
                    List<MovieRemote> movieRemotes = new ArrayList<>();
                    for (MovieRemote movieRemote : movieRemotes) {
                        Movie movie = movieRemoteToMovieMapper.transform(movieRemote);
                        movies.add(movie);
                    }
                    callback.onDataReceived(movies);
                } else {
                    callback.onDataReceived(null);
                }
            }

            @Override
            public void onFailure(Call<DataMovie> call, Throwable t) {
                callback.onDataReceived(null);
            }
        });
    }
}
