package leetcode.classics150;
//存疑，，逻辑不通？？？？？？？？？？？？？？？？

public class Q27 {
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[count] = nums[j];
                count++;
            }
        }
        for (int a: nums
             ) {
            System.out.print(a+" ");

        }
        return count;

    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }
}
