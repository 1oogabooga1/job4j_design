package ru.job4j.leetcode;


import java.util.*;

public class SmallestRangeFinder {
    public static int[] findSmallestRange(int[] nums, int k) {
        int left = 0;
        int right = left + 1;
        int[] rsl = new int[2];
        List<Integer> result = new ArrayList<>();
        while (left < nums.length) {
            if (right == nums.length) {
                if (result.size() + 1 == k) {
                    result.add(left);
                    rsl[0] = result.get(0);
                    rsl[1] = result.get(result.size() - 1);
                    return rsl;
                } else {
                    return null;
                }
            }
            if (nums[left] != nums[right]) {
                result.add(left);
            } else {
                result.clear();
            }
            if (result.size() == k) {
                rsl[0] = result.get(0);
                rsl[1] = result.get(result.size() - 1);
                return rsl;
            }
            left++;
            right++;
        }
        return null;
    }
}
