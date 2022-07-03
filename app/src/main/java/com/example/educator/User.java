package com.example.educator;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String Password;
    private String email;
    private String ImageURL;
    private String Classroom;

    public User() {
    }

    public User(String name, String password, String email, String imageURL, String classroom) {
        this.name = name;
        Password = password;
        this.email = email;
        ImageURL = imageURL;
        Classroom = classroom;
    }

    public User(String name, String password, String email, String imageURL) {
        this.name = name;
        Password = password;
        this.email = email;
        ImageURL = imageURL;
    }


    public String getClassroom() {
        return Classroom;
    }

    public void setClassroom(String classroom) {
        Classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}
