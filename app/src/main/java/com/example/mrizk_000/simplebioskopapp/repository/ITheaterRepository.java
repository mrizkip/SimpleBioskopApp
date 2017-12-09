package com.example.mrizk_000.simplebioskopapp.repository;

import com.example.mrizk_000.simplebioskopapp.api.callback.RepositoryCallback;
import com.example.mrizk_000.simplebioskopapp.models.Theater;

import java.util.List;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public interface ITheaterRepository {
    void getTheater(RepositoryCallback<List<Theater>> callback);
}
