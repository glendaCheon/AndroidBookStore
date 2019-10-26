package com.example.bookstore.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookstore.R;
import com.example.bookstore.model.Movie;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder>{
    //1.ViewHolder
    //2.onCreateViewHolder
    //3.onBindViewHolder
    //4.getItemCount

    List<Movie> movies;
    MainContract.Presenter presenter;

    public MainAdapter(List<Movie> movies, MainContract.Presenter presenter){
        this.movies = movies;
        this.presenter = presenter;
    }

    class MainAdapterViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        public TextView title;
        public TextView summary;

        public MainAdapterViewHolder(View itemView){
            super(itemView);
            this.thumbnail = itemView.findViewById(R.id.thumbnail);
            this.title = itemView.findViewById(R.id.txtTitle);
            this.summary = itemView.findViewById(R.id.txtSummary);
        }

    }

    @NonNull
    @Override
    public MainAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_new,parent,false);
        return new MainAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapterViewHolder holder, int position) {
        Movie movie = movies.get(position);
        String thumbnailPath = movie.getMediumCoverImage();
        Log.d("adapter ", thumbnailPath);
        Glide.with(holder.itemView.getContext())
            .load(thumbnailPath)
            .into(holder.thumbnail);
//        holder.thumbnail.setImageURI(new Uri(thumbnailPath));
        holder.title.setText(movie.getTitle());
        holder.summary.setText(movie.getSummary());

    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }
}
