package cn.link.acleetcode.c18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：四数之和
 * 描述：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 */
public class Solution {

    /**
     * i start ->         <-end  j
     * @param num
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length < 4) {
            return result;
        }

        Arrays.sort(num); // 对数组进行排序

        for (int i = 0; i < num.length - 3; i++) { // 第一个加数
            if (i > 0 && num[i] == num[i - 1]) { // 第一个加数使用不重复
                continue;
            }

            for (int j = num.length - 1; j > i + 2; j--) { // 第四个加数
                if (j < num.length - 1 && num[j] == num[j + 1]) { // 第四个加数使用不重复
                    continue;
                }

                int start = i + 1; // 第二个加数
                int end = j - 1; // 第三个加数
                int n = target - num[i] - num[j];

                while (start < end) {
                    if (num[start] + num[end] == n) {
                        List<Integer> four = new ArrayList<>(4);
                        four.add(num[i]);
                        four.add(num[start]);
                        four.add(num[end]);
                        four.add(num[j]);

                        result.add(four);

                        do {
                            start++;
                        } while (start < end && num[start] == num[start - 1]); // 保证再次使用第二个数不重复

                        do {
                            end--;
                        } while (start < end && num[end] == num[end + 1]); // 保证再次使用第三个数不重复
                    } else if (num[start] + num[end] < n) {
                        do {
                            start++;
                        } while (start < end && num[start] == num[start - 1]); // 保证再次使用第二个数不重复
                    } else {
                        do {
                            end--;
                        } while (start < end && num[end] == num[end + 1]); // 保证再次使用第三个数不重复
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> lists = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);

        lists = solution.fourSum(new int[]{0,0,0,0}, 0);
        System.out.println(lists);

        lists = solution.fourSum(new int[]{-1,0,1,2,-1,-4}, -1);
        System.out.println(lists);
    }
}
