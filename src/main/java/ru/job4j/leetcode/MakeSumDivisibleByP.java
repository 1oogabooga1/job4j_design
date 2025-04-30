package ru.job4j.leetcode;

import java.util.HashMap;

public class MakeSumDivisibleByP {
    public static int solution(int[] nums, int p) {
        long totalSum = sum(nums);
        int remainder = (int) (totalSum % p);
        if (remainder == 0) {
            return 0;
        }
        HashMap<Integer, Integer> prefixMod = new HashMap<>();
        long prefixSum = 0;
        int minLength = nums.length;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int currentMod = (int) (prefixSum % p);
            int targetMod = (currentMod - remainder + p) % p;
            if (prefixMod.containsKey(targetMod)) {
                minLength = Math.min(minLength, i - prefixMod.get(targetMod));
            }
            prefixMod.put(currentMod, i);
        }
        return minLength == nums.length ? -1 : minLength;
    }

    public static long sum(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4,  2};
        System.out.println(solution(nums, 148));
    }
    /*
     * https://leetcode.com/problems/make-sum-divisible-by-p/?envType=daily-question&envId=2024-10-03
     */
}
