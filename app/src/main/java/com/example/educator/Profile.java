package com.example.educator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Profile extends AppCompatActivity {
    TextView userName;
    ImageView img;
    View chem_AR, bio_AR, geo_AR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userName = findViewById(R.id.tv_userName);
        img = findViewById(R.id.img_user);
        chem_AR = findViewById(R.id.chem_AR);

        String Name = getIntent().getStringExtra("name");
        String URL = getIntent().getStringExtra("URL");
        userName.setText(Name);

        Glide.with(this).asBitmap().load(URL).into(img);

        chem_AR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, com.example.educator.chem_AR.class);
                startActivity(intent);
            }
        });
    }


}