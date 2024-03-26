package leetcode.classics150;

//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

public class Q121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int earn = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            } else {
                earn = Math.max(earn, prices[i] - lowest);
            }
        }
        return earn;
    }


    //暴利求解，会超时
//    public static int maxProfit(int[] prices) {
//        int maxMoney=0;
//        for (int i =0;i<prices.length-1;i++){
//            for (int j =i+1;j<prices.length;j++){
//                int earn=prices[j]-prices[i];
//                maxMoney=Math.max(earn,maxMoney);
//            }
//        }
//        return  maxMoney;
//    }


}
