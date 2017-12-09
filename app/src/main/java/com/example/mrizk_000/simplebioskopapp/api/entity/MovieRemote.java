package com.example.mrizk_000.simplebioskopapp.api.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public class MovieRemote {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("theater_id")
    @Expose
    private Integer theaterId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("release_year")
    @Expose
    private Integer releaseYear;
    @SerializedName("theater_detail")
    @Expose
    private TheaterRemote theaterDetail;
    @SerializedName("play_date")
    @Expose
    private String playDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public TheaterRemote getTheaterDetail() {
        return theaterDetail;
    }

    public void setTheaterDetail(TheaterRemote theaterDetail) {
        this.theaterDetail = theaterDetail;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }
}
