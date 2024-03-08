package C.C100;

import java.util.Scanner;

//    停车场车辆统计:  数组   贪心
//    题目描述:
//        特定大小的停车场，数组cars表示，其中1表示有车，0表示没车。车辆大小不一，小车占一个车位(长度1)，货车占两个车位(长度2)，卡车占三个车位(长度3)。
//        统计停车场最少可以停多少辆车，返回具体的数目。
//    输入描述:
//        整型字符串数组cars，其中1表示有车，0表示没车，数组长度小于1000，
//    输出描述:
//        整型数字字符串，表示最少停车数目。
//    解题思路：
//        遍历数组，统计连续元素值为 1 的长度，然后用贪心的思想，优先用多辆占用车位多的卡车来占车位，剩余的车位在尝试用占用车位第二多的货车来占车位、最后用小车来占用
public class Q48red {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 将输入的字符串转换为停车场数组

        String input = sc.nextLine();
        input = input.replace(",", "");
        String[] parking_array = input.split("0");

        // 初始化停车场最少停车数目为0
        int car_num = 0;

        // 遍历停车场数组，统计每个连续的1的长度
        for (String per : parking_array) {
            // 计算当前连续1的长度
            int length = per.length();

            // 如果当前连续1的长度为0，不做任何操作
            if (length == 0) {

            }
            // 如果当前连续1的长度能被3整除，说明可以完全放置卡车
            else if (length % 3 == 0 && length != 0) {
                // 将当前连续1的长度除以3，得到卡车数量，并累加到最少停车数目
                car_num += length / 3;
            }
            // 如果当前连续1的长度不能被3整除，说明需要放置小车或货车
            else if (length % 3 != 0) {
                // 计算可以放置的卡车数量，并累加到最少停车数目
                car_num += (length - length % 3) / 3;
                // 由于还有剩余的车位，需要放置一个小车或货车，所以最少停车数目加1
                car_num += 1;
            }
        }

        // 输出停车场最少停车数目
        System.out.println(car_num);

    }
}






