package ru.job4j.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RabbitsInForest {
    public static int numRabbits(int[] answers) {
        int result = 0;
        HashMap<Integer, Integer> bunnies = new HashMap<>();
        for (int answer : answers) {
            bunnies.put(answer, bunnies.getOrDefault(answer, 0) + 1);
        }
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : bunnies.entrySet()) {
            int x = entry.getKey(); // ответ кролика
            int count = entry.getValue(); // количество таких ответов
            int groupSize = x + 1; // всего кроликов такого цвета
            int groups = (count + x) / groupSize;
            total += groups * groupSize;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[] {1, 1, 2}));
    }
}
