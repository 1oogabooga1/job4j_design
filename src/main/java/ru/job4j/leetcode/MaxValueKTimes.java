package ru.job4j.leetcode;

import java.util.Arrays;

public class MaxValueKTimes {
    public static long countSubarrays(int[] nums, int k) {
        long count = 0;
        int left = 0;
        int maxValueCount = 0;
        int maxValue = Arrays.stream(nums).max().getAsInt();
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == maxValue) {
                maxValueCount++;
            }
            while (maxValueCount >= k) {
                if (nums[left] == maxValue) {
                    maxValueCount--;
                }
                left++;
            }
            count += left;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[] {1, 3, 2, 3, 3}, 2));
    }
}
