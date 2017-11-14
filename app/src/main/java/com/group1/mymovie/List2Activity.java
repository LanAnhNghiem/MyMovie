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

    public ArrayList<Integer> createMovieList(){
        ArrayList<Integer>list = new ArrayList<>();
        list.add(R.drawable.banner_gintama);
        list.add(R.drawable.banner_your_name);
        list.add(R.drawable.banner_descendants_of_the_sun);
        list.add(R.drawable.banner_goblin);
        list.add(R.drawable.banner_koe_no_katachi);
        list.add(R.drawable.banner_big_hero_6);
        return list;
    }
}
