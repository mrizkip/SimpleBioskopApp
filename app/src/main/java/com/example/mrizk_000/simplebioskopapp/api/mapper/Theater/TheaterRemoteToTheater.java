package com.example.mrizk_000.simplebioskopapp.api.mapper.Theater;

import com.example.mrizk_000.simplebioskopapp.api.entity.TheaterRemote;
import com.example.mrizk_000.simplebioskopapp.api.mapper.BaseLayerDataTransformer;
import com.example.mrizk_000.simplebioskopapp.models.Theater;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public class TheaterRemoteToTheater extends BaseLayerDataTransformer<TheaterRemote, Theater> {
    @Override
    public Theater transform(TheaterRemote from) {
        Theater theater = new Theater();
        theater.setId(from.getId());
        theater.setName(from.getName());
        theater.setAddress(from.getAddress());
        theater.setDescription(from.getDescription());
        return theater;
    }
}
