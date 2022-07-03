package com.example.educator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        String Email = getIntent().getStringExtra("Email");
        User u = ApplicationClass.findUserByEmail(Email, 1);

        tv_name.setText(u.getName());
        Glide.with(this).asBitmap().load(u.getImageURL()).into(img);

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
