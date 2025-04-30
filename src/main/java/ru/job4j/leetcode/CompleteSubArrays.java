package ru.job4j.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CompleteSubArrays {
    public int countCompleteSubarrays(int[] nums) {
        int result = 0;
        int distinctNumbersQuantity = Arrays.stream(nums).distinct().toArray().length;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
                set.add(nums[j]);
                if (set.size() == distinctNumbersQuantity) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
