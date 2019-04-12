package cn.link.acleetcode.c17;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：电话号码的字母组合
 * 描述：九宫格打字 组合
 */
public class Solution {
    static String[] keys={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    static StringBuilder str = new StringBuilder();


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.equals("") || digits.length() == 0) return result;

        buildString(0,digits,result);
        return result;
    }

    private void buildString(int index, String digits, List<String> result){
        if(index == digits.length()){
            result.add(str.toString());
            return;
        }

        int keyIndex = digits.charAt(index) - '0';
        String key = keys[keyIndex];
        for(int i=0;i< key.length(); i++){
            char c = key.charAt(i);
            str.append(c);
            buildString(index+1, digits, result);
            str.deleteCharAt(str.length()-1);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("");
        strings.forEach(System.out::println);

    }
}
