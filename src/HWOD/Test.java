package HWOD;

public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abcde");
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.substring(0, sb.length() - 1));
        System.out.println(sb.substring(0, 5));
        System.out.println(sb.substring(0, 3));
        System.out.println("".length());

        int m = 2;
        int n = 2;
        int ans =0;
        System.out.println( ans + Math.ceil( n / (m + 1)) * (m + 1));
    }
}
