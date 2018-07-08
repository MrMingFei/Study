package com.thinkInJava.mylibraries;

public class Range {
    // Produce a sequence [0...n)
    public static int[] range(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        return a;
    }

    //Produce a sequence {start...end)
    public static int[] range(int start, int end) {
        int le = end - start;
        int[] a = new int[le];
        for (int i = 0; i < le; i++) {
            a[i] = start + i;
        }
        return a;
    }
    //Produce a sequence [start...end) increment by step
    public static int[] range(int start, int end, int step){
        int le = (end - start)/step;
        int[] a = new int[le];
        for (int i = 0; i < le; i++){
            a[i] = start + (i * step);
        }
        return a;
    }
}
