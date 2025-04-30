package ru.job4j.leetcode;

public class LeetCodeBank {
    public static int totalMoney(int n) {
        int result = 0;
        int weeks = n / 7;
        int days = Math.abs((weeks * 7) - n);
        for (int i = 1; i  <= weeks; i++) {
            for (int j = i; j <= 7; j++) {
                result += j;
            }
        }
        for (int i = weeks; i < days; i++) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(4));
    }
}
