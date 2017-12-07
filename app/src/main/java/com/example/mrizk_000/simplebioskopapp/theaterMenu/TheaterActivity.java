package com.example.mrizk_000.simplebioskopapp.theaterMenu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.mrizk_000.simplebioskopapp.R;
import com.example.mrizk_000.simplebioskopapp.models.Theater;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TheaterActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Theater> theaters;

    Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);

        recyclerView = (RecyclerView) findViewById(R.id.theater_recyclerView);
        toolbar = (Toolbar) findViewById(R.id.theater_toolbar);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) actionBar = getSupportActionBar();

        if(savedInstanceState == null) {
            actionBar.setTitle("Daftar Semua Bioskop");
        }
        actionBar.setDisplayHomeAsUpEnabled(true);


        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        theaters = new ArrayList<>();
        theaters.add(new Theater(1, "Bioskop 21", "Jl. Malang", "Bioskop Keren"));
        theaters.add(new Theater(2, "Bioskop Cinemaxx", "Jl. Malang", "Bioskop Keren"));

        mAdapter = new TheaterAdapter(this, theaters);
        recyclerView.setAdapter(mAdapter);
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
