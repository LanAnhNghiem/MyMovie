package com.group1.mymovie;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by LanAnh on 08/11/2017.
 */

public class UserFragment extends Fragment{
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
                    Intent intent = new Intent(getActivity(), FavoritesActivity.class);
                    intent.putExtra("title", "Favorites");
                    startActivity(intent);
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
                    showDialog();
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
                    Toast.makeText(getActivity(), "Sign out successfully", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    btnSignOut.setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorTrans));
                }
                return false;
            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        scrollingListener = (OnScrollingListener)context;
    }
    public void showDialog(){
        final CharSequence option[] = new CharSequence[]{"Movie","TV show"};
        LayoutInflater layout = LayoutInflater.from(getActivity());
        final View dialogview = layout.inflate(R.layout.dialog_view, null);
        final TextView txtMovie = dialogview.findViewById(R.id.txtMovie);
        final TextView txtTVShow = dialogview.findViewById(R.id.txtTVShow);
        final AlertDialog.Builder  builder = new AlertDialog.Builder(getContext(), R.style.MyDialogTheme);
        builder.setTitle("Choose option").setView(dialogview);
        final AlertDialog dialog = builder.create();
        txtMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxDialog((String) option[0]);
                dialog.dismiss();
            }
        });
        txtTVShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxDialog((String)option[1]);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void checkBoxDialog(String option){
        LayoutInflater layout = LayoutInflater.from(getActivity());
        final View dialogView = layout.inflate(R.layout.dialog_checkbox, null);
        final CheckBox cbJapan = dialogView.findViewById(R.id.cbJapan);
        final CheckBox cbKorean = dialogView.findViewById(R.id.cbKorean);
        final CheckBox cbAction = dialogView.findViewById(R.id.cbAction);
        final CheckBox cbCartoon = dialogView.findViewById(R.id.cbCartoon);
        final CheckBox cbRomantic = dialogView.findViewById(R.id.cbRomantic);
        final AlertDialog.Builder  builder = new AlertDialog.Builder(getContext(), R.style.MyDialogTheme);
        builder.setTitle("Choose "+option+" tab").setView(dialogView);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

}
