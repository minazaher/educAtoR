package com.example.educator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TeacherProfile extends AppCompatActivity {
    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    TextView tv_name;
    ImageView img;
    FloatingActionButton btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);


        tv_name = findViewById(R.id.tv_teacherName);
        img = findViewById(R.id.img_teacher);
        recyclerView = findViewById(R.id.recview);
        btn_add = findViewById(R.id.btn_add);

        StudentAdapter adapter = new StudentAdapter(ApplicationClass.students, this);
        recyclerView.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String URL = getIntent().getStringExtra("URL");
        String Name = getIntent().getStringExtra("name");
        tv_name.setText(Name);
        Glide.with(this).asBitmap().load(URL).into(img);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherProfile.this, SignUpActivity.class);
                startActivity(intent);

            }
        });
    }

    public void notifyData() {

        adapter.notifyDataSetChanged();
    }
}
