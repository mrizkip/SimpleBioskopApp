package com.example.mrizk_000.simplebioskopapp.movieMenu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.mrizk_000.simplebioskopapp.R;
import com.example.mrizk_000.simplebioskopapp.api.callback.RepositoryCallback;
import com.example.mrizk_000.simplebioskopapp.api.repository.MovieDataSource;
import com.example.mrizk_000.simplebioskopapp.models.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NowShowingFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FrameLayout frameLayoutShow;
    private FrameLayout frameLayoutLoading;

    private List<Movie> movies;

    private MovieDataSource movieDataSource;

    public NowShowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_now_showing, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.nowShowing_recyclerView);
        frameLayoutLoading = (FrameLayout) view.findViewById(R.id.nowShowing_frameLoading);
        frameLayoutShow = (FrameLayout) view.findViewById(R.id.nowShowing_frameNowShowing);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        movieDataSource = new MovieDataSource();

        fetchMovieNowShow();
    }

    private void fetchMovieNowShow() {
        frameLayoutLoading.setVisibility(View.VISIBLE);
        frameLayoutShow.setVisibility(View.GONE);

        movies = new ArrayList<>();
        movieDataSource.getNowShowingMovies(new RepositoryCallback<List<Movie>>() {
            @Override
            public void onDataReceived(List<Movie> data) {
                if (data != null) {
                    frameLayoutShow.setVisibility(View.VISIBLE);
                    frameLayoutLoading.setVisibility(View.GONE);

                    movies.addAll(data);
                    Log.d("AddMovies", "success");

                    mAdapter = new NowShowingAdapter(getContext(), movies);
                    recyclerView.setAdapter(mAdapter);
                } else {
                    frameLayoutLoading.setVisibility(View.VISIBLE);
                    frameLayoutShow.setVisibility(View.GONE);
                    Log.d("AddMovies", "failed");
                }
            }
        });
    }
}
