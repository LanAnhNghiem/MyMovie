package com.group1.mymovie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by LanAnh on 09/11/2017.
 */

public class TVLatestFragment extends Fragment {
    RecyclerView rvShow;
    ShowAdapter adapter;
    LinearLayoutManager layoutManager;
    Spinner spinner;
    LinearLayout container;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_latest, container, false);
        rvShow = (RecyclerView) view.findViewById(R.id.rvShow);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new ShowAdapter(createBannerList(), getContext(), true);
        rvShow.setLayoutManager(layoutManager);
        rvShow.setAdapter(adapter);
        container = (LinearLayout) view.findViewById(R.id.container);
        container.setVisibility(View.VISIBLE);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sort, R.layout.item_spinner);
        adapter.setDropDownViewResource(R.layout.item_spinner_dropdown);
        spinner.setAdapter(adapter);
        return view;
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
}
