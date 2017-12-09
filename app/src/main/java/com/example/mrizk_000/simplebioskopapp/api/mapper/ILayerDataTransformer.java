package com.example.mrizk_000.simplebioskopapp.api.mapper;

import java.util.Collection;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public interface ILayerDataTransformer<F, T> {
    T transform(F from);

    Collection<T> transform(Collection<F> from);
}
