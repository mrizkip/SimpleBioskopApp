package com.example.mrizk_000.simplebioskopapp.api.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public class DataMovie {
    @SerializedName("data")
    @Expose
    private List<MovieRemote> movieRemoteList = null;

    public List<MovieRemote> getDataMovie() {
        return movieRemoteList;
    }

    public void setData(List<MovieRemote> data) {
        this.movieRemoteList = data;
    }
}
