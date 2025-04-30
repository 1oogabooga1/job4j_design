package ru.job4j.leetcode;

import java.util.Arrays;

public class SquaredArray {
    public static void main(String[] args) {
        int left = 0;
        int[] rsl = new int[5];
        int right = rsl.length - 1;
        rsl[0] = 2;
        rsl[1] = 4;
        rsl[2] = 6;
        rsl[3] = 8;
        rsl[4] = 10;
        int resultIndex = rsl.length - 1;
        while (left < right) {
            if (Math.abs(rsl[left]) > Math.abs(rsl[right])) {
                rsl[resultIndex] = rsl[left] * rsl[left];
                left++;
            } else {
                rsl[resultIndex] = rsl[right] * rsl[right];
                right--;
            }
            resultIndex--;
        }
        Arrays.stream(rsl).forEach(System.out::println);
    }
}
