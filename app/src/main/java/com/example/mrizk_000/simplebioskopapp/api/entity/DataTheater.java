package com.example.mrizk_000.simplebioskopapp.api.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public class DataTheater {

    @SerializedName("data")
    @Expose
    private List<TheaterRemote> theaterRemoteList = null;

    public List<TheaterRemote> getDataTheater() {
        return theaterRemoteList;
    }

    public void setDataTheater(List<TheaterRemote> data) {
        this.theaterRemoteList = data;
    }
}
