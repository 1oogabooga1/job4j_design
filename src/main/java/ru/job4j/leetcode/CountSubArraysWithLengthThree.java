package ru.job4j.leetcode;

public class CountSubArraysWithLengthThree {
    public static int countSubarrays(int[] nums) {
        int result = 0;
        int left = 0;
        int right = left + 2;
        while (right < nums.length) {
            if (nums[left] + nums[right] == (double) nums[right - 1] / 2) {
                result++;
            }
            left++;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        countSubarrays(new int[] {-1,-4,-1,4});
    }
}
