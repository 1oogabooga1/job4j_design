package ru.job4j.leetcode;

import java.util.Arrays;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = left + 1;
        int countDuplicates = 0;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                countDuplicates++;
                nums[left] = 0;
            }
            left++;
            right++;
        }
        nums = Arrays.stream(nums).distinct().sorted().toArray();
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
            nums[i + 1] = 0;
        }
        System.out.println(Arrays.toString(nums));
        return countDuplicates;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(nums);
    }
}
