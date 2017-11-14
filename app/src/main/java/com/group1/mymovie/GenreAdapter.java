package com.group1.mymovie;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LanAnh on 04/11/2017.
 */

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreHolder> {
    ArrayList<String> list = new ArrayList<>();

    public GenreAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public GenreHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_genre, viewGroup, false);
        GenreHolder holder = new GenreHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GenreHolder genreHolder, int i) {
        genreHolder.txtGenre.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GenreHolder extends RecyclerView.ViewHolder {
        TextView txtGenre;
        public GenreHolder(View itemView) {
            super(itemView);
            txtGenre = (TextView) itemView.findViewById(R.id.txtGenre);
        }
    }
}
