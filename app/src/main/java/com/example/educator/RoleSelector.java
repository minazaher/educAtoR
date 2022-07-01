package com.example.educator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class RoleSelector extends AppCompatActivity {
    LinearLayout teacher, student;
    int Role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_selector);

        teacher = findViewById(R.id.teacher_card);
        student = findViewById(R.id.student_card);

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoleSelector.this, loginActivity.class);
                Role = 1;
                intent.putExtra("Role", Role);
                startActivity(intent);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoleSelector.this, loginActivity.class);
                Role = 0;
                intent.putExtra("Role", Role);
                startActivity(intent);
            }
        });
    }
}
