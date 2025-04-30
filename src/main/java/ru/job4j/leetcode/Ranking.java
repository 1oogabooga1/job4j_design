package ru.job4j.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Ranking {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] smth = Arrays.stream(arr).distinct().sorted().toArray();
        for (int i = 0; i < smth.length; i++) {

                map.put(smth[i], i + 1);

        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
