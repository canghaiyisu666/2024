package leetcode.classics150;

public class Q74 {

    public static void main(String[] args) {

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 0;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int l = 0, r = ints.length - 1;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (target < ints[mid]) {
                    r = mid - 1;
                } else if (ints[mid] < target) {
                    l = mid + 1;
                } else return true;
            }
        }
        return false;
    }
}