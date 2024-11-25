package main.java.TeacherWu;

//给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
//
//        示例 1：
//        输入：nums = [1,1,0,1,1,1]
//        输出：3
//        解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
//
//        示例 2:
//        输入：nums = [1,0,1,1,0,1]
//        输出：2
//
//        提示：
//        1 <= nums.length <= 10^5
//        nums[i] 不是 0 就是 1

public class D2_lc485 {
    public static void main(String[] args) {
        int[] nums={1,1,1,1};
        System.out.println(max_One(nums));
    }

    private static int max_One(int[] nums) {
        int last_Zero=-1;
        int result =0 ;
        for (int i =0 ; i<nums.length;i++) {
            if (nums[i]==0){
                last_Zero=i;
            }
            result = Math.max(result , i-last_Zero);

        }



        return result;
    }
}