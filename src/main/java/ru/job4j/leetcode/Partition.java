package ru.job4j.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Partition {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> rsl = new ArrayList<>();
        int prev = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            max = Math.max(max, map.get(ch));
            if (max == i) {
                int range = max - prev;
                rsl.add(range);
                prev = max;
            }
        }
        return rsl;
    }
}
