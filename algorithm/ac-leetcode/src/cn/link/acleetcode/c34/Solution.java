package cn.link.acleetcode.c34;

import java.util.Arrays;

/**
 * 题目：在排序数组中查找元素的第一个和最后一个位置
 * 描述：给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int len = nums.length;
        int l = 0,h = len - 1;
        while(l <= h){

            int mid= h + (l-h) / 2;
            if(nums[mid] == target){
                int max = findMax(nums, mid, len, target);
                int min = findMin(nums, 0, mid, target);
                return new int[]{min, max};
            }else if (nums[mid] < target){
                l = mid + 1;
            }else {
                h = mid - 1;
            }
        }

        return new int[]{-1,-1};
    }

    private int findMax(int []nums, int l, int h, int target){
        int i=l;
        for(; i<h; i++){
            if(nums[i] > target){
                break;
            }
        }
        return i-1;
    }

    private int findMin(int []nums, int l, int h, int target){
        int i = h;
        for(;i>=l; i--){
            if(nums[i] < target){
                break;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int[] ints = solution.searchRange(nums, 8);
        Arrays.stream(ints).forEach(System.out::print);
    }
}
