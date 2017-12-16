package com.group1.mymovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class List2Activity extends AppCompatActivity {
    RecyclerView rvList;
    LinearLayoutManager linearLayout;
    ShowAdapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(List2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        if(intent.hasExtra("title")){
            String title = intent.getStringExtra("title");
            getSupportActionBar().setTitle(title);
        }
        rvList = (RecyclerView) findViewById(R.id.rvList);
        linearLayout = new LinearLayoutManager(this);
        linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new ShowAdapter(createMovieList(), getBaseContext(), false);
        rvList.setLayoutManager(linearLayout);
        rvList.setAdapter(adapter);
    }

//    public ArrayList<Integer> createMovieList(){
//        ArrayList<Integer>list = new ArrayList<>();
//        list.add(R.drawable.banner_gintama);
//        list.add(R.drawable.banner_your_name);
//        list.add(R.drawable.banner_descendants_of_the_sun);
//        list.add(R.drawable.banner_goblin);
//        list.add(R.drawable.banner_koe_no_katachi);
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
