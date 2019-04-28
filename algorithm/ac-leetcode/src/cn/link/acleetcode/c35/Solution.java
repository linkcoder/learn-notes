package cn.link.acleetcode.c35;

import javax.sound.midi.Soundbank;

/**
 * 题目：搜索插入位置
 * 描述：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0 ) return 0;

        int len = nums.length;
        if(target < nums[0]) return 0;
        if(target > nums[len-1]) return len;

        int l = 0,h = len - 1;
        while(l <= h){

            int mid = h + (l-h)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else {
                h = mid - 1;
            }
        }
        return Math.max(l, h);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,5,6};
        int result = solution.searchInsert(nums, 5);
        System.out.println(result);
    }
}
