package HWOD.C.C100;
//题目描述;山脉的个数(本题分值100)
//        攀登者喜欢寻找各种地图，并且尝试攀登到最高的山峰。
//        地图表示为一维数组，数组的索引代表水平位置，数组的元素代表相对海拔高度。其中数组元素0代表地面。
//        一个山脉可能有多座山峰(高度大于相邻位置的高度，或在地图边界且高度大于相邻的高度)。
//        登山者想要知道一张地图中有多少座山峰。
//        例如:[0,1,2,4,3,1,0,0,1,2,3,1,2,1,0]，代表如下图所示的地图，地图中有三个山脉位置分别为 1,2,3,4,5 和8,9,10,11,12.13，最高峰高度分别为 4,3,2。最高峰位置分别为3.10.12。


public class Q2 {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 2, 1, 0, 4, 3};
        System.out.println(count_peaks(a));
    }

    public static int count_peaks(int[] hill_map) {
        int count = 0;

        for (int i = 0; i < hill_map.length; i++) {
            if (i == 0 && hill_map[0] > hill_map[1]) {
                count++;
            }
            if (i > 0 && i < hill_map.length - 1 && hill_map[i] > hill_map[i + 1] && hill_map[i - 1] < hill_map[i]) {
                count++;
            }
            if (i == hill_map.length - 1 && hill_map[i - 1] < hill_map[i]) {
                count++;
            }

        }
        return count;
    }
}
