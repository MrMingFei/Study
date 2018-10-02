package com.Interview.fifthchapter;

public class MaxNoRepeatString {
    public static void main(String[] args){
        System.out.println(longestSubstringWithoutRepeat("arabcacfr"));
    }
    /**
     * 寻找最长不含重复字符的字符串
     * @param str
     * @return
     */
    public static int longestSubstringWithoutRepeat(String str){
        if (str == null || str.equals(""))
            return 0;
        int maxLength = 0;
        int curLength = 0;

        int[] positions = new int[26];
        for (int i = 0; i < positions.length; i++){
            positions[i] = -1;
        }
        for (int i = 0; i < str.length(); i++){
            int preIndex = positions[str.charAt(i)-'a'];
            //当前字符与它上次出现位置之间的距离
            int distance = i-preIndex;
            if (preIndex < 0 || distance > curLength)
                curLength++;
            else {
                if (curLength > maxLength)
                    maxLength = curLength;
                curLength = distance;
            }
            positions[str.charAt(i)-'a'] = i;
        }
        if (curLength > maxLength)
            maxLength = curLength;
        return maxLength;
    }
}
