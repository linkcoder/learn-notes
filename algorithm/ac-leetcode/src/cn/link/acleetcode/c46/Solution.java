package cn.link.acleetcode.c46;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：组合数
 * 描述：给定一个没有重复数字的序列，返回其所有可能的全排列
 */
public class Solution {

    List<Integer> str = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        if(nums == null || nums.length == 0) return null;

        List<List<Integer>> result = new ArrayList<>();

        if(nums.length == 1) {
            List item = new ArrayList<>();
            item.add(nums[0]);
            result.add(item);
            return result;
        }

        huishuo(nums, result, 0);

        return result;
    }

    public void huishuo(int[] nums, List<List<Integer>> result, int index){

        if(index == nums.length){
            List item = new ArrayList<>();
            item.addAll(str);
            result.add(item);
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(str.contains(nums[i])) continue;
            str.add(nums[i]);
            huishuo(nums, result, index+1);
            str.remove(str.size()-1);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3};
        System.out.println(solution.permute(nums));

        nums = new int[]{1};
        System.out.println(solution.permute(nums));
    }
}
