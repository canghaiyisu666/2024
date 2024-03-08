package HWOD.C;

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
    }
}
