package leetcode.classics150;


//        209. 长度最小的子数组          中等

//        给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//        找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组
//        [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
//
//        如果不存在符合条件的子数组，返回 0


public class Q209 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println("结果共" + minSubArrayLen(target, nums));

    }


    public static int minSubArrayLen(int target, int[] nums) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target)
                return 1;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
//                    System.out.println(i + "==" + j);
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;

    }

}
