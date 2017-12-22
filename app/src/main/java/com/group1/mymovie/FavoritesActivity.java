package com.group1.mymovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {
    RecyclerView rvList;
    GridLayoutManager gridLayout;
    MovieAdapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        if(intent.hasExtra("title")){
            String title = intent.getStringExtra("title");
            getSupportActionBar().setTitle(title);
        }
        rvList = (RecyclerView) findViewById(R.id.rvList);
        gridLayout = new GridLayoutManager(this, 2);
        adapter = new MovieAdapter(createMovieList(), this, Utilities.LANDSCAPE_WIDTH, (int)(Utilities.LANDSCAPE_WIDTH/ Utilities.GOLDEN_RATIO));
        rvList.setLayoutManager(gridLayout);
        rvList.setAdapter(adapter);
    }

    public ArrayList<Movie> createMovieList(){
        ArrayList<Movie>list = new ArrayList<>();
        list.add(new Movie(R.drawable.banner_descendants_of_the_sun, "Descendants of the sun", (float)6.6, "Movie"));
        list.add(new Movie(R.drawable.banner_koe_no_katachi, "Koe no katachi", (float)7.1, "Movie"));
        list.add(new Movie(R.drawable.banner_big_hero_6, "Big Hero 6", (float)7.5, "TV show"));
        list.add(new Movie(R.drawable.banner_goblin, "Goblin (2017)", (float)8.8, "Movie"));
        list.add(new Movie(R.drawable.banner_gintama, "Gintama (2017)", (float)8.0, "TV show"));
        list.add(new Movie(R.drawable.banner_your_name, "Kimi no na wa", (float)8.5, "Movie"));
        list.add(new Movie(R.drawable.banner_garden_of_the_word, "Garden of the word", (float)8.5, "TV show"));
        return list;
    }
}
