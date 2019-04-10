package cn.link.acleetcode.c08;

/**
 * 题目：字符串转换整数 (atoi)
 * 描述：实现一个 atoi 函数，使其能将字符串转换成整数。
 */
public class Solution {

    public int myAtoi(String str) {
        if(str == null) return 0;

        //去掉空字符
        str = str.trim();

        if(str.length() == 0) return 0;

        char head = str.charAt(0);
        if(head == '+' || head == '-' || head >= '0' && head <= '9'){
            if (head == '+' || head == '-'){
                str = str.substring(1);
            }
            int i=0;
            int result =0;
            int len = str.length();
            while(i<len && isDigits(str.charAt(i))){
                System.out.println(str.charAt(i));
                int disits = getDisits(str.charAt(i));
                disits = head == '-'?-disits:disits;
                //溢出就返回
                if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && disits>7) return Integer.MAX_VALUE;
                if(result < Integer.MIN_VALUE/10 || result == Integer.MIN_VALUE/10 && disits< -8) return Integer.MIN_VALUE;
                result = result*10 +disits;
                i++;
            }
            return result;
        }else {
            return 0;
        }
    }

    private boolean isDigits(char c){
        int re = c - '0';
        return re >= 0 && re <= 9;
    }

    private int getDisits(char c){
        return c-'0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.myAtoi("   -42");
        System.out.println(i);
        i = solution.myAtoi("-91283472332");
        System.out.println(i);

    }
}
