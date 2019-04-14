package cn.link.acleetcode.c43;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：字符串相乘
 * 描述：给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Solution {

    public String multiply(String num1, String num2) {

        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return null;

        if(num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();

        int[] list = new int[len1 + len2];

        for(int i = len1-1; i>=0; i--){
            int n1 = num1.charAt(i) - '0';
            for(int j = len2-1; j>=0; j--){
                int n2= num2.charAt(j) - '0';

                int mul = n1 * n2;

                int p = i + j;
                int q = i + j + 1;
                int sum = mul + list[q];

                list[p] +=  sum / 10;
                list[q] = sum % 10;
            }
        }

        StringBuilder result = new StringBuilder();
        Arrays.stream(list).forEach(result::append);
        if(result.charAt(0) == '0') result.deleteCharAt(0);
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String multiply = solution.multiply("123", "456");
        System.out.println(multiply);

        multiply = solution.multiply("123", "0");
        System.out.println(multiply);
    }
}
