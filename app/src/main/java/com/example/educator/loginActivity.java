package com.example.educator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.security.interfaces.ECKey;

public class loginActivity extends AppCompatActivity {
    Button btn_signup, btn_login;
    EditText et_email_log, et_pass_log;
    int Role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent StudentIntent = new Intent(loginActivity.this, Profile.class);
        Intent TeacherIntent = new Intent(loginActivity.this, TeacherProfile.class);


        btn_signup = findViewById(R.id.btn_signup);
        btn_login = findViewById(R.id.btn_login);
        et_email_log = findViewById(R.id.et_email_log);
        et_pass_log = findViewById(R.id.et_pass_log);

        Role = getIntent().getIntExtra("Role", Role);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(Role);
                Intent intent = null;
                String Email = et_email_log.getText().toString();
                String Password = et_pass_log.getText().toString();
                if (ApplicationClass.verify(Email, Password, Role)) {
                    User user = ApplicationClass.findUserByEmail(Email, Role);
                    String name = user.getName();
                    String ImageURL = user.getImageURL();
                    if (Role == 0) {
                        intent = StudentIntent;
                    } else if (Role == 1) {
                        intent = TeacherIntent;
                    }
                    intent.putExtra("name", name);
                    intent.putExtra("URL", ImageURL);
                    startActivity(intent);
                } else {
                    Toast.makeText(loginActivity.this, "Check Your Info Again", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}
