package com.dailyaccumulation.javaapi;

import java.util.*;

public class CompareWithComparable {

    public static void main(String[] args){
        List<UserInfo> list = new ArrayList<UserInfo>();
        list.add(new UserInfo(1, 21, "Lee"));
        list.add(new UserInfo(2, 21, "Zhao"));
        list.add(new UserInfo(3, 23, "Song"));
        list.add(new UserInfo(4, 19, "Liu"));

        Collections.sort(list);

        for (UserInfo user : list){
            System.out.println(user.toString());
        }
    }
}

class UserInfo implements Comparable<UserInfo>{
    private int userId;
    private int age;
    private String name;

    public UserInfo(int userId, int age, String name){
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

    @Override
    public int compareTo(UserInfo o) {
        if ((this.age - o.age) == 0)
            return this.userId - o.userId;
        else
            return this.age - o.age;
    }
}
