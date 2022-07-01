package com.example.educator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    Button btn_create;
    EditText et_name, et_pass, et_passConfirm, et_img,et_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et_name = findViewById(R.id.et_Name);
        et_pass = findViewById(R.id.et_pass);
        et_passConfirm = findViewById(R.id.et_pass_confirm);
        et_img = findViewById(R.id.et_img);
        et_email = findViewById(R.id.et_email);
        btn_create= findViewById(R.id.btn_create);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_name.getText().equals(null)||et_pass.getText().equals(null)||et_email.getText().equals(null)||et_passConfirm.getText().equals(null))
                {
                    Toast.makeText(SignUpActivity.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (et_pass.getText().toString().equals(et_passConfirm.getText().toString())){
                        Student student = new Student(et_name.getText().toString(), et_email.getText().toString(), et_pass.getText().toString(), et_img.getText().toString());
                        Toast.makeText(SignUpActivity.this, "Account Created Successfully ", Toast.LENGTH_SHORT).show();
                        ApplicationClass.students.add(student);
                        Intent intent = new Intent(SignUpActivity.this, loginActivity.class);
                        TeacherProfile.recyclerView.getAdapter().notifyDataSetChanged();
                        System.out.println(ApplicationClass.students.toString());

                    }else{
                        Toast.makeText(SignUpActivity.this, "Password Not Correct", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}