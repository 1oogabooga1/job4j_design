package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int numberOfLists = nodes.size();
        int currentListIndex = 0;

        while (source.hasNext()) {
            ArrayList<Integer> currentList = nodes.get(currentListIndex);
            currentList.add(source.next());
            currentListIndex++;
            if (currentListIndex == numberOfLists) {
                currentListIndex = 0;
            }
        }
    }
}
