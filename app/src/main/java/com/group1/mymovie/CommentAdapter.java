package com.group1.mymovie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by LanAnh on 06/11/2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {
    ArrayList<Comment> mList = new ArrayList<>();
    Context mContext;

    public CommentAdapter(ArrayList<Comment> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        CommentHolder holder = new CommentHolder(inflatedView);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        Picasso.with(mContext).load(mList.get(position).getPhoto()).resize(120,120).into(holder.imgPhoto);
        holder.txtName.setText(mList.get(position).getName());
        holder.txtComment.setText(mList.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
        CircleImageView imgPhoto;
        TextView txtName;
        TextView txtComment;
        public CommentHolder(View itemView) {
            super(itemView);
            imgPhoto = (CircleImageView) itemView.findViewById(R.id.imgPhoto);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtComment = (TextView) itemView.findViewById(R.id.txtComment);
        }
    }
}
