package com.thinkInJava.sixthchapter;

// Only one public class allowed per file:
public class Lunch {
    void testPrivate(){
        // Can`t do this! Private constructor
        // Soup1 soup1 = new Soup1();
    }
    void testStatic(){
        Soup1 soup1 = Soup1.makeSoup();
    }
    void testSingleton(){
        Soup2.access().f();
    }
}
class Soup1{
    private Soup1(){}
    // (1)Allow creation via static method:
    public static Soup1 makeSoup(){
        return new Soup1();
    }
}
class Soup2{
    private Soup2(){}
    // (2)Create a static object and return a reference
    // upon request.(The "Singleton" theory):
    private static Soup2 s2 = new Soup2();
    public static Soup2 access(){
        return s2;
    }
    public void f(){}
}
