package com.group1.mymovie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LanAnh on 04/11/2017.
 */

public class InfoFragment extends Fragment {
    RecyclerView rvGenre;
    LinearLayoutManager layoutManager;
    GenreAdapter genreAdapter;
    ExpandableTextView txtOverview;
    RecyclerView rvCast;
    LinearLayoutManager layoutManager2;
    CastAdapter castAdapter;
    RatingBar ratingBar;
    TextView txtRating;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        txtOverview = (ExpandableTextView) view.findViewById(R.id.txtOverview);
        txtOverview.setTrimLength(100);
        rvGenre = (RecyclerView)view.findViewById(R.id.rvGenres);
        rvGenre.setNestedScrollingEnabled(false);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        genreAdapter = new GenreAdapter(createListGenre());
        rvGenre.setLayoutManager(layoutManager);
        rvGenre.setAdapter(genreAdapter);

        rvCast = (RecyclerView)view.findViewById(R.id.rvCasts);
        rvCast.setNestedScrollingEnabled(false);
        layoutManager2 = new LinearLayoutManager(getContext());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        castAdapter = new CastAdapter(createListCast(), getContext(), Utilities.SMALL_WIDTH, (int)(Utilities.SMALL_WIDTH*1.5));
        rvCast.setLayoutManager(layoutManager2);
        rvCast.setAdapter(castAdapter);

        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        txtRating = (TextView) view.findViewById(R.id.txtRating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                txtRating.setText(String.valueOf(ratingBar.getRating()*2));
            }
        });
        return view;
    }

    public ArrayList<String> createListGenre(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Melodrama");
        list.add("Webdrama");
        list.add("Romance");
        list.add("Japanese");
        list.add("Anime");
        list.add("Action");
        return list;
    }
    public ArrayList<Cast> createListCast(){
        ArrayList<Cast> list = new ArrayList<>();
        Cast cast;
        for(int i = 0; i < 10;i++){
            if(i<4){
                cast = new Cast("Emma Watson", "Main Cast", R.drawable.cast_emma_watson);
            }else{
                cast = new Cast("Emma Watson", "Supporting Cast", R.drawable.cast_emma_watson);
            }
            list.add(cast);
        }
        return list;
    }
}
