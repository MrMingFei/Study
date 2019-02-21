package com.Interview.thirdchapter;

public class RegularExpressionMatch {

    public boolean match(char[] str, char[] pattern){
        if (str == null || pattern == null)
            return false;

        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int s, char[] pattern, int p){
        if (str.length <= s && pattern.length <= p)
            return true;
        if (str.length > s && pattern.length <= p)
            return false;

        //当前pattern的下一个是*时
        if (p+1 < pattern.length && pattern[p+1] == '*'){
            if (str.length <= s){
                return matchCore(str, s, pattern, p+2);
            }else {
                if (pattern[p] == str[s] || pattern[p] == '.'){
                    return matchCore(str, s+1, pattern, p+2) ||
                            matchCore(str, s+1, pattern, p) ||
                            matchCore(str, s, pattern, p+2);
                }else {
                    return matchCore(str, s, pattern, p+2);
                }
            }
        }

        //当前pattern的下一个不是*时
        if (s >= str.length)
            return false;
        else {
            if (str[s] == pattern[p] || pattern[p] == '.'){
                return matchCore(str, s+1, pattern, p+1);
            }
        }
        return false;
    }
}
