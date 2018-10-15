package com.dailyaccumulation.javaapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareWithComparator {
    public static void main(String[] args){
        List<User> list = new ArrayList<User>();
        list.add(new User(1, 21, "Lee"));
        list.add(new User(2, 21, "Zhao"));
        list.add(new User(3, 23, "Song"));
        list.add(new User(4, 19, "Liu"));

        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getAge() == o2.getAge())
                    return o1.getUserId() - o2.getUserId();
                else
                    return o1.getAge() - o2.getAge();
            }
        });

        for (User user : list){
            System.out.println(user);
        }
    }
}

class User{
    private int userId;
    private int age;
    private String name;

    public User(int userId, int age, String name){
        this.age = age;
        this.name = name;
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.userId + ", " + this.age + ", " + this.name;
    }
}
