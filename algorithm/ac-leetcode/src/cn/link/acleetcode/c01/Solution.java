package cn.link.acleetcode.c01;

import java.util.*;

/**
 * 题目：两数之和
 * 内容：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *      你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Solution {

    //笨方法版 时间复杂度 n^2
    public int[] twoSum(int[] nums, int target) {
        List<Integer> result= new ArrayList<>();
        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    result.add(i);
                    result.add(j);
                }
            }
        }
        int[] returnList=new int[result.size()];
        int index=0;
        for(int e:result){
            returnList[index++]=e;
        }
        return returnList;
    }


    //使用map优化版 时间复杂度 n
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];

            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 9);
        Arrays.stream(result).forEach(item-> System.out.println(item));
    }
}
