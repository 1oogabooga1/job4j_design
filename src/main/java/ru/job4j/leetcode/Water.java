package ru.job4j.leetcode;

class Water {
    public static int maxArea(Integer[] height) {
        int firstPointer = 0;
        int secondPointer = height.length - 1;
        int maxArea = 0;
        int width;
        int currentHeight;
        int area;
        int prevArea = 0;
        while (firstPointer < secondPointer) {
            width = secondPointer - firstPointer;
            currentHeight = Math.min(height[firstPointer],
                    height[secondPointer]);
            area = currentHeight * width;
            maxArea = Math.max(prevArea, area);
            if (area > prevArea) {
                prevArea = area;
            }
            if (height[firstPointer] < height[secondPointer]) {
                firstPointer++;
            } else {
                secondPointer--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Integer[] height = new Integer[] {1, 8, 6, 2, 5, 6, 7, 1020};
        System.out.println(maxArea(height));
    }
}
