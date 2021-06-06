package com.dailyaccumulation.theory;

public class ObjectRef {

    //基本类型的参数传递
    public static void testBasicType(int i) {
        System.out.println("i = " + i);

        i = 100;

        System.out.println("i = " + i);
    }

    //参数为对象，使用原参数引用
    public static void add(StringBuffer s)
    {
        s.append("_add");
    }

    //参数为对象，创建新的对象覆盖参数引用
    public static void changeRef(StringBuffer s)
    {
        s = new StringBuffer("Java");
        System.out.println(s);
    }

    public static void swap(Car car1, Car car2){
        /**
         * 此处直接操作引用（上面两个方法操作的是引用所指向的实例的属性），在swap方法内可以改变引用指向的对象
         * 但因为传参进来的是引用副本，所以并不影响函数调用出的引用指向的实例。
         * 这里引申出一个问题，当不知道类的成员又要交换两个对象，可以用封装类解决问题。
         */
        Car temp = car1;
        car1 = car2;
        car2 = temp;

        car1.print();
        car2.print();
    }

    public static void main(String[] args)
    {
        int i = 50;
        testBasicType(i);
        System.out.println(i);

        StringBuffer sMain = new StringBuffer("init");
        System.out.println("sMain = " + sMain.toString());
        add(sMain);
        System.out.println("sMain = " + sMain.toString());
        changeRef(sMain);
        System.out.println("sMain = " + sMain.toString());

        Car car1 = new Car(101, 1);
        Car car2 = new Car(202, 2);
        swap(car1, car2);
        car1.print();
        car2.print();
    }
}

class Car{
    int no;
    int model;

    public Car(int no, int model){
        this.no = no;
        this.model = model;
    }

    public void print(){
        System.out.println("No: " + no + " Model: " + model);
    }
}
