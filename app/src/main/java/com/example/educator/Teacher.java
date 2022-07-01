package com.example.educator;

public class Teacher extends User {

    public Teacher() {
    }

    public Teacher(String name, String password, String email, String imageURL, String classroom) {
        super(name, password, email, imageURL, classroom);
    }

    public Teacher(String name, String password, String email, String imageURL) {
        super(name, password, email, imageURL);
    }
}
