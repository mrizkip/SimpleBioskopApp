package com.example.mrizk_000.simplebioskopapp.api.mapper.Movie;

import com.example.mrizk_000.simplebioskopapp.api.entity.MovieRemote;
import com.example.mrizk_000.simplebioskopapp.api.mapper.BaseLayerDataTransformer;
import com.example.mrizk_000.simplebioskopapp.api.mapper.Theater.TheaterRemoteToTheater;
import com.example.mrizk_000.simplebioskopapp.models.Movie;
import com.example.mrizk_000.simplebioskopapp.models.Theater;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public class MovieRemoteToMovie extends BaseLayerDataTransformer<MovieRemote, Movie> {
    @Override
    public Movie transform(MovieRemote from) {
        Movie movie = new Movie();
        movie.setId(from.getId());
        movie.setName(from.getName());
        movie.setGenre(from.getGenre());
        movie.setDuration(from.getDuration());
        movie.setRelease(from.getReleaseYear());
        movie.setSynopsis(from.getSynopsis());
        movie.setTheater_id(from.getTheaterId());
        movie.setPlayDate(from.getPlayDate());
        TheaterRemoteToTheater theaterRemoteToTheaterMapper = new TheaterRemoteToTheater();
        Theater theater = theaterRemoteToTheaterMapper.transform(from.getTheaterDetail());
        movie.setTheaterDetail(theater);
        return movie;
    }
}
