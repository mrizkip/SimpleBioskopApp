package com.example.mrizk_000.simplebioskopapp.repository;

import com.example.mrizk_000.simplebioskopapp.api.callback.RepositoryCallback;
import com.example.mrizk_000.simplebioskopapp.models.Movie;

import java.util.List;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public interface IMovieRepository {
    void getNowShowingMovies(RepositoryCallback<List<Movie>> callback);
    void getUpcomingMovies(RepositoryCallback<List<Movie>> callback);
}
