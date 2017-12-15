package com.group1.mymovie;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import tcking.github.com.giraffeplayer2.VideoView;

import static com.group1.mymovie.R.id.viewPager;

public class DetailActivity extends AppCompatActivity{
    ViewPager mViewPager;
    TabLayout mTabLayout;
    ViewPagerAdapter mAdapter;
    ImageView btnBack, btnShare, btnSubtitle, btnPlay, imgBanner;
    VideoView videoView;
    CardView itemStar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mViewPager = (ViewPager) findViewById(viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        setupViewPager(mViewPager);

        //videoView = (VideoView) findViewById(R.id.videoView);

        imgBanner = (ImageView) findViewById(R.id.imgBanner);
        itemStar = (CardView) findViewById(R.id.itemStar);

        btnBack = (ImageView) findViewById(R.id.btnBack);
        btnBack.setImageResource(R.drawable.btn_back_selector);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
//                if(videoView.getVisibility() == View.VISIBLE){
//                    videoView.getPlayer().stop();
//                    imgBanner.setVisibility(View.VISIBLE);
//                    btnPlay.setVisibility(View.VISIBLE);
//                    itemStar.setVisibility(View.VISIBLE);
//                }
            }
        });
        btnShare = (ImageView) findViewById(R.id.btnShare);
        btnShare.setImageResource(R.drawable.btn_share_selector);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"Facebook", "Messenger", "Twitter"};
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this, R.style.Dialog);
                builder.setTitle("Share with")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                            }
                        }).create().show();
            }
        });
        btnSubtitle = (ImageView) findViewById(R.id.btnSubtitle);
        btnSubtitle.setImageResource(R.drawable.btn_subtitle_selector);
        btnSubtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"English", "Vietnamese", "Japanese"};
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this, R.style.Dialog);
                builder.setTitle("Choose subtitle language")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                            }
                        }).create().show();
            }
        });
        btnPlay = (ImageView) findViewById(R.id.btnPlay);
        btnPlay.setImageResource(R.drawable.btn_play_selector);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1);
//                imgBanner.setVisibility(View.INVISIBLE);
//                btnPlay.setVisibility(View.GONE);
//                videoView.setVisibility(View.VISIBLE);
//                itemStar.setVisibility(View.GONE);
//                videoView.getVideoInfo().setFullScreenAnimation(true).setPortraitWhenFullScreen(false).setTitle("Test video");
//                videoView.setVideoPath("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4").getPlayer().start();
            }
        });
    }

    public void setupViewPager(ViewPager viewPager){
        mAdapter.addFragment(new InfoFragment(), "Info");
        mAdapter.addFragment(new VideosFragment(), "Videos");
        mAdapter.addFragment(new CommentsFragment(), "Comments");
        viewPager.setAdapter(mAdapter);
    }

}
