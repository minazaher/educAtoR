package com.example.educator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    Button btn_signup, btn_login;
    EditText et_email_log, et_pass_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_signup = findViewById(R.id.btn_signup);
        btn_login = findViewById(R.id.btn_login);
        et_email_log = findViewById(R.id.et_email_log);
        et_pass_log = findViewById(R.id.et_pass_log);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Student s:ApplicationClass.students) {
                    if (et_email_log.getText().toString().equals(s.getEmail()) || et_pass_log.getText().toString().equals(s.getPassword()))
                    {
                        String name = s.getName();
                        String URL = s.getImgUrl();
                        Intent intent = new Intent(loginActivity.this, Profile.class);
                        intent.putExtra("name", name);
                        intent.putExtra("URL", URL);
                        startActivity(intent);

                    }
                    else if (!et_pass_log.getText().toString().equals(s.getPassword())){
                        Toast.makeText(loginActivity.this, "Password is Wrong ", Toast.LENGTH_SHORT).show();
                    }
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