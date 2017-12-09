package com.example.mrizk_000.simplebioskopapp.theaterMenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrizk_000.simplebioskopapp.R;
import com.example.mrizk_000.simplebioskopapp.models.Theater;

import java.util.List;


/**
 * Created by mrizk_000 on 12/7/2017.
 */

public class TheaterAdapter extends RecyclerView.Adapter<TheaterAdapter.ViewHolder> {

    private Context context;
    private List<Theater> theaters;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView address;
        TextView description;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.theaterAdapter_name);
            address = (TextView) itemView.findViewById(R.id.theaterAdapter_address);
            description = (TextView) itemView.findViewById(R.id.theaterAdapter_description);
        }
    }

    public TheaterAdapter(Context context, List<Theater> theaters) {
        this.context = context;
        this.theaters = theaters;
    }

    @Override
    public TheaterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.theater_adapter, parent, false);
        TheaterAdapter.ViewHolder viewHolder = new TheaterAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TheaterAdapter.ViewHolder holder, int position) {
        holder.name.setText("" + theaters.get(position).getName());
        holder.address.setText("" + theaters.get(position).getAddress());
        holder.description.setText("" + theaters.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return theaters.size();
    }

}
