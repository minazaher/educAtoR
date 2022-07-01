package com.example.educator;

import java.util.Objects;

public class Student extends User {


    public Student() {
    }

    public Student(String name, String password, String email, String imageURL, String classroom) {
        super(name, password, email, imageURL, classroom);
    }


    public Student(String name, String password, String email, String imageURL) {
        super(name, password, email, imageURL);
    }

}
