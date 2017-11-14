package com.group1.mymovie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LanAnh on 04/11/2017.
 */

public class VideosFragment extends Fragment {
    CardView cvEp1, cvEp2, cvEp3, cvEp4, cvEp5, cvEp6, cvEp7, cvServer1, cvServer2, cvServer3;
    TextView txtEp1, txtEp2, txtEp3, txtEp4, txtEp5, txtEp6, txtEp7, txtServer1, txtServer2, txtServer3;
    RecyclerView rvTrailer;
    LinearLayoutManager layoutTrailer;
    VideoAdapter adapterTrailer;
    RecyclerView rvRecommend;
    LinearLayoutManager layoutRecommend;
    VideoAdapter adapterRecommend;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videos, container, false);
        cvEp1 = (CardView) view.findViewById(R.id.cvEp1);
        cvEp2 = (CardView) view.findViewById(R.id.cvEp2);
        cvEp3 = (CardView) view.findViewById(R.id.cvEp3);
        cvEp4 = (CardView) view.findViewById(R.id.cvEp4);
        cvEp5 = (CardView) view.findViewById(R.id.cvEp5);
        cvEp6 = (CardView) view.findViewById(R.id.cvEp6);
        cvEp7 = (CardView) view.findViewById(R.id.cvEp7);
        cvServer1 = (CardView) view.findViewById(R.id.server1);
        cvServer2 = (CardView) view.findViewById(R.id.server2);
        cvServer3 = (CardView) view.findViewById(R.id.server3);
        txtEp1 = (TextView) view.findViewById(R.id.txtEp1);
        txtEp2 = (TextView) view.findViewById(R.id.txtEp2);
        txtEp3 = (TextView) view.findViewById(R.id.txtEp3);
        txtEp4 = (TextView) view.findViewById(R.id.txtEp4);
        txtEp5 = (TextView) view.findViewById(R.id.txtEp5);
        txtEp6 = (TextView) view.findViewById(R.id.txtEp6);
        txtEp7 = (TextView) view.findViewById(R.id.txtEp7);
        txtServer1 = (TextView) view.findViewById(R.id.txtServer1);
        txtServer2 = (TextView) view.findViewById(R.id.txtServer2);
        txtServer3 = (TextView) view.findViewById(R.id.txtServer3);

        rvTrailer = (RecyclerView) view.findViewById(R.id.rvTrailer);
        rvTrailer.setNestedScrollingEnabled(false);
        layoutTrailer = new LinearLayoutManager(getContext());
        layoutTrailer.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapterTrailer = new VideoAdapter(createTrailerName(), getContext());
        rvTrailer.setLayoutManager(layoutTrailer);
        rvTrailer.setAdapter(adapterTrailer);

        rvRecommend = (RecyclerView) view.findViewById(R.id.rvRecommend);
        rvRecommend.setNestedScrollingEnabled(false);
        layoutRecommend = new LinearLayoutManager(getContext());
        layoutRecommend.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapterRecommend = new VideoAdapter(createRecommendName(), getContext());
        rvRecommend.setLayoutManager(layoutRecommend);
        rvRecommend.setAdapter(adapterRecommend);
        changeColor(1);
        changeColor(-1);

        cvEp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(1);
                for(int i=2;i<8;i++){
                    returnColor(i);
                }
            }
        });
        cvEp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(2);
                for(int i=1;i<8;i++){
                    if(i == 2)
                        continue;
                    returnColor(i);
                }
            }
        });
        cvEp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(3);
                for(int i=1;i<8;i++){
                    if(i == 3)
                        continue;
                    returnColor(i);
                }
            }
        });
        cvEp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(4);
                for(int i=1;i<8;i++){
                    if(i == 4)
                        continue;
                    returnColor(i);
                }
            }
        });
        cvEp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(5);
                for(int i=1;i<8;i++){
                    if(i == 5)
                        continue;
                    returnColor(i);
                }
            }
        });
        cvEp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(6);
                for(int i=1;i<8;i++){
                    if(i == 6)
                        continue;
                    returnColor(i);
                }
            }
        });
        cvEp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(7);
                for(int i=1;i<7;i++){
                    returnColor(i);
                }
            }
        });
        cvServer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(-1);
                for(int i= -2;i>-4;i--){
                    returnColor(i);
                }
            }
        });
        cvServer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(-2);
                for(int i= -1;i>-4;i--){
                    if(i == -2)
                        continue;
                    returnColor(i);
                }
            }
        });
        cvServer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(-3);
                for(int i= -1;i>-3;i--){
                    returnColor(i);
                }
            }
        });
        return view;
    }
    public void changeColor(int i){
        switch(i){
            case -1:
                txtServer1.setTextColor(ContextCompat.getColor(getContext(), R.color.colorLightGray));
                cvServer1.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
                break;
            case -2:
                txtServer2.setTextColor(ContextCompat.getColor(getContext(), R.color.colorLightGray));
                cvServer2.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
                break;
            case -3:
                txtServer3.setTextColor(ContextCompat.getColor(getContext(), R.color.colorLightGray));
                cvServer3.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
                break;
            case 1:
                txtEp1.setTextColor(ContextCompat.getColor(getContext(), R.color.colorLightGray));
                cvEp1.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
                break;
            case 2:
                txtEp2.setTextColor(ContextCompat.getColor(getContext(), R.color.colorLightGray));
                cvEp2.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
                break;
            case 3:
                txtEp3.setTextColor(ContextCompat.getColor(getContext(), R.color.colorLightGray));
                cvEp3.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
                break;
            case 4:
                txtEp4.setTextColor(ContextCompat.getColor(getContext(), R.color.colorLightGray));
                cvEp4.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
                break;
            case 5:
                txtEp5.setTextColor(ContextCompat.getColor(getContext(), R.color.colorLightGray));
                cvEp5.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
                break;
            case 6:
                txtEp6.setTextColor(ContextCompat.getColor(getContext(), R.color.colorLightGray));
                cvEp6.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
                break;
            case 7:
                txtEp7.setTextColor(ContextCompat.getColor(getContext(), R.color.colorLightGray));
                cvEp7.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorAccent));
                break;
        }
    }
    public void returnColor(int i){
        switch(i){
            case -1:
                txtServer1.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                cvServer1.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorSubPrimary));
                break;
            case -2:
                txtServer2.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                cvServer2.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorSubPrimary));
                break;
            case -3:
                txtServer3.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                cvServer3.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorSubPrimary));
                break;
            case 1:
                txtEp1.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                cvEp1.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorSubPrimary));
                break;
            case 2:
                txtEp2.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                cvEp2.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorSubPrimary));
                break;
            case 3:
                txtEp3.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                cvEp3.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorSubPrimary));
                break;
            case 4:
                txtEp4.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                cvEp4.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorSubPrimary));
                break;
            case 5:
                txtEp5.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                cvEp5.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorSubPrimary));
                break;
            case 6:
                txtEp6.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                cvEp6.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorSubPrimary));
                break;
            case 7:
                txtEp7.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                cvEp7.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorSubPrimary));
                break;
        }
    }
    public ArrayList<String> createTrailerName(){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i< 5;i++){
            list.add("Trailer "+ i);
        }
        return list;
    }
    public ArrayList<String> createRecommendName(){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i< 10;i++){
            list.add("Clip "+ i);
        }
        return list;
    }
}
