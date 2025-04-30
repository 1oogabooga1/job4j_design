package ru.job4j.leetcode;

public class CountEqualAndDivisiblePairs {
    public static int countPairs(int[] nums, int k) {
        int rsl = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    rsl++;
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2));
    }
}
