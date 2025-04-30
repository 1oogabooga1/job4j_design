package ru.job4j.leetcode;

import java.util.LinkedList;

public class CountTheHiddenSequences {
    public static int numberOfArrays(int[] differences, int lower, int upper) {
        int result = 0;
        int smth = 0;
        LinkedList<Integer> hiddenSequence = new LinkedList<>();
        for (int i = lower; i <= upper; i++) {
            if (hiddenSequence.size() >= differences.length) {
                result++;
            }
            hiddenSequence.add(i);
            smth = i;
            for (int j = 0; j < differences.length; j++) {
                if (smth + differences[j] >= lower && smth + differences[j] <= upper) {
                    hiddenSequence.add(smth + differences[j]);
                    smth += differences[j];
                } else {
                    hiddenSequence.clear();
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArrays(new int[] {-40}, -46, 53));
    }
}
