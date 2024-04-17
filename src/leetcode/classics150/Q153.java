package leetcode.classics150;

/**
 * 在一个旋转了的有序数组中找到最小的元素。
 * 旋转有序数组是原有序数组的一部分从某个位置旋转而来的，旋转后的数组中任意一个元素都满足：
 * 数组[0] <= 数组[1] ... <= 数组[n-1]，且数组[n] <= 数组[n+1] ... <= 数组[m] <= 数组[m+1]，
 * 其中 n < m 为旋转的点。该函数要在O(log n)的时间复杂度内找到旋转点后的最小元素。
 */
public class Q153 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 7, 0, 1, 2}));
    }

    /**
     * 使用二分查找法找到旋转点后的最小元素。
     *
     * @param nums 旋转了的有序数组
     * @return 数组中最小的元素
     */
    public static int findMin(int[] nums) {
        // 处理空数组的情况
        if (nums.length == 0) {
            return -1;
        }

        // 如果数组的第一个元素小于或等于最后一个元素，则第一个元素即为最小值
        if (!(nums[0] > nums[nums.length - 1])) {
            return nums[0];
        }

        // 初始化二分查找的边界
        int i = 0, j = nums.length - 1;
        // 执行二分查找直到找到最小元素
        while (i < j) {
            int mid = (i + j) >>> 1;
            // 如果中间元素小于最右边的元素，说明最小元素在左半部分
            if (nums[mid] < nums[j]) {
                j = mid;
            // 如果中间元素大于最右边的元素，说明最小元素在右半部分
            } else if (nums[mid] > nums[j]) {
                i = mid + 1;
            }
        }
        // 返回找到的最小元素
        return nums[i];
    }
}

