package com.example.mrizk_000.simplebioskopapp.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrizk_000 on 12/6/2017.
 */

public class Menu {
    String judul;
    String desc;

    public Menu() {
    }

    public Menu(String judul, String desc) {
        this.judul = judul;
        this.desc = desc;
    }



    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
