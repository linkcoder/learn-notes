package cn.link.acleetcode.c33;

/**
 * 题目：搜索旋转排序数组
 * 描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转，
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1
 */
public class Solution {

    //二分搜索
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        return twoPartSearch(target, nums, 0, nums.length-1);
    }

    private int twoPartSearch(int target, int[] nums, int start, int end){
        while(start <= end){

            int mid = start + (end-start)/2;
            if(target == nums[mid]){
                return mid;
            }else if(nums[mid] < nums[end]){
                if(target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }else{
                if(target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums= {4,5,6,7,0,1,2};
        int search = solution.search(nums, 0);
        System.out.println(search);
        search = solution.search(nums, 3);
        System.out.println(search);

        search = solution.search(new int[]{1,3}, 3);
        System.out.println(search);

        search = solution.search(new int[]{3,1}, 1);
        System.out.println(search);
    }
}
