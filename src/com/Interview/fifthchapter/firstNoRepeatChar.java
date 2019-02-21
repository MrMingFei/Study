package com.Interview.fifthchapter;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class firstNoRepeatChar {

    public static void main(String[] args){
        firstNoRepeatChar fnrc = new firstNoRepeatChar();
        ArrayList<String> list=new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        String str = "We are Student";
        String str1 = "aeiou";
        for (int i = 0; i < 10; i++) {
            list.add(""+i);
        }
        for (int i = 0; i < str.length(); i++){
            set.add(String.valueOf(str.charAt(i)));
        }
        String[] array= list.toArray(new String[list.size()]);
        String[] array1 = set.toArray(new String[set.size()]);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));
        fnrc.deleteChars(str, str1);
    }

    private int[] hashTable = new int[256];
    private StringBuffer buffer = new StringBuffer();

    /**
     * 借助数组实现哈希表
     * @param str
     * @return
     */
    public char getChar(String str){
        if (str.length() == 0 || str.equals(""))
            return '0';
        int[] arr = new int[26];
        int len = str.length();
        //防止出现大小写混乱的情况，ASCII码中大小写是不同的
        str = str.toLowerCase();
        for (int i = 0; i < len; i++){
            //纯小写减去'a'的的ASCII码，使用长度为26的数组即可
            arr[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len; i++){
            if (arr[str.charAt(i) - 'a'] == 1){
                return str.charAt(i);
            }
        }
        return '0';
    }

    /**
     * 使用hashMap
     * @param str
     * @return
     */
    public char getChar_V2(String str){
        if (str.length() == 0 || str.equals(""))
            return '0';
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = str.length();
        //防止出现大小写混乱的情况，ASCII码中大小写是不同的
        str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < len; i++){
            if (map.containsKey(str.charAt(i))){
                count = map.get(str.charAt(i));
                map.put(str.charAt(i), ++count);
            }else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < len; i++){
            if (map.get(str.charAt(i)) == 1){
                return str.charAt(i);
            }
        }
        return '0';
    }

    /**
     * 从一个字符中删除另一个字符出现的字符
     * @param str1
     * @param str2
     */
    public void deleteChars(String str1, String str2){
        if (str1 == null || str2 == null)
            return;
        int[] arr = new int[256];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str2.length(); i++){
            arr[str2.charAt(i)] = 1;
        }
        for (int i = 0; i < str1.length(); i++){
            if (arr[str1.charAt(i)] < 1){
                sb.append(str1.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    /**
     * 使用一个boolean型的数组去重
     * @param str
     */
    public void removeRepeatChars(String str){
        if (str.length() == 0 || str == null)
            return;
        boolean[] arr = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            arr[i] = true;
        }
        for (int i = 0; i < str.length(); i++){
            if (arr[str.charAt(i)]){
                sb.append(str.charAt(i));
                arr[str.charAt(i)] = false;
            }
        }
        System.out.println(sb.toString());
    }

    /**
     * 利用set的特点进行去重
     * @param str
     */
    public void removeRepeatChars_V2(String str){
        if (str == null || str.length() == 0)
            return;
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < str.length(); i++){
            set.add(String.valueOf(str.charAt(i)));
        }
        str = StringUtils.join(set,"" );
        System.out.println(str);
    }

    /**
     * 判断两个单词是否为变位词
     * @param str1
     * @param str2
     * @return
     */
    public boolean isAnagram(String str1, String str2){

        int[] arr = new int[26];
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 != len2)
            return false;
        for (int i = 0; i < len1; i++){
            arr[str1.charAt(i) - 'a']++;
        }
        for (int j = 0; j < len2; j++){
            arr[str2.charAt(j) - 'a']--;
        }
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0)
                return false;
        }
        return true;
    }

    /**
     * 插入字符
     * @param ch
     */
    public void insert(char ch){
        buffer.append(ch);
        if (hashTable[ch] == 0){
            hashTable[ch] = 1;
        }else {
            hashTable[ch] = hashTable[ch] + 1;
        }
    }

    /**
     * 获得字符流中第一个只出现一次的字符
     * @return
     */
    public char getCharInSequence(){
        char[] temp = buffer.toString().toCharArray();
        for (char ch : temp){
            if (hashTable[ch] == 1)
                return ch;
        }
        return '#';
    }
}
