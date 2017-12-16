package com.group1.mymovie;

import android.content.res.Resources;

/**
 * Created by LanAnh on 01/11/2017.
 */

public class Utilities {
    public static int SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static int LANDSCAPE_WIDTH = (int)(SCREEN_WIDTH / 2 - 50);
    public static int PORTRAIT_WIDTH = (int)(SCREEN_WIDTH / 2 - 120);
    public static int SMALL_WIDTH = (int)(SCREEN_WIDTH / 4);
    public static double GOLDEN_RATIO = 1.618;
    public static String YOUTUBE_API_KEY = "AIzaSyALnLC5LsLjLUke8oUPNkHohxev7rpKLns";
}
