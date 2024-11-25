package leetcode.classics150;

public class Q66 {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9, 9, 9};
        int[] result = plusOne(digits);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0)
                return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

}


