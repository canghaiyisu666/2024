package heima;


public class erfen {

    public static void main(String[] args) {
        int[] arr = {7, 13, 21, 30, 38, 44, 52, 53};
        int index = binarySearchBasic(arr, 5);
//        assertEquals
        System.out.println(index);
    }

    public static int binarySearchBasic(int[] a, int target) {
        /*
        二分查找 基础版
         */
        int i = 0, j = a.length - 1;
        while (i <= j) {    //表示范围内有未查找的值
            int mid = (i + j) / 2;    //java自动向下取整
            if (target < a[mid]) {    //目标在左边
                j = mid - 1;
            } else if (a[mid] < target) {    //目标在右边
                i = mid + 1;
            } else {    //找到了
                return mid;
            }
        }
        return -1;
    }
}
