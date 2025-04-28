package ru.job4j.leetcode;

import java.util.HashSet;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        int left = 0;
        int maxLength = 0;
        int startIndex = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < str.length(); right++) {
            char currentChar = str.charAt(right);
            while (set.contains(currentChar)) {
                set.remove(str.charAt(left));
                left++;
            }
            set.add(currentChar);
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }
        return str.substring(startIndex, startIndex + maxLength);
    }
}
