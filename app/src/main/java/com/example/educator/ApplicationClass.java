package com.example.educator;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Teacher> teachers = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        Teacher Amr = new Teacher("Amr", "1212", "gg@ez.com", "https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/3baed5b730c0b82c272bab1cdcff7c90~c5_720x720.jpeg?x-expires=1656752400&x-signature=Ua9fW8MN3BqtzdiRiKYYa1ngUYo%3D");
        teachers.add(Amr);

        Student mina = new Student("Mina", "01228043127", "menazaher115@gmail.com", "https://scontent.fcai20-4.fna.fbcdn.net/v/t39.30808-6/274154586_489410356134153_5054988907904159274_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=174925&_nc_ohc=zKFJNqauxHsAX-VPwgT&_nc_ht=scontent.fcai20-4.fna&oh=00_AT80tuEa1cbgRTaf2nL-QEgW275J0AiyuWZxiYu6jvz3wQ&oe=62C03CA4");
        students.add(mina);
    }

    public static User findUserByEmail(String email, int Role) {
        User user = new User();
        if (Role == 0) {
            for (Student s : students) {
                if (email.equals(s.getEmail())) {
                    user = s;
                    break;
                }
            }
        } else if (Role == 1) {
            for (Teacher t : teachers) {
                if (email.equals(t.getEmail())) {
                    user = t;
                    break;
                }
            }
        }
        return user;
    }

    public static boolean verify(String email, String password, int Role) {
        boolean Verified = false;
        if (Role == 0) {
            for (Student s : students) {
                if (s.getEmail().equals(email)) {
                    User user = findUserByEmail(email, 0);
                    if (user.getPassword().toString().equals(password)) {
                        Verified = true;
                    }
                }
            }
        } else if (Role == 1) {
            for (Teacher t : teachers) {
                if (t.getEmail().equals(email)) {
                    User user = findUserByEmail(email, 1);
                    if (user.getPassword().toString().equals(password)) {
                        Verified = true;
                    }
                }
            }
        }
        return Verified;
    }
}