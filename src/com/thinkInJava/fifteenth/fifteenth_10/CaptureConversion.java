package com.thinkInJava.fifteenth.fifteenth_10;

import static net.mindview.util.Print.print;

public class CaptureConversion {
    static <T> void f1(Holder<T> holder){
        T t = holder.getValue();
        print(t.getClass().getSimpleName());
    }
    static void f2(Holder<?> holder){
        f1(holder);//f1需要一个参数类型
    }
}
