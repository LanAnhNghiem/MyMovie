package com.group1.mymovie;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by LanAnh on 08/11/2017.
 */

public class TabFragment extends Fragment {
    RecyclerView rvList;
    GridLayoutManager gridLayout;
    PortraitAdapter adapter;
    Spinner spinner;
    OnScrollingListener scrollingListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        rvList = (RecyclerView) view.findViewById(R.id.rvList);
        gridLayout = new GridLayoutManager(getContext(), 2);
        adapter = new PortraitAdapter(createMovieList(), getContext(), true);
        rvList.setLayoutManager(gridLayout);
        rvList.setAdapter(adapter);
        rvList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    // Scrolling up
                    onScrolling(false);
                } else {
                    // Scrolling down
                    onScrolling(true);
                }
            }
        });
        spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sort, R.layout.item_spinner);
        adapter.setDropDownViewResource(R.layout.item_spinner_dropdown);
        spinner.setAdapter(adapter);
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        scrollingListener = (OnScrollingListener)context;
    }

    public void onScrolling(boolean isUp){
        scrollingListener.onScrollingListener(isUp);
    }
    public ArrayList<Movie> createMovieList(){
        ArrayList<Movie>list = new ArrayList<>();
        list.add(new Movie(R.drawable.poster_descendants_of_the_sun, "Descendants of the sun", (float)6.6, "Melodrama, Action"));
        list.add(new Movie(R.drawable.poster_koe_no_katachi, "Koe no katachi", (float)7.1, "Anime, Romance"));
        list.add(new Movie(R.drawable.poster_big_hero_6, "Big Hero 6", (float)7.5, "Cartoon, Family"));
        list.add(new Movie(R.drawable.poster_goblin, "Goblin (2017)", (float)8.8, "Melodrama, Romance"));
        list.add(new Movie(R.drawable.poster_gintama, "Gintama (2017)", (float)8.0, "Action, Comedy"));
        list.add(new Movie(R.drawable.poster_your_name, "Kimi no na wa", (float)8.5, "Romance, Anime"));
        list.add(new Movie(R.drawable.poster_it, "IT (2017)", (float)8.2, "Horror"));
        list.add(new Movie(R.drawable.poster_temperature_of_love, "Temperature of love", (float)6.5, "Romance, Family"));
        return list;
    }
}
