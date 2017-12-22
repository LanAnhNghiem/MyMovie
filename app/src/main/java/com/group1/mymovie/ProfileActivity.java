package com.group1.mymovie;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView txtChangeAvatar, txtReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txtChangeAvatar = (TextView) findViewById(R.id.changeAvatar);
        txtReset = (TextView) findViewById(R.id.reset);
        txtChangeAvatar.setPaintFlags(txtChangeAvatar.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        txtReset.setPaintFlags(txtReset.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
    }
}
