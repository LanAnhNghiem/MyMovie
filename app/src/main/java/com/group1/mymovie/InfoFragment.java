package com.group1.mymovie;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by LanAnh on 04/11/2017.
 */

public class InfoFragment extends Fragment {
    RecyclerView rvGenre;
    LinearLayoutManager layoutManager;
    GenreAdapter genreAdapter;
    ExpandableTextView txtOverview;
    RecyclerView rvCast;
    LinearLayoutManager layoutManager2;
    CastAdapter castAdapter;
    RatingBar ratingBar;
    TextView txtRating;
    CardView cvFavorite, cvDownload;
    ImageView imgFavorite, imgDownload;
    boolean isPressed = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        txtOverview = (ExpandableTextView) view.findViewById(R.id.txtOverview);
        txtOverview.setTrimLength(100);
        rvGenre = (RecyclerView)view.findViewById(R.id.rvGenres);
        rvGenre.setNestedScrollingEnabled(false);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        genreAdapter = new GenreAdapter(createListGenre());
        rvGenre.setLayoutManager(layoutManager);
        rvGenre.setAdapter(genreAdapter);

        rvCast = (RecyclerView)view.findViewById(R.id.rvCasts);
        rvCast.setNestedScrollingEnabled(false);
        layoutManager2 = new LinearLayoutManager(getContext());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        castAdapter = new CastAdapter(createListCast(), getContext(), Utilities.SMALL_WIDTH, (int)(Utilities.SMALL_WIDTH * Utilities.GOLDEN_RATIO));
        rvCast.setLayoutManager(layoutManager2);
        rvCast.setAdapter(castAdapter);

        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        txtRating = (TextView) view.findViewById(R.id.txtRating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                txtRating.setText(String.valueOf(ratingBar.getRating()*2));
            }
        });
        cvFavorite = view.findViewById(R.id.cvFavorite);
        cvDownload = view.findViewById(R.id.cvDownload);
        imgFavorite = view.findViewById(R.id.imgStar);
        imgDownload = view.findViewById(R.id.imgDownload);
        cvFavorite.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        if(isPressed == false){
                            cvFavorite.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                            Picasso.with(getContext()).load(R.drawable.ic_star_hover).into(imgFavorite);
                            isPressed =true;
                            Toast.makeText(getContext(), "Added to Favorites", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            cvFavorite.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                            Picasso.with(getContext()).load(R.drawable.ic_star).into(imgFavorite);
                            isPressed=false;
                            Toast.makeText(getContext(), "Removed from Favorites", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                return false;
            }
        });
        cvDownload.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        cvDownload.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                        Picasso.with(getContext()).load(R.drawable.ic_download_hover).into(imgDownload);
                        Toast.makeText(getContext(), "Start downloading...", Toast.LENGTH_SHORT).show();
                        break;
                }
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        cvDownload.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                        Picasso.with(getContext()).load(R.drawable.ic_file_download_white_48dp).into(imgDownload);
                    }
                }, 200);

                return false;
            }
        });
        return view;
    }

    public ArrayList<String> createListGenre(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Melodrama");
        list.add("Webdrama");
        list.add("Romance");
        list.add("Japanese");
        list.add("Anime");
        list.add("Action");
        return list;
    }
    public ArrayList<Cast> createListCast(){
        ArrayList<Cast> list = new ArrayList<>();
        list.add(new Cast("Mone Kamishiraishi", "Main Cast", R.drawable.img_cast_1));
        list.add(new Cast("Ryunosuke Kamiki", "Main Cast", R.drawable.img_cast_2));
        list.add(new Cast("Ryo Narita", "Main Cast", R.drawable.img_cast_3));
        list.add(new Cast("Masami Nagasawa", "Main Cast", R.drawable.img_cast_4));
        list.add(new Cast("Aoi Yūki", "Supporting Cast", R.drawable.img_cast_5));
        list.add(new Cast("Kanon Tani", "Supporting Cast", R.drawable.img_cast_6));
        list.add(new Cast("Nobunaga Shimazaki", "Supporting Cast", R.drawable.img_cast_7));
        return list;
    }
}
