package cn.link.acleetcode.c11;

/**
 * 题目：盛最多水的容器
 * 描述：给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class Solution {

    /**
     * S= l * h
     * l减小
     * h增加
     * 尽量选择大的h
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int pre = 0;
        int last = height.length-1;
        int max = 0;

        while(pre<last){

            max = Math.max(max, Math.min(height[pre],height[last]) * (last-pre));

            if(height[pre] < height[last]){
                pre++;
            }else{
                last--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        int re = solution.maxArea(nums);
        System.out.println(re);
    }
}
