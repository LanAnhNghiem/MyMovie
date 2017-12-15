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
 * Created by LanAnh on 09/11/2017.
 */

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowHolder> {
    ArrayList<Integer> list = new ArrayList<>();
    Context context;
    boolean isPaddingTop =false;

    public ShowAdapter(ArrayList<Integer> list, Context context, boolean isPaddingTop) {
        this.list = list;
        this.context = context;
        this.isPaddingTop = isPaddingTop;
    }

    @Override
    public ShowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_landscape, parent, false);
        ShowHolder holder = new ShowHolder(inflatedView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShowHolder holder, int position) {
        if(isPaddingTop == true && (position == 0))
        {
            holder.paddingTop.setVisibility(View.VISIBLE);
        }
        Picasso.with(context).load(list.get(position))
                .placeholder(R.drawable.default_landscape)
                .resize(Utilities.LANDSCAPE_WIDTH + 40, (int)((Utilities.LANDSCAPE_WIDTH + 40)/ Utilities.GOLDEN_RATIO)).into(holder.imgBanner);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ShowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgBanner;
        TextView paddingTop;
        public ShowHolder(View itemView) {
            super(itemView);
            imgBanner = (ImageView)itemView.findViewById(R.id.imgBanner);
            paddingTop = (TextView) itemView.findViewById(R.id.paddingTop);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
