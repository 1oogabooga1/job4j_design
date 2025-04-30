package ru.job4j.leetcode;

public class CountAndSay {
    public static String countAndSay(int n) {
        String result = "1";
        StringBuilder smth = new StringBuilder();
        int count = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    smth.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            smth.append(count).append(result.charAt(result.length() - 1));
            result = smth.toString();
            count = 1;
            smth = new StringBuilder();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
