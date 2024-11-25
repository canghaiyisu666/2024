package leetcode.classics150;

import java.util.HashMap;
import java.util.Map;

public class Q169 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry entry : map.entrySet()) {
            if (nums.length / 2 < (int) entry.getValue()) {
                return (int) entry.getKey();
            }

        }
        return 0;
    }


//还可以用stream中的filter实现，如果有排序， 可以用sort
//        map.entrySet().stream().sorted(( o1, o2)->
//             o2.getValue()-o1.getValue()).collect(Collectors.);


}
