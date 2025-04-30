package ru.job4j.leetcode;

public class CountGoodTriplets {
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[j] < arr[k]) {
                        if (Math.abs(arr[i] - arr[j]) <= a) {
                            if (Math.abs(arr[j] - arr[k]) <= b) {
                                if (Math.abs(arr[i] - arr[k]) <= c) {
                                    result++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3};
        int a = 0;
        int b = 0;
        int c = 1;
        System.out.println(countGoodTriplets(arr, a, b, c));
    }
}
