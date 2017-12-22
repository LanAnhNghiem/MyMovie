package com.group1.mymovie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by LanAnh on 04/11/2017.
 */

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastHolder> {
    ArrayList<Cast> mCastList = new ArrayList<>();
    Context mContext;
    int mWidth, mHeight;

    public CastAdapter(ArrayList<Cast> mCastList, Context context, int width, int height) {
        this.mCastList = mCastList;
        this.mContext = context;
        this.mWidth = width;
        this.mHeight = height;
    }

    @Override
    public CastHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cast, viewGroup, false);
        CastHolder holder = new CastHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CastHolder castHolder, int i) {
        Picasso.with(mContext).load(mCastList.get(i).getPhoto())
                .placeholder(R.drawable.default_portrait)
                .resize(mWidth,mHeight)
                .into(castHolder.imgPhoto);
        castHolder.txtName.setText(mCastList.get(i).getName());
        castHolder.txtName.setWidth(mWidth);
        castHolder.txtCharacter.setText(mCastList.get(i).getCharacter());
    }

    @Override
    public int getItemCount() {
        return mCastList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class CastHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView txtName;
        TextView txtCharacter;
        public CastHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.imgPhoto);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtCharacter = (TextView) itemView.findViewById(R.id.txtCharacter);
        }
    }
}
