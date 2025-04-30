package ru.job4j.leetcode;

import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String s) {
        LinkedHashMap<Character, Character> pairs = new LinkedHashMap<>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');
        boolean result = false;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.pop().equals(getKey(c, pairs))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static Character getKey(Character value, LinkedHashMap<Character, Character> pairs) {
        Character result = null;
        for (Map.Entry<Character, Character> entry : pairs.entrySet()) {
            if (entry.getValue().equals(value)) {
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] arg2s) {
        String s = "{}";
        System.out.println(isValid(s));
    }
}
