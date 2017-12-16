package com.group1.mymovie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

/**
 * Created by LanAnh on 08/11/2017.
 */

public class Feature2Fragment extends Fragment {
    OnScrollingListener scrollingListener;
    CarouselView carouselView;
    RecyclerView rvPopularity;
    MovieAdapter adapterPopularity;
    LinearLayoutManager layoutPopularity;
    RecyclerView rvMost;
    MovieAdapter adapterMost;
    GridLayoutManager gridMost;
    RecyclerView rvRecommend;
    MovieAdapter adapterRecommend;
    GridLayoutManager gridRecommend;
    TextView txtMorePopularity, txtMoreMost, txtMoreRecommend;
    NestedScrollView nestedScrollView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feature2, container, false);
        nestedScrollView = view.findViewById(R.id.nestedScroll);
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                    onScrolling(false);
                }
                if (scrollY < oldScrollY) {
                    onScrolling(true);
                }
            }
        });
        carouselView = (CarouselView) view.findViewById(R.id.carouselView);
        carouselView.setPageCount(createBannerList().size());
        carouselView.setImageListener(imageListener);
        carouselView.setMinimumHeight((int)(Utilities.SCREEN_WIDTH / Utilities.GOLDEN_RATIO));
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                startActivity(intent);
            }
        });
        rvPopularity = (RecyclerView) view.findViewById(R.id.rvPopularity);
        layoutPopularity = new GridLayoutManager(getContext(), 2);
        adapterPopularity = new MovieAdapter(createPopularityList(), getContext(), Utilities.LANDSCAPE_WIDTH, (float)(Utilities.LANDSCAPE_WIDTH/Utilities.GOLDEN_RATIO));
        rvPopularity.setLayoutManager(layoutPopularity);
        rvPopularity.setAdapter(adapterPopularity);
        rvMost = (RecyclerView) view.findViewById(R.id.rvMost);
        gridMost = new GridLayoutManager(getContext(), 2);
        adapterMost = new MovieAdapter(createMovieList(), getContext(), Utilities.LANDSCAPE_WIDTH, (float)(Utilities.LANDSCAPE_WIDTH/Utilities.GOLDEN_RATIO));
        rvMost.setLayoutManager(gridMost);
        rvMost.setAdapter(adapterMost);
        rvRecommend = (RecyclerView) view.findViewById(R.id.rvRecommend);
        gridRecommend = new GridLayoutManager(getContext(), 2);
        adapterRecommend = new MovieAdapter(createRecommendList(), getContext(), Utilities.LANDSCAPE_WIDTH, (float)(Utilities.LANDSCAPE_WIDTH/Utilities.GOLDEN_RATIO));
        rvRecommend.setLayoutManager(gridRecommend);
        rvRecommend.setAdapter(adapterRecommend);
        txtMorePopularity = (TextView) view.findViewById(R.id.txtMorePopularity);
        txtMorePopularity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), List2Activity.class);
                intent.putExtra("title", "Popularity");
                startActivity(intent);
            }
        });
        txtMoreMost =(TextView) view.findViewById(R.id.txtMoreMost);
        txtMoreMost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), List2Activity.class);
                intent.putExtra("title", "Most watched TV shows");
                startActivity(intent);
            }
        });
        txtMoreRecommend = (TextView) view.findViewById(R.id.txtMoreRecommend);
        txtMoreRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), List2Activity.class);
                intent.putExtra("title", "Recommend");
                startActivity(intent);
            }
        });
        return view;
    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(createBannerList().get(position));
        }
    };
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        scrollingListener = (OnScrollingListener)context;
    }

    public void onScrolling(boolean isUp){
        scrollingListener.onScrollingListener(isUp);
    }
    ArrayList<Integer> createBannerList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.banner_garden_of_the_word);
        list.add(R.drawable.banner_gintama);
        list.add(R.drawable.banner_koe_no_katachi);
        list.add(R.drawable.banner_your_name);
        list.add(R.drawable.banner_big_hero_6);
        return list;
    }
    public ArrayList<Movie> createPopularityList(){
        ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie(R.drawable.banner_your_name, "Kimi no na wa", (float)8.5, "Romance, Anime"));
        list.add(new Movie(R.drawable.banner_gintama, "Gintama (2017)", (float)8.0, "Action, Comedy"));
        list.add(new Movie(R.drawable.banner_goblin, "Goblin (2017)", (float)8.8, "Melodrama, Romance"));
        list.add(new Movie(R.drawable.banner_big_hero_6, "Big Hero 6", (float)7.5, "Cartoon, Family"));
//        list.add(new Movie(R.drawable.banner_koe_no_katachi, "Koe no katachi", (float)7.1, "Anime, Romance"));
//        list.add(new Movie(R.drawable.banner_descendants_of_the_sun, "Descendants", (float)6.6, "Melodrama, Action"));
        return list;
    }

    public ArrayList<Movie> createMovieList(){
        ArrayList<Movie>list = new ArrayList<>();
        list.add(new Movie(R.drawable.banner_koe_no_katachi, "Koe no katachi", (float)7.1, "Anime, Romance"));
        list.add(new Movie(R.drawable.banner_big_hero_6, "Big Hero 6", (float)7.5, "Cartoon, Family"));
        list.add(new Movie(R.drawable.banner_gintama, "Gintama (2017)", (float)8.0, "Action, Comedy"));
        list.add(new Movie(R.drawable.banner_your_name, "Kimi no na wa", (float)8.5, "Romance, Anime"));
        return list;
    }

    public ArrayList<Movie> createRecommendList(){
        ArrayList<Movie>list = new ArrayList<>();
        list.add(new Movie(R.drawable.banner_goblin, "Goblin (2017)", (float)8.8, "Melodrama, Romance"));
        list.add(new Movie(R.drawable.banner_koe_no_katachi, "Koe no katachi", (float)7.1, "Anime, Romance"));
        list.add(new Movie(R.drawable.banner_descendants_of_the_sun, "Descendants", (float)6.6, "Melodrama, Action"));
        list.add(new Movie(R.drawable.banner_gintama, "Gintama (2017)", (float)8.0, "Action, Comedy"));
        return list;
    }
}
