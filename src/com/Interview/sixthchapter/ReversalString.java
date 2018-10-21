package com.Interview.sixthchapter;

public class ReversalString {
    public static void main(String[] args){
        String str = "student.";
        ReversalString rs = new ReversalString();
        System.out.println(rs.leftRotateString(str, 3));
    }

    /**
     * 左旋转字符串
     * @param str
     * @param n
     * @return
     */
    public String leftRotateString(String str, int n){
        //当n大于str的长度时，可以用取余确定旋转的位数，当n是负数时当作右旋转处理
        if (str == null || str.length() < 2 || str.length() <= n){
            return str;
        }

        StringBuffer sb = new StringBuffer(str);
        String str1 = reversal(str, 0, n-1);
        String str2 = reversal(str1, n, str.length()-1);
        String str3 = reversal(str2, 0, str.length()-1);

        return str3;
    }

    /**
     * 翻转单词
     * @param str
     * @return
     */
    public String reverseSentence(String str){
        int len = str.length();
        if (len <= 0 || str == null)
            return null;
        str = reversal(str, 0, len-1);
        int start = 0;
        int end = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < len; i++){
            while (i < len && chars[i] == ' '){
                i++;
            }
            start = i;
            end = start;
            while (i < len && chars[i] != ' '){
                i++;
            }
            end = i - 1;
            str = reversal(str, start, end);
        }
        return str;
    }

    /**
     * 翻转字符串
     * @param str
     * @param start
     * @param end
     * @return
     */
    private String reversal(String str, int start, int end){
        if (str == null || str.length() <= 0)
            return null;

        char[] chars = str.toCharArray();

        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        String rStr = new String(chars);
        return rStr;
    }
}
