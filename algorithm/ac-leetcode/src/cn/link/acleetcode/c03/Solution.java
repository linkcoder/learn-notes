package cn.link.acleetcode.c03;

import java.util.*;

/**
 * 题目：无重复字符的最长子串
 * 内容：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Map<Character,Integer> charWithIndex = new HashMap<>(s.length());

        int result = 0;
        for(int i=0, j=0; j<len;j++){

            if(charWithIndex.containsKey(s.charAt(j))){
                //abcbad -> j 指向第二个a，防止 i往回跳，使用max
                i = Math.max(charWithIndex.get(s.charAt(j)), i);
            }
            result = Math.max(result, j+1-i);
            //存储下次需要跳的坐标
            charWithIndex.put(s.charAt(j), j+1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int minLength = solution.lengthOfLongestSubstring("abcbad");
        System.out.println(minLength);
        minLength = solution.lengthOfLongestSubstring("au");
        System.out.println(minLength);
        minLength = solution.lengthOfLongestSubstring("aaaaaaaaa");
        System.out.println(minLength);
        minLength = solution.lengthOfLongestSubstring(" ");
        System.out.println(minLength);
    }
}
