package leetcode.classics150;

import java.util.PriorityQueue;

public class Q88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            queue.offer(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            queue.offer(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] =  queue.poll();
        }
//        for (int i = 0; i < nums1.length; i++) {
//            System.out.println(nums1[i] + " ");
//
//        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }
}
