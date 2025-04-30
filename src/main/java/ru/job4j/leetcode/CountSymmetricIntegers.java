package ru.job4j.leetcode;


public class CountSymmetricIntegers {
    public static int countSymmetricIntegers(int low, int high) {
        int result = 0;
        for (int i = low; i <= high; i++) {
            char[] arr = Integer.toString(i).toCharArray();
            if (arr.length % 2 == 0) {
                int firstNum = 0;
                int secondNum = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (j < arr.length / 2) {
                        firstNum += (int) arr[j];
                    } else {
                        secondNum += (int) arr[j];
                    }
                }
                if (firstNum == secondNum) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1200, 1230));
        System.out.println(4 % 2);
    }
}
