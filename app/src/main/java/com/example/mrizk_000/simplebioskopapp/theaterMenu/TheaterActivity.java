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
import com.example.mrizk_000.simplebioskopapp.api.repository.RemoteTheaterDataSource;
import com.example.mrizk_000.simplebioskopapp.api.repository.TheaterDataSource;
import com.example.mrizk_000.simplebioskopapp.models.Theater;
import com.example.mrizk_000.simplebioskopapp.repository.ITheaterRepository;

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

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        theaterDataSource = new TheaterDataSource();

//        theaters = new ArrayList<>();
//        theaters.add(new Theater(1, "Bioskop 21", "Jl. Malang", "Bioskop Keren"));
//        theaters.add(new Theater(2, "Bioskop Cinemaxx", "Jl. Malang", "Bioskop Keren"));

        fetchTheaters();
    }

    private void fetchTheaters() {
//        final ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMax(100);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Mengambil data Bioskop dari server...");
//        progressDialog.show();
        frameLayoutLoading.setVisibility(View.VISIBLE);
        frameLayoutShow.setVisibility(View.GONE);

        theaters = new ArrayList<>();
        theaterDataSource.getTheater(new RepositoryCallback<List<Theater>>() {
            @Override
            public void onDataReceived(List<Theater> data) {
                if (data != null) {
                    frameLayoutShow.setVisibility(View.VISIBLE);
                    frameLayoutLoading.setVisibility(View.GONE);
                    theaters.addAll(data);

                    Log.d("AddTheater,", "fetch success");
//                    progressDialog.dismiss();

                    mAdapter = new TheaterAdapter(getBaseContext(), theaters);
                    recyclerView.setAdapter(mAdapter);

                } else {
                    frameLayoutShow.setVisibility(View.VISIBLE);
                    frameLayoutLoading.setVisibility(View.GONE);
                    Log.d("AddTheater", "fetch failed");
//                    progressDialog.dismiss();
                }
            }
        });


    }

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
