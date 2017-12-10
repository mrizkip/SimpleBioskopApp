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
public class ComingSoonFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FrameLayout frameLayoutShow;
    private FrameLayout frameLayoutLoading;

    private List<Movie> movies;

    private MovieDataSource movieDataSource;

    public ComingSoonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_coming_soon, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.comingSoon_recyclerView);
        frameLayoutLoading = (FrameLayout) view.findViewById(R.id.comingSoon_frameLoading);
        frameLayoutShow = (FrameLayout) view.findViewById(R.id.comingSoon_frameShow);

        // set RecyclerView layout manager
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        movieDataSource = new MovieDataSource();

        fetchMovieComingSoon();
    }

    private void fetchMovieComingSoon() {
        frameLayoutLoading.setVisibility(View.VISIBLE);
        frameLayoutShow.setVisibility(View.GONE);

        movies = new ArrayList<>();
        // get UpcomingMovies from remote
        movieDataSource.getUpcomingMovies(new RepositoryCallback<List<Movie>>() {
            @Override
            public void onDataReceived(List<Movie> data) {
                if (data != null) {
                    frameLayoutLoading.setVisibility(View.GONE);
                    frameLayoutShow.setVisibility(View.VISIBLE);

                    movies.addAll(data);

                    mAdapter = new ComingSoonAdapter(getContext(), movies);
                    recyclerView.setAdapter(mAdapter);
                } else {
                    frameLayoutShow.setVisibility(View.GONE);
                    frameLayoutLoading.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
