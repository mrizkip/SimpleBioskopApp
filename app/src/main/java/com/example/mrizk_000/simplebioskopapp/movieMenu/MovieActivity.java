package com.example.mrizk_000.simplebioskopapp.movieMenu;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.mrizk_000.simplebioskopapp.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MovieActivity extends AppCompatActivity {

    SmartTabLayout viewPagerTab;
    ViewPager viewPager;

    Toolbar toolbar;
    private ActionBar actionBar;

    FragmentPagerItemAdapter adapter;

    NowShowingFragment viewNowShowing;
    ComingSoonFragment viewComingSoon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        toolbar = (Toolbar) findViewById(R.id.movie_toolbar);
        viewPager = (ViewPager) findViewById(R.id.movie_fragmentViewPager);
        viewPagerTab = (SmartTabLayout) findViewById(R.id.movie_tabViewPager);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) actionBar = getSupportActionBar();

        if(savedInstanceState == null) {
            actionBar.setTitle("Daftar Semua Film");
        }
        actionBar.setDisplayHomeAsUpEnabled(true);

        adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("NOW SHOWING", NowShowingFragment.class)
                .add("COMING SOON", ComingSoonFragment.class)
                .create()
        );

        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    viewNowShowing = (NowShowingFragment) adapter.getPage(0);
                } else if (position == 1) {
                    viewComingSoon = (ComingSoonFragment) adapter.getPage(1);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
