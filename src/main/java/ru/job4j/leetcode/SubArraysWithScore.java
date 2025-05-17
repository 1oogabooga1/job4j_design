package ru.job4j.leetcode;

public class SubArraysWithScore {
    public static long countSubarrays(int[] nums, long k) {
        long count = 0;
        int left = 0;
        long sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[] {2, 1, 4, 3, 5}, 10));
    }
}
