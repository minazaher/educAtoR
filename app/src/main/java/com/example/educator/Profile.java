package com.example.educator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Profile extends AppCompatActivity {
        TextView userName;
        ImageView img;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userName = findViewById(R.id.tv_userName);
        img = findViewById(R.id.img_user);

        String Name = getIntent().getStringExtra("name");
        String URL = getIntent().getStringExtra("URL");

        userName.setText(Name);
            Glide.with(this).asBitmap().load(URL).into(img);
    }
}