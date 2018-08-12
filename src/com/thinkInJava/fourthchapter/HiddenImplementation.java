package com.thinkInJava.fourthchapter;

import com.thinkInJava.fourthchapter.interfacea.A;
import com.thinkInJava.fourthchapter.packageaccess.HIddenC;

import java.lang.reflect.Method;

import static net.mindview.util.Print.print;

public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HIddenC.makeA();
        a.f();
        print(a.getClass().getName());
        // Error: 在包的外部没有C类型可以用
        /*if (a instanceof C) {
            C c = (C) a;
            c.g();
        }*/
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }
    static void callHiddenMethod(Object obj, String methodName) throws Exception {
        Method m = obj.getClass().getDeclaredMethod(methodName);
        m.setAccessible(true);
        m.invoke(obj);
    }
}
