package HWOD.C.C100;

//  查找众数及中位数

//  题目描述
//        1.众数是指一组数据中出现次数量多的那个数，众数可以是多个。
//        2.中位数是指把一组数据从小到大排列，最中间的那个数，如果这组数据的个数是奇数，
//        那最中间那个就是中位数，如果这组数据的个数为偶数，那就把中间的两个数之和除以2，所得的结果就是中位数。
//        3.查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数,
//    输入描述
//        输入一个一维整型数组，数组大小取值范围 0<N<1000，数组中每个元素取值范围 0<E<1000
//    输出描述
//        输出众数组成的新数组的中位数


import java.util.*;
import java.util.stream.Collectors;

public class Q7green {

    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        List<Integer> nums = new ArrayList<>();
        for (String per : input.split(" ")) {
            nums.add(Integer.parseInt(per));
        }

        // 统计数字出现次数及出现最大次数
        Map<Integer, Integer> countMap = new HashMap<>();       //<key,次数>
        int maxCount = 0;
        for (int number : nums) {
            int count = countMap.getOrDefault(number, 0) + 1;
            countMap.put(number, count);
            maxCount = Math.max(maxCount, count);
        }
        final int finalMaxCount = maxCount;   //最大次数

        //按照出现最大次数的数字， 来得到众数列表
        List<Integer> maxCountNums = countMap.entrySet()
                .stream()
                .filter(x -> x.getValue() == finalMaxCount)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());   //  ??????????????????????stream有待系统性学习


        // 计算中位数
        int mid;
        if (maxCountNums.size() % 2 != 0) {
            int index = (maxCountNums.size() + 1) / 2 - 1;
            mid = maxCountNums.get(index);
        } else {
            int indexL = maxCountNums.size() / 2 - 1;   //如果共4个元素，待计算下标为：1和2，如果共6个元素，待计算下标为2和3
            int indexR = maxCountNums.size() / 2;
            mid = (maxCountNums.get(indexL) + maxCountNums.get(indexR)) / 2;
        }

        System.out.println(mid);
    }


}






