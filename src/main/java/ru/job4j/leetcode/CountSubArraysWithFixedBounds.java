package ru.job4j.leetcode;

public class CountSubArraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int lastMin = -1;
        int lastMax = -1;
        int lastInvalid = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num < minK || num > maxK) {
                lastInvalid = i;
            }

            if (num == maxK) {
                lastMax = i;
            }

            if (num == minK) {
                lastMin = i;
            }
            int validStart = Math.min(lastMin, lastMax);
            if (validStart > lastInvalid) {
                count += validStart - lastInvalid;
            }
        }
        return count;
    }
}
