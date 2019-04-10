package cn.link.acleetcode.c06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：Z 字形变换
 * 内容：比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 */
public class Solution {

    public String convert(String s, int numRows) {

        if(s.length() == 0) return "";
        if(s.length() == 1 || numRows == 1) return s;

        List[] zArray = new List[numRows];

        for(int i=0; i<numRows; i++){
            zArray[i] = new ArrayList();
        }

        int len = s.length();
        boolean arrow = true; //正向
        int yIndex = 0; //纵轴
        for(int i=0; i<len; i++){

            if(arrow){
                zArray[yIndex].add(s.charAt(i));
                yIndex++;
            }else {
                zArray[yIndex].add(s.charAt(i));
                yIndex--;
            }

            if(yIndex% (numRows-1) ==0){
                //该转向了
                arrow = !arrow;
            }
        }
        StringBuilder str = new StringBuilder();
        Arrays.stream(zArray).forEach(line -> line.forEach(str::append));
        return str.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.convert("LEETCODEISHIRING", 3);
        System.out.println(result);
        result = solution.convert("A", 1);
        System.out.println(result);

    }
}
