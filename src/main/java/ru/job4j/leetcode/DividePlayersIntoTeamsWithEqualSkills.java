package ru.job4j.leetcode;

import java.util.Arrays;

public class DividePlayersIntoTeamsWithEqualSkills {
    public static long dividePlayers(int[] skill) {
        if (skill.length % 2 != 0) {
            return -1;
        }
        Arrays.sort(skill);
        int left = 0;
        int right = skill.length - 1;
        int totalSkill = 0;
        long totalChemistry = 0;
        int expSkill = skill[left] + skill[right];
        while (left < right) {
            int currentSkill = skill[left] + skill[right];
            System.out.println("Current skill - " + currentSkill);
           totalSkill += skill[left] + skill[right];
           totalChemistry += (long) skill[left] * skill[right];
           if (expSkill != currentSkill) {
               return -1;
           }
           left++;
           right--;
        }
        System.out.println("Total - " + totalSkill * skill.length);
        System.out.println("Total skill - " + totalSkill);
        System.out.println("Total chemistry - " + totalChemistry);
        return totalChemistry;
    }

    public static void main(String[] args) {
        int[] skill = {3, 4};
        dividePlayers(skill);
    }
}
