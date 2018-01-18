package com.group1.mymovie;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by LanAnh on 09/11/2017.
 */

public class TVLatestFragment2 extends Fragment {
    RecyclerView rvShow;
    ShowAdapter adapter;
    LinearLayoutManager layoutManager;
    OnScrollingListener scrollingListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_latest2, container, false);
        rvShow = (RecyclerView) view.findViewById(R.id.rvShow);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new ShowAdapter(createMovieList(), getContext(), false);
        rvShow.setLayoutManager(layoutManager);
        rvShow.setAdapter(adapter);
        rvShow.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

//    ArrayList<Integer> createBannerList(){
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(R.drawable.banner_garden_of_the_word);
//        list.add(R.drawable.banner_gintama);
//        list.add(R.drawable.banner_koe_no_katachi);
//        list.add(R.drawable.banner_your_name);
//        list.add(R.drawable.banner_big_hero_6);
//        return list;
//    }
    public ArrayList<Movie> createMovieList(){
        ArrayList<Movie>list = new ArrayList<>();
        list.add(new Movie(R.drawable.banner_koe_no_katachi, "Koe no katachi", (float)7.1, "Anime, Romance"));
        list.add(new Movie(R.drawable.banner_big_hero_6, "Big Hero 6", (float)7.5, "Cartoon, Family"));
        list.add(new Movie(R.drawable.banner_gintama, "Gintama (2017)", (float)8.0, "Action, Comedy"));
        list.add(new Movie(R.drawable.banner_your_name, "Kimi no na wa", (float)8.5, "Romance, Anime"));
        list.add(new Movie(R.drawable.banner_goblin, "Goblin (2017)", (float)8.8, "Melodrama, Romance"));
        return list;
    }
}
