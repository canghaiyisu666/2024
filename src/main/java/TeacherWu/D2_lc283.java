package main.java.TeacherWu;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//        示例 1:
//        输入: nums = [0,1,0,3,12]
//        输出: [1,3,12,0,0]

//        示例 2:
//        输入: nums = [0]
//        输出: [0]
//        提示:
//
//        1 <= nums.length <= 10^4
//        -2^31 <= nums[i] <= 2^31 - 1


public class D2_lc283 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,3,12};
        int[] result=moveZero(nums);
        for (int i :result) {
            System.out.println(i);

        }
    }

    private static int[] moveZero(int[] nums) {
        int slow = 0;
        //用来记录不是0个数字的个数，同时也是一个指针，用来指向经过一系列操作后数组中所有为 0 元素的第一个位置上

        // 遍历完毕之后，slow 指向了一个为 0 的元素，或者如果数组中不存在 0 ，就和 fast 一样，超过了数组的范围
        for (int fast = 0; fast < nums.length; fast++) {

            // 说明 slow 不在正确的位置上，需要向后移动，寻找合适的位置
            if (nums[fast] != 0) {// 在遍历过程中，如果发现访问的元素是非 0 元素
                nums[slow] = nums[fast];// 这个时候，原先 slow 的值需要被 fast 的值覆盖
                slow++;  // slow 需要向后移动，寻找合适的位置
            }
        }

        // 接下来，只需要把 slow 极其后面所有的元素都设置为 0 就行
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0; // 都设置为 0
        }
        return nums;
    }
}
