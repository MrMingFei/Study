package com.thisAndSuper;

import com.sun.istack.internal.NotNull;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        if (null == in || in.trim().equals("")) {
            return;
        }

        System.out.println(unZip(in.toCharArray()));
    }

    private static String unZip(char[] input) {
        if (!checkInput(input, null)) {
            System.out.println("!error");
            return "";
        }

        StringBuilder strUnZip = new StringBuilder();
        int i = 0, len = input.length;

        while (i < len) {
            char c = input[i];
            if (Character.isDigit(c)) {
                StringBuilder countSb = new StringBuilder();
                countSb.append(c);

                char nextC = c;
                int nextI = i + 1;
                if (nextI < len && Character.isDigit(input[nextI])) {
                    char[] remain = new char[len - nextI];
                    System.arraycopy(input, nextI, remain, 0, (len - nextI));
                    nextC = findCount(remain, countSb);
                } else if (nextI < len) {
                    nextC = input[nextI];
                }

                int count = Integer.parseInt(countSb.toString());
                for (int s = 0; s < count; s++) {
                    strUnZip.append(nextC);
                }
                i = nextI + countSb.length();
            } else {
                strUnZip.append(c);
                i ++;
            }
        }
        return strUnZip.toString();
    }

    private static char findCount(char[] input, StringBuilder countSb) {
        int len = input.length;
        char c = input[0];
        if (len == 1) {
            return c;
        }

        countSb.append(c);
        char nextC = input[1];
        if (Character.isDigit(nextC)) {
            char[] remain = new char[len - 1];
            System.arraycopy(input, 1, remain, 0, len - 1);
            return findCount(remain, countSb);
        } else {
            return nextC;
        }
    }

    private static boolean checkInput(@NotNull char[] input, Character lastChar) {
        if (null == input || input.length == 0) {
            return false;
        }

        int len = input.length;
        char c = input[0];

        if (len == 1 && Character.isLowerCase(c)) {
            return true;
        }

        char[] remain = new char[len - 1];
        System.arraycopy(input, 1, remain, 0, len - 1);

        char nextC = input[1];
        boolean flag = false;
        if (Character.isDigit(c)) {

            if (Character.isLowerCase(nextC)) {
                if (null == lastChar && Integer.parseInt(String.valueOf(c)) > 2) {
                    flag = true;
                } else if (lastChar != null && Character.isDigit(lastChar)) {
                    flag = true;
                } else if (lastChar != null && Character.isLowerCase(lastChar)) {
                    if (Character.isLowerCase(nextC) && Integer.parseInt(String.valueOf(c)) > 2) {
                        flag = true;
                    } else if (Character.isDigit(nextC)) {
                        flag = true;
                    }
                }
            } else if (Character.isDigit(nextC)) {
                flag = true;
            }

        } else if (Character.isLowerCase(c)) {
            if (null == lastChar) {
                flag = true;
            } else if (Character.isLowerCase(lastChar)) {
                if (lastChar == c && lastChar != nextC) {
                    flag = true;
                } else if (lastChar != c) {
                    flag = true;
                }
            } else if (Character.isDigit(lastChar) && c != nextC) {
                flag = true;
            }
        }

        return flag && checkInput(remain, c);
    }
}
