package com.group1.mymovie;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements OnScrollingListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    public BottomNavigationView bottomTab;
    private Toolbar toolbar;
    //int y, initialY, scrollingY, scrolledY;
    boolean isVisible = true;
    float initialX, initialY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomTab = (BottomNavigationView) findViewById(R.id.bottomTab);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomTab.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, new MoviesFragment()).commit();
        bottomTab.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()){
                    case R.id.action_features:
                        transaction.replace(R.id.container, new MoviesFragment()).commit();
                        return true;
                    case R.id.action_movies:
                        transaction.replace(R.id.container, new TVShowFragment()).commit();
                        return true;
                    case R.id.action_setting:
                        transaction.replace(R.id.container, new UserFragment()).commit();
                        return true;
                }
                return false;
            }
        });
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        ComponentName componentName = new ComponentName(getApplicationContext(), MainActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));
        return true;
    }

    @Override
    public void onScrollingListener(boolean isUp) {
        if(isUp){
            bottomTab.clearAnimation();
            bottomTab.animate().translationY(0).setDuration(200);
        }else{
            bottomTab.clearAnimation();
            bottomTab.animate().translationY(168).setDuration(200);
        }
    }
}
