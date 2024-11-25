package leetcode.classics150;

/**
 * 查找数组中的峰值元素。
 * 数组中的峰值元素是指其大于相邻元素的元素。
 * 假设数组中存在这样的元素，函数将返回该元素的下标。
 */
public class Q162 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums)); // 输出峰值元素的索引
    }

    /**
     * 使用二分查找法找到数组中的峰值元素。
     *
     * @param nums 给定的整数数组
     * @return 峰值元素的下标
     */
    public static int findPeakElement(int[] nums) {
        // 初始化二分查找的边界
        int i = 0, j = nums.length - 1;

        // 进行二分查找
        while (i < j) {
            // 计算中间位置
            int m = (i + j) >>> 1;
            // 如果中间元素小于其后一个元素，则峰值必在后半部分
            if (nums[m] < nums[m + 1]) {
                i = m + 1; // 更新查找区间为后半部分
            } else {
                // 否则，峰值必在前半部分，包括中间元素本身
                j = m; // 更新查找区间为前半部分
            }
        }
        // 返回找到的峰值元素的下标
        return i;
    }
}
