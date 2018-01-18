package com.group1.mymovie;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView txtChangeAvatar, txtReset;
    CardView btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txtChangeAvatar = (TextView) findViewById(R.id.changeAvatar);
        txtReset = (TextView) findViewById(R.id.reset);
        btnSave = (CardView) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        txtChangeAvatar.setPaintFlags(txtChangeAvatar.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        txtReset.setPaintFlags(txtReset.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
    }
}
