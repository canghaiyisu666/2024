package leetcode.classics150;

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
//如果数组中不存在目标值 target，返回 [-1, -1]。
//
//你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

import java.util.Arrays;

public class Q34 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int condidate_left = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            int mid = nums[m];
            if (target < mid) {
                j = m - 1;
            } else if (target > mid) {
                i = m + 1;
            } else {
                condidate_left = m;
                j = m - 1;
            }
        }

        int x = 0, y = nums.length - 1;
        int condidate_right = -1;
        while (x <= y) {
            int m = (x + y) >>> 1;
            int mid = nums[m];
            if (target < mid) {
                y = m - 1;
            } else if (target > mid) {
                x = m + 1;
            } else {
                condidate_right = m;
                x = m + 1;
            }
        }
        return new int[]{condidate_left, condidate_right};

    }
}
