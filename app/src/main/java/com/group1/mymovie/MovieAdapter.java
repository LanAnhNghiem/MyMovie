package com.group1.mymovie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lana on 01/11/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    ArrayList<Movie> mMovieList = new ArrayList<>();
    Context mContext;
    int mWidth;
    float mHeight;
    public MovieAdapter(ArrayList<Movie> list, Context context, int width, float height) {
        this.mMovieList = list;
        this.mContext = context;
        this.mWidth = width;
        this.mHeight = height;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        MovieHolder movieHolder = new MovieHolder(inflatedView);
        return movieHolder;
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Picasso.with(mContext).load(mMovieList.get(position).getPoster())
                .placeholder(R.drawable.default_landscape)
                .resize(mWidth, (int)mHeight)
                .into(holder.imgPoster);
        holder.txtName.setText(mMovieList.get(position).getName());
        holder.txtRating.setText(String.valueOf(mMovieList.get(position).getRating()));
        holder.txtGenre.setText(mMovieList.get(position).getGenre());
        holder.txtName.setWidth(mWidth);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPoster;
        TextView txtName;
        TextView txtGenre;
        TextView txtRating;
        public MovieHolder(View itemView) {
            super(itemView);
            imgPoster = (ImageView) itemView.findViewById(R.id.imgPoster);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtGenre = (TextView) itemView.findViewById(R.id.txtGenre);
            txtRating = (TextView) itemView.findViewById(R.id.txtRating);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, DetailActivity.class);
            mContext.startActivity(intent);
        }
    }
}
