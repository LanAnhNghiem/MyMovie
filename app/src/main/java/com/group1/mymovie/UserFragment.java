package com.group1.mymovie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by LanAnh on 08/11/2017.
 */

public class UserFragment extends Fragment {
    OnScrollingListener scrollingListener;
    CardView btnEditProfile, btnFavorites, btnSetting, btnSignOut;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user2, container, false);
        scrollingListener.onScrollingListener(true);
        btnEditProfile = (CardView)view.findViewById(R.id.cvEditProfile);
        btnFavorites = (CardView)view.findViewById(R.id.cvFavorite);
        btnSetting = (CardView)view.findViewById(R.id.cvSetting);
        btnSignOut = (CardView)view.findViewById(R.id.cvSignOut);
        btnEditProfile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEditProfile.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorTransparent));
                    Intent intent = new Intent(getActivity(), ProfileActivity.class);
                    startActivity(intent);
                    return true;
                } else {
                    btnEditProfile.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorTrans));
                }
                return false;
            }
        });
        btnFavorites.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnFavorites.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorTransparent));
                    return true;
                } else {
                    btnFavorites.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorTrans));
                }
                return false;
            }
        });
        btnSetting.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnSetting.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorTransparent));
                    return true;
                } else {
                    btnSetting.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorTrans));
                }
                return false;
            }
        });
        btnSignOut.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnSignOut.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorTransparent));
                    return true;
                } else {
                    btnSignOut.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorTrans));
                }
                return false;
            }
        });
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "click nè");

            }
        });
        btnFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FavoritesActivity.class);
                intent.putExtra("title", "Favorites");
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Sign out successfully", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        scrollingListener = (OnScrollingListener)context;
    }
}
