package com.example.mrizk_000.simplebioskopapp.theaterMenu;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.mrizk_000.simplebioskopapp.R;
import com.example.mrizk_000.simplebioskopapp.api.callback.RepositoryCallback;
import com.example.mrizk_000.simplebioskopapp.api.repository.TheaterDataSource;
import com.example.mrizk_000.simplebioskopapp.models.Theater;

import java.util.ArrayList;
import java.util.List;

public class TheaterActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FrameLayout frameLayoutLoading;
    private FrameLayout frameLayoutShow;

    private List<Theater> theaters;
    private TheaterDataSource theaterDataSource;

    Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);

        recyclerView = (RecyclerView) findViewById(R.id.theater_recyclerView);
        toolbar = (Toolbar) findViewById(R.id.theater_toolbar);
        frameLayoutLoading = (FrameLayout) findViewById(R.id.theater_frameLoading);
        frameLayoutShow = (FrameLayout) findViewById(R.id.theater_frameTheater);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) actionBar = getSupportActionBar();

        if(savedInstanceState == null) {
            actionBar.setTitle("Daftar Semua Bioskop");
        }
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Configuring RecyclerView LayoutManager
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        theaterDataSource = new TheaterDataSource();

        fetchTheaters();
    }

    private void fetchTheaters() {
        frameLayoutLoading.setVisibility(View.VISIBLE);
        frameLayoutShow.setVisibility(View.GONE);

        theaters = new ArrayList<>();
        // get Theater from remote
        theaterDataSource.getTheater(new RepositoryCallback<List<Theater>>() {
            @Override
            public void onDataReceived(List<Theater> data) {
                if (data != null) {
                    frameLayoutShow.setVisibility(View.VISIBLE);
                    frameLayoutLoading.setVisibility(View.GONE);
                    theaters.addAll(data);

                    mAdapter = new TheaterAdapter(getBaseContext(), theaters);
                    recyclerView.setAdapter(mAdapter);

                } else {
                    frameLayoutShow.setVisibility(View.VISIBLE);
                    frameLayoutLoading.setVisibility(View.GONE);
                }
            }
        });


    }

    // Add back button on Actionbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
