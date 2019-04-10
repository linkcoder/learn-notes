package cn.link.acleetcode.c07;

/**
 * 题目：整数反转
 * 描述：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Solution {

    public int reverse(int x) {
        int res = 0;
        while(x!=0){
            int pop = x%10;
            x = x/10;
            //最大数/10 = 7
            //最小数/10 = -8
            if(res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && pop>7) return 0;
            if(res < Integer.MIN_VALUE/10 || res == Integer.MIN_VALUE/10 && pop< -8) return 0;
            res = res*10 + pop;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int reverse = solution.reverse(123);
        System.out.println(reverse);
        reverse =solution.reverse(0);
        System.out.println(reverse);
        reverse =solution.reverse(-1463847412);
        System.out.println(reverse);

    }
}
