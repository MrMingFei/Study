package com.thinkInJava.seventeenthchapter;

public class TestParam {
    public final int size;
    public final int loops;
    public TestParam(int size, int loops){
        this.size = size;
        this.loops = loops;
    }

    public static TestParam[] array(int... values){
        int size = values.length >> 1;
        TestParam[] result = new TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++){
            result[i] = new TestParam(values[n++], values[n++]);
        }
        return result;
    }

    public static TestParam[] array(String[] values){
        int[] val = new int[values.length];
        for (int i = 0; i < values.length; i++){
            val[i] = Integer.decode(values[i]);
        }
        return array(val);
    }
}
