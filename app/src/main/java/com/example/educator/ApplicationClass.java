package com.example.educator;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Student> students = new ArrayList<Student>();

    @Override
    public void onCreate() {
        super.onCreate();

        Student mina = new Student("Mina", "menazaher115@gmail.com", "01228043127", "https://scontent.fcai20-4.fna.fbcdn.net/v/t39.30808-6/274154586_489410356134153_5054988907904159274_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=174925&_nc_ohc=zKFJNqauxHsAX-VPwgT&_nc_ht=scontent.fcai20-4.fna&oh=00_AT80tuEa1cbgRTaf2nL-QEgW275J0AiyuWZxiYu6jvz3wQ&oe=62C03CA4");
        students.add(mina);
    }
}
