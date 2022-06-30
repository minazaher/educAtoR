package com.example.educator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
                String Email = et_email_log.getText().toString();
                String Password = et_pass_log.getText().toString();
                if (ApplicationClass.verify(Email, Password)) {
                    Student student = ApplicationClass.findStudentByEmail(Email);
                    String name = student.getName();
                    String URL = student.getImgUrl();
                    Intent intent = new Intent(loginActivity.this, Profile.class);
                    intent.putExtra("name", name);
                    intent.putExtra("URL", URL);
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
