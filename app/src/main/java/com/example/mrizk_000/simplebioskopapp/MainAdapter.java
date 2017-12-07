package com.example.mrizk_000.simplebioskopapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrizk_000.simplebioskopapp.models.Menu;
import com.example.mrizk_000.simplebioskopapp.movieMenu.MovieActivity;
import com.example.mrizk_000.simplebioskopapp.theaterMenu.TheaterActivity;

import java.util.List;

/**
 * Created by mrizk_000 on 12/6/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<Menu> menus;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView judul;
        public TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
            judul = (TextView) itemView.findViewById(R.id.mainAdapter_judul);
            desc = (TextView) itemView.findViewById(R.id.mainAdapter_desc);
        }
    }

    public MainAdapter(Context context, List<Menu> menus) {
        this.context = context;
        this.menus = menus;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.main_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, final int position) {
        holder.judul.setText(menus.get(position).getJudul());
        holder.desc.setText(menus.get(position).getDesc());
        holder.judul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if (position == 0) {
                    intent = new Intent(context, TheaterActivity.class);
                    context.startActivity(intent);
                } else {
                    intent = new Intent(context, MovieActivity.class);
                    context.startActivity(intent);
                }
            }
        });
        holder.desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if (position == 0) {
                    intent = new Intent(context, TheaterActivity.class);
                    context.startActivity(intent);
                } else {
                    intent = new Intent(context, MovieActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }
}
