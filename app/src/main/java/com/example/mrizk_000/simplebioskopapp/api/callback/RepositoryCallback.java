package com.example.mrizk_000.simplebioskopapp.api.callback;

/**
 * Created by mrizk_000 on 12/9/2017.
 */

public interface RepositoryCallback<T> {
    void onDataReceived(T data);
}
