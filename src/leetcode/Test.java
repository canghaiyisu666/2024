package leetcode;

public class Test {
    public static void main(String[] args) {
        int[] digits = {9, 8, 9, 9, 9, 9};
        digits = new int[digits.length + 1];
        digits[0] = 7;
        for (int i : digits) {
            System.out.println(i);
        }
    }
}
