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
 * Created by LanAnh on 05/11/2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {
    ArrayList<String> mVideoList = new ArrayList<>();
    Context mContext;

    public VideoAdapter(ArrayList<String> mVideoList, Context context) {
        this.mVideoList = mVideoList;
        mContext = context;
    }

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        VideoHolder holder = new VideoHolder(inflatedView);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        holder.txtName.setText(mVideoList.get(position));
        holder.btnPlay.setImageResource(R.drawable.btn_play_selector);
        Picasso.with(mContext).load(R.drawable.banner_your_name)
                .placeholder(R.drawable.default_landscape)
                .resize(Utilities.LANDSCAPE_WIDTH, (int)(Utilities.LANDSCAPE_WIDTH / Utilities.GOLDEN_RATIO))
        .into(holder.imgBanner);
    }

    @Override
    public int getItemCount() {
        return mVideoList.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtName;
        ImageView btnPlay;
        ImageView imgBanner;
        public VideoHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            btnPlay = (ImageView) itemView.findViewById(R.id.btnPlay);
            imgBanner = (ImageView) itemView.findViewById(R.id.imgBanner);
            btnPlay.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //Toast.makeText(mContext, "Item Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
