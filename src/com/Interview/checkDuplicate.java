package com.Interview;

public class checkDuplicate {
    public static void main(String[] args){
        String string = "QWERT";
        checkDuplicate demo = new checkDuplicate();
        //boolean check = demo.checkRepeatChar(string);
        boolean check1 = demo.checkDuplicateChar(string);

        if (check1)
        {
            System.out.println("Contains duplicate characters");
        }
        else {
            System.out.println("Not duplicate characters");
        }
    }
    private boolean checkDuplicateChar(String str){
        int[] a = new int [256];
        int len = str.length(), i;
        char[] elements = str.toCharArray();
        if (len > 256)
        {
            return true;
        }
        for (i = 0; i < len; i++)
        {
            int x = elements[i];
            a[x] ++;
            if (a[x] > 1)
            {
                return true;
            }
        }
        return false;
    }

    boolean checkRepeatChar(String str){
        if(str==null||str.isEmpty()){
            return false;
        }
        char[] elements=str.toCharArray();
        for(char e:elements){
            if(str.indexOf(e)!=str.lastIndexOf(e)){
                return true;
            }
        }
        return false;
    }
}
