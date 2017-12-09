package com.example.mrizk_000.simplebioskopapp.api.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public abstract class BaseLayerDataTransformer<F, T> implements ILayerDataTransformer<F, T> {

    @Override
    public List<T> transform(Collection<F> from) {
        List<T> transformed = new ArrayList<>(from.size());

        for (F fromObject : from) {
            transformed.add(transform(fromObject));
        }
        return transformed;
    }
}
