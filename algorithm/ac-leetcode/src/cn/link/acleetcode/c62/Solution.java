package cn.link.acleetcode.c62;

/**
 * 题目：不同路径
 * 描述：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 */
public class Solution {


    public int uniquePaths(int m, int n) {

        int[][] step = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            step[i][1] = 1;
        }

        for(int j=1; j<=m; j++){
            step[1][j] = 1;
        }

        for(int i=2; i<=n; i++){

            for(int j=2; j<=m; j++){
                step[i][j] = step[i-1][j] + step[i][j-1];
            }
        }

        return step[n][m];
    }


    /**
     * return helper(1, 1, m, n);
     * 递归，超时
     * @param i
     * @param j
     * @param m
     * @param n
     * @return
     */
    private int helper(int i, int j, int m, int n){

        if(i == n) return 1;

        if(j == m) return 1;

        return helper(i+1, j, m, n) + helper(i, j+1, m, n);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.uniquePaths(51, 9);
        System.out.println(result);
    }
}
