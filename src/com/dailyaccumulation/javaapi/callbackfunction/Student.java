package com.dailyaccumulation.javaapi.callbackfunction;

public class Student {

    private String name;

    public Student(String name){
        this.name = name;
    }

    public void setName(String naem){
        this.name = naem;
    }

    public void callHelp(int a, int b){
        new SuperCalculator().add(a, b, new DoHomeWork());
    }

    public class DoHomeWork implements DoJob{

        public void fillBlank(int a, int b, int result){
            System.out.println(name + "求助小红计算：" + a + " + " + b + " = " + result);
        }
    }

}
