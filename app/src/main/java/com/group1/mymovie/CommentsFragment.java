package com.group1.mymovie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by LanAnh on 04/11/2017.
 */

public class CommentsFragment extends Fragment {
    RecyclerView rvComment;
    LinearLayoutManager layoutManager;
    CommentAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        rvComment = (RecyclerView) view.findViewById(R.id.rvComment);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new CommentAdapter(createListComments(), getContext());
        rvComment.setLayoutManager(layoutManager);
        rvComment.setAdapter(adapter);
        return view;
    }

    public ArrayList<Comment> createListComments(){
        ArrayList<Comment> list = new ArrayList<>();
        for(int i=0; i< 2; i++){
            list.add(new Comment(R.drawable.user_neko, "Lan Anh", "Phim rất hay, phù hợp với mọi lứa tuổi"));
            list.add(new Comment(R.drawable.user_shiro, "NaoCaLoc", "Tôi thấy hoa vàng trên cỏ xanh, thấy yên bình giấc mơ trong lành."));
        }
        return list;
    }
}
