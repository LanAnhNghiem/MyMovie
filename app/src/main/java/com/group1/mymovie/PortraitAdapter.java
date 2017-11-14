package com.group1.mymovie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by LanAnh on 03/11/2017.
 */

public class PortraitAdapter extends RecyclerView.Adapter<PortraitAdapter.PortraitHolder> {
    Context mContext;
    ArrayList<Movie> mList = new ArrayList<>();
    boolean mIsPaddingTop = false;
    public PortraitAdapter(ArrayList<Movie>list, Context context, boolean isPaddingTop) {
        this.mList = list;
        this.mContext = context;
        this.mIsPaddingTop = isPaddingTop;
    }

    @Override
    public PortraitHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_portrait, parent, false);
        PortraitHolder holder = new PortraitHolder(inflatedView);
        return holder;
    }

    @Override
    public void onBindViewHolder(PortraitHolder holder, int i) {
        if(mIsPaddingTop == true && (i == 0 || i == 1)){
            holder.paddingTop.setVisibility(View.VISIBLE);
        }
        Picasso.with(mContext).load(mList.get(i).getPoster())
                .placeholder(R.drawable.default_portrait)
                .resize(Utilities.LANDSCAPE_WIDTH, (int)(Utilities.LANDSCAPE_WIDTH*1.3))
                .into(holder.imgPoster);
        holder.txtName.setText(mList.get(i).getName());
        holder.txtGenre.setText(mList.get(i).getGenre());
        holder.txtRating.setText(String.valueOf(mList.get(i).getRating()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class PortraitHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPoster;
        TextView txtRating;
        TextView txtGenre;
        TextView txtName;
        TextView paddingTop;
        public PortraitHolder(View itemView) {
            super(itemView);
            imgPoster = (ImageView) itemView.findViewById(R.id.imgPoster);
            txtRating = (TextView) itemView.findViewById(R.id.txtRating);
            txtGenre = (TextView) itemView.findViewById(R.id.txtGenre);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            paddingTop = (TextView) itemView.findViewById(R.id.paddingTop);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
    }
}
