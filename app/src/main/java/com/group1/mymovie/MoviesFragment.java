package com.group1.mymovie;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import static com.group1.mymovie.R.id.viewPager;

/**
 * Created by LanAnh on 08/11/2017.
 */

public class MoviesFragment extends Fragment {
    private Toolbar toolbar;
    ViewPager mViewPager;
    TabLayout mTabLayout;
    ViewPagerAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        mViewPager = (ViewPager) view.findViewById(viewPager);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
        mAdapter = new ViewPagerAdapter(getChildFragmentManager());
        setupViewPager(mViewPager);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        SearchManager searchManager = (SearchManager) ((AppCompatActivity) getActivity()).getSystemService(Context.SEARCH_SERVICE);
        ComponentName componentName = new ComponentName(((AppCompatActivity) getActivity()).getApplicationContext(), MainActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));
    }

    public void setupViewPager(ViewPager viewPager){
//        mAdapter.addFragment(new MoviesFragment(), "Info");
        mAdapter.addFragment(new FeatureFragment(), "Features");
        mAdapter.addFragment(new TopFragment(), "Top Rate");
        mAdapter.addFragment(new TabFragment(), "Japanese");
        mAdapter.addFragment(new TabFragment(), "Korean");
        mAdapter.addFragment(new TabFragment(), "Action");
        mAdapter.addFragment(new TabFragment(), "Cartoon");
        viewPager.setAdapter(mAdapter);
    }

}
