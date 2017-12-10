package com.example.mrizk_000.simplebioskopapp.models;

/**
 * Created by mrizk_000 on 12/7/2017.
 */

public class Movie {
    private int id;
    private int theater_id;
    private String name;
    private String synopsis;
    private int duration;
    private String genre;
    private int release;
    private String playDate;
    private Theater theaterDetail;

    public Movie() {
    }

    public Movie(int id, int theater_id, String name, String synopsis, int duration, String genre, int release) {
        this.id = id;
        this.theater_id = theater_id;
        this.name = name;
        this.synopsis = synopsis;
        this.duration = duration;
        this.genre = genre;
        this.release = release;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }

    public Theater getTheaterDetail() {
        return theaterDetail;
    }

    public void setTheaterDetail(Theater theaterDetail) {
        this.theaterDetail = theaterDetail;
    }
}
