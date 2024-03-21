package HWOD.C.C200;

//信道分配：贪心
// ？？？？？？？？？？？未看
//  题目描述
//        算法工程师小明面对着这样一个问题，需要将通信用的信道分配给尽量多的用户信道的条件及分配规则如下:
//        1.所有信道都有属性:”阶”。阶为r的信道的容量为 2^r比特:
//        2.所有用户需要传输的数据量都一样:D比特:
//        3.一个用户可以分配多个信道，但每个信道只能分配给一个用户:
//        4.只有当分配给一个用户的所有信道的容量和>=D，用户才能传输数据
//        给出一组信道资源，最多可以为多少用户传输数据?
//    输入描述
//        第一行，一个数字 R。R为最大阶数。
//        0<=R<20
//        第二行，R+1个数字，用空格隔开。代表每种信道的数量 Ni。按照阶的值从小到大排列。
//        0<=i<=R, 0<=Ni<1000
//        第三行，一个数字 D。  D为单个用户需要传输的数据量。
//        0<D<1000000
//    输出描述
//        一个数字,代表最多可以供多少用户传输数据。

import java.util.Arrays;
import java.util.Scanner;

public class Q43green {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 用户输入最大信道阶数
        int maxLevel = sc.nextInt();
        sc.nextLine(); // 消耗换行符，避免影响下一次读取
        // 用户输入每种信道的数量，按阶数从小到大
        String[] inputCounts = sc.nextLine().split(" ");
        // 使用流将字符串数组转换为整数数组
        int[] channelCounts = Arrays.stream(inputCounts).mapToInt(Integer::parseInt).toArray();
        // 用户输入单个用户需要的数据量
        int dataNeed = sc.nextInt();

        sc.close();

        // 将用户需求的数据量转换为二进制位数组，并反转以符合从低阶到高阶的顺序
        int[] requirementBits = toBitsArray(dataNeed);
        // 初始化能服务的用户数
        int usersServed = 0;

        // 对超出需求位长度的高阶信道，直接累加其数量至能服务的用户数
        for (int i = requirementBits.length; i <= maxLevel; i++) {
            usersServed += channelCounts[i];
        }

        // 初始化当前可用信道数组，长度与需求位相同
        int[] currentChannels = Arrays.copyOfRange(channelCounts, 0, requirementBits.length);
        // 尝试分配信道直到不再能满足任何用户的需求
        while (allocateChannels(currentChannels, requirementBits)) {
            // 成功分配则用户数加一
            usersServed++;
        }

        // 输出能服务的用户总数
        System.out.println(usersServed);
    }

    // 将十进制数转换为二进制位数组的函数
    private static int[] toBitsArray(int number) {
        // 将整数转换为二进制字符串
        String binaryString = Integer.toBinaryString(number);
        // 创建与二进制字符串长度相同的数组
        int[] bits = new int[binaryString.length()];
        // 填充数组，字符串末尾的位对应数组的开始
        for (int i = 0; i < binaryString.length(); i++) {
            bits[binaryString.length() - 1 - i] = binaryString.charAt(i) - '0';
        }
        return bits;
    }

    // 定义分配信道的函数
    private static boolean allocateChannels(int[] channels, int[] requirement) {
        // 从最高阶开始向下遍历，尝试分配信道以满足需求
        for (int i = channels.length - 1; i >= 0; i--) {
            if (channels[i] >= requirement[i]) {
                channels[i] -= requirement[i];
            } else {
                // 如果当前阶信道数量不足以满足需求
                if (bitsToNum(Arrays.copyOfRange(channels, 0, i + 1)) < bitsToNum(Arrays.copyOfRange(requirement, 0, i + 1))) {
                    // 尝试从更高阶借用一个信道
                    for (int j = i + 1; j < channels.length; j++) {
                        if (channels[j] > 0) {
                            channels[j]--;
                            return true;
                        }
                    }
                    return false;
                } else {
                    // 如果当前及更低阶信道总容量足够，进行分配
                    channels[i] -= requirement[i];
                    if (i > 0) {
                        // 将不足部分的需求通过倍增转移到下一低阶
                        channels[i - 1] += channels[i] * 2;
                    }
                    channels[i] = 0;
                }
            }
        }
        return true;
    }

    // 将二进制位数组转换为十进制数的函数
    private static int bitsToNum(int[] bits) {
        int number = 0;
        // 遍历二进制位数组，计算十进制数值
        for (int i = 0; i < bits.length; i++) {
            number += bits[i] * Math.pow(2, i);
        }
        return number;
    }

}

