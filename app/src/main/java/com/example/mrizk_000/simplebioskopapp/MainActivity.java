package com.example.mrizk_000.simplebioskopapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.mrizk_000.simplebioskopapp.models.Menu;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Menu> menus;

    Toolbar toolbar;

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) actionBar = getSupportActionBar();

        if(savedInstanceState == null) {
            actionBar.setTitle("Simple Bioskop App");
        }

        // Configuring RecyclerView LayoutManager
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        menus = new ArrayList<>();
        initDataMenu();

        mAdapter = new MainAdapter(this, menus);
        recyclerView.setAdapter(mAdapter);
    }

    private void initDataMenu() {
        menus.add(new Menu("Daftar Semua Theater", "Pilih untuk melihat semua bioskop yang tersedia"));
        menus.add(new Menu("Daftar Semua Movie", "Pilih untuk melihat semua film yang tersedia"));
    }
}
