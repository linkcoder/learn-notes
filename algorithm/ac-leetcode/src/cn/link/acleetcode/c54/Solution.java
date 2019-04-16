package cn.link.acleetcode.c54;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：螺旋矩阵
 * 描述：给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class Solution {


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        if(m == 0) return result;

        int n = matrix[0].length;
        if(n == 0) return result;

        helper(result, matrix, 0, 0, m-1, n-1);
        return result;
    }

    private void helper(List<Integer> result, int[][] matrix, int li, int lj, int ri, int rj){

        if(li >= ri) {

            for(int i= li ; i<=rj; i++){
                result.add(matrix[li][i]);
            }
            return;
        }

        if(lj >= rj) {

            for(int i= li ; i<=rj; i++){
                result.add(matrix[i][rj]);
            }
            return;
        }

        for(int i=0; i< rj; i++){
            result.add(matrix[li][i]);
        }

        for(int i=0; i< ri; i++){
            result.add(matrix[i][rj]);
        }

        for(int i=rj; i>0; i--){
            result.add(matrix[ri][i]);
        }

        for(int i=ri; i>0; i--){
            result.add(matrix[i][lj]);
        }

        helper(result, matrix, li+1, lj+1, ri-1 ,rj-1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12 }};
        result = solution.spiralOrder(matrix);
        System.out.println(result);
    }
}
