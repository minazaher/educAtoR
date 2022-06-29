package com.example.educator;

import java.util.Objects;

public class Student {
    private String Name;
    private String Email;
    private String Password;
    private String ImgUrl;

    public Student(String name, String email, String password, String imgUrl) {
        Name = name;
        Email = email;
        Password = password;
        ImgUrl = imgUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", ImgUrl='" + ImgUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Name.equals(student.Name) && Email.equals(student.Email) && Password.equals(student.Password) && Objects.equals(ImgUrl, student.ImgUrl);
    }


}
