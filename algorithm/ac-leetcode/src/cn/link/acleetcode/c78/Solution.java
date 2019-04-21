package cn.link.acleetcode.c78;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 题目：子集
 * 描述：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null) return result;

        //空集
        result.add(new ArrayList<>());
        if(nums.length == 0) return result;

        int len = nums.length;
        for(int i=0; i<len; i++){
            int item = nums[i];
            int resultSize = result.size();
            for(int j=0; j<resultSize; j++){

                List<Integer> resultItem = new ArrayList<>(result.get(j));
                resultItem.add(item);

                result.add(resultItem);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        solution.subsets(nums).forEach(System.out::println);
    }
}
