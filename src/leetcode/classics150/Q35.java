package leetcode.classics150;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//        请必须使用时间复杂度为 O(log n) 的算法。

public class Q35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 2));
    }

    public static int searchInsert(int[] nums, int target) {//超出时间限制
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) >>> 1;
            int midVal = nums[mid];

            if (midVal < target)
                i = mid + 1;
            else if (midVal > target)
                j = mid - 1;
            else
                return mid; // key found
        }
        return i;

    }
}
