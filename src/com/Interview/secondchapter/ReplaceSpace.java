package com.Interview.secondchapter;

public class ReplaceSpace {
    public static String replaceSpace(char[] string){
        if (string.length < 0 || string == null){
            return null;
        }
        int originalLength = string.length;
        int spaceCount = 0;
        for (int i = 0; i < originalLength; i++){
            if (string[i] == ' '){
                spaceCount++;
            }
        }
        int newLength = originalLength + (spaceCount << 1);
        char[] temp = new char[newLength];
        int indexOfOriginal = originalLength-1;
        int indexOfNew = newLength-1;
        while (indexOfOriginal >= 0 && indexOfOriginal < originalLength){
            if (string[indexOfOriginal] == ' '){
                temp[indexOfNew--] = '0';
                temp[indexOfNew--] = '2';
                temp[indexOfNew--] = '%';
            }else {
                temp[indexOfNew--] = string[indexOfOriginal];
            }
            indexOfOriginal--;
        }
        return new String(temp);
    }

    public static void main(String[] args){
        String string = "We are happy";
        String newString = replaceSpace(string.toCharArray());
        System.out.println(newString);
    }
}
