package com.Interview;

import java.util.*;

public class aggregateOperation {
    public static String[] union(String[] arr1, String[] arr2){
        Set<String> set = new HashSet<String>();
        for (String s : arr1){
            set.add(s);
        }
        for (String s : arr2){
            set.add(s);
        }
        return set.toArray(new String[]{});
    }

    public static void main(String[] args){
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"b", "c", "d", "e"};

        String[] result = union(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}
