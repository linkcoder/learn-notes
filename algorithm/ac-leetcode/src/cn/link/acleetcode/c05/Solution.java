package cn.link.acleetcode.c05;

/**
 *题目：最长回文子串
 * 描述：给定一个字符串 s，找到 s 中最长的回文子串。
 */
public class Solution {

    /**
     *动态规划
     * dp[][]代表 i到j这个字符串是否为回文
     * 初始方程：dp[i][i]=1  s[i] == s[i+1] ->dp[i][i+1]=1
     * 递推：dp[i+1][j-1] = 1 && s[i]==s[j] -> dp[i][j] =1
     */
    public String longestPalindrome(String s) {

        if(s.length() == 0) return "";
        if(s.equals(" ")) return " ";

        int len = s.length();
        int[][] dp = new int[len][len];
        int start=0;
        int longest = 1;
        for(int i=0;i<len;i++){
            //自身相等
            dp[i][i] = 1;
            //两个字符相等
            if(i < len-1){
                if(s.charAt(i) == s.charAt(i+1)){
                    dp[i][i+1] = 1;
                    longest = 2;
                    start = i;
                }
            }
        }

        for(int l = 3 ; l <=len; l++){

            for(int i=0; i+l-1 <len; i++){
                //i为起点，j为终点
                int j = i+l-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                    start = i;
                    longest = l;
                }
            }
        }
//        System.out.println(start + " " + longest);
        return s.substring(start,start+longest);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String r1 = solution.longestPalindrome("cbbd");
        String r2 = solution.longestPalindrome("babad");
        System.out.println(r1);
        System.out.println(r2);
    }
}
