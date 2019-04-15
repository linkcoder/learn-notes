package cn.link.acleetcode.c53;

/**
 * 题目：最大子序和
 * 描述：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 */
public class Solution {

    /**
     * 当我们加上一个正数时，和会增加；当我们加上一个负数时，和会减少。
     * 如果当前得到的和是个负数，那么这个和在接下来的累加中应该抛弃并重新清零，不然的话这个负数将会减少接下来的和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int current = nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++){

            if(current<0){
                current = nums[i];
            } else{
                current += nums[i];
            }

            if(current > sum) sum = current;
        }
        return sum;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = solution.maxSubArray(nums);
        System.out.println(result);
    }
}
