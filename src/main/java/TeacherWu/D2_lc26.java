package main.java.TeacherWu;

//给你一个 升序排列 的数组 nums ，请你** 原地 (opens new window)** 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
//
//        由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
//
//        将最终结果插入 nums 的前 k 个位置后返回 k 。
//
//        不要使用额外的空间，你必须在 **原地  (opens new window)**修改输入数组并在使用 O(1) 额外空间的条件下完成。
//
//        判题标准:
//
//        系统会用下面的代码来测试你的题解:
//
//        int[] nums = [...]; // 输入数组
//        int[] expectedNums = [...]; // 长度正确的期望答案
//
//        int k = removeDuplicates(nums); // 调用
//
//        assert k == expectedNums.length;
//        for (int i = 0; i < k; i++) {
//        assert nums[i] == expectedNums[i];
//        }
//        如果所有断言都通过，那么您的题解将被 通过。
//
//        示例 1：
//        输入：nums = [1,1,2]
//        输出：2, nums = [1,2,_]
//        解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
//
//        示例 2：
//        输入：nums = [0,0,1,1,1,2,2,3,3,4]
//        输出：5, nums = [0,1,2,3,4]
//        解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。

//        提示：
//
//        1 <= nums.length <= 3 * 10^4
//        -10^4 <= nums[i] <= 10^4
//        nums 已按 升序 排列

public class D2_lc26 {
    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(nums);
        System.out.println(k);
        for (int per:nums) {
            System.out.println(per);
        }
    }
    public static  int removeDuplicates(int[] nums) {

        int slow = 0;//用来记录重复数字的个数，同时也是一个指针，用来指向经过一系列操作后数组中所有为 0 元素的第一个位置上

        for (int fast = 0 ; fast < nums.length ; fast++) {

            // 进行筛选
            if ( fast == 0 ||  nums[fast] != nums[fast - 1]) {
                // 赋值
                nums[slow] = nums[fast];

                slow++;// j 移动
            }
        }

        return slow ;
    }
}
