package com.example.mrizk_000.simplebioskopapp.movieMenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrizk_000.simplebioskopapp.R;
import com.example.mrizk_000.simplebioskopapp.models.Movie;

import java.util.List;

/**
 * Created by mrizk_000 on 12/10/2017.
 */

public class ComingSoonAdapter extends RecyclerView.Adapter<ComingSoonAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movies;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView genre;
        TextView duration;
        TextView synopsis;
        TextView theaterName;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.comingSoonAdapter_name);
            genre = (TextView) itemView.findViewById(R.id.comingSoonAdapter_genre);
            duration = (TextView) itemView.findViewById(R.id.comingSoonAdapter_duration);
            synopsis = (TextView) itemView.findViewById(R.id.comingSoonAdapter_synopsis);
            theaterName = (TextView) itemView.findViewById(R.id.comingSoonAdapter_theaterName);
        }
    }

    public ComingSoonAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.coming_soon_adapter, parent, false);
        ComingSoonAdapter.ViewHolder viewHolder = new ComingSoonAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(movies.get(position).getName() + " (" + movies.get(position).getRelease() + ")");
        holder.genre.setText(movies.get(position).getGenre());
        holder.duration.setText("" + movies.get(position).getDuration());
        holder.synopsis.setText(movies.get(position).getSynopsis());
        holder.theaterName.setText(movies.get(position).getTheaterDetail().getName() + " " + movies.get(position).getPlayDate());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


}
