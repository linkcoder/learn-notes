package cn.link.acleetcode.c32;

import java.util.Arrays;

/**
 * 题目：下一个排列
 * 描述：实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 */
public class Solution {

    public void nextPermutation(int[] nums) {

        if (nums == null) return;

        int len = nums.length;

        if (len <= 1) return;

        int i = len - 2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i >= 0){
            int j = len-1;
            while(j>=0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,5};
        solution.nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
