package com.group1.mymovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    RecyclerView rvList;
    GridLayoutManager gridLayout;
    PortraitAdapter adapter;
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
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        if(intent.hasExtra("title")){
            String title = intent.getStringExtra("title");
            getSupportActionBar().setTitle(title);
        }
        rvList = (RecyclerView) findViewById(R.id.rvList);
        gridLayout = new GridLayoutManager(this, 2);
        adapter = new PortraitAdapter(createMovieList(), this, false);
        rvList.setLayoutManager(gridLayout);
        rvList.setAdapter(adapter);
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
