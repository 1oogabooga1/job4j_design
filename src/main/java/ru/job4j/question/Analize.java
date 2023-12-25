package ru.job4j.question;

import java.util.*;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info rsl = new Info(0, 0, 0);
        Map<Integer, User> prev = new HashMap<>();
        previous.forEach(k -> prev.put(k.getId(), k));
        Map<Integer, User> curr = new HashMap<>();
        current.forEach(k -> curr.put(k.getId(), k));
        Iterator<User> first = prev.values().iterator();
        Iterator<User> second = curr.values().iterator();
        while (first.hasNext() && second.hasNext()) {
            User firstUser = first.next();
            User secondUser = second.next();
            if (prev.size() < curr.size()) {
                rsl.setAdded(+1);
            }
            if (firstUser.getId() != secondUser.getId()
                    && !firstUser.getName().equals(secondUser.getName())
                    && previous.size() <= current.size()) {
                rsl.setAdded(+1);
            }
            if (firstUser.getId() == secondUser.getId()
                    && !firstUser.getName().equals(secondUser.getName())) {
                rsl.setChanged(+1);
            }
            if (firstUser.getId() != secondUser.getId()
                    && !firstUser.getName().equals(secondUser.getName())
                    && previous.size() >= current.size()) {
                rsl.setDeleted(+1);
            }
        }
        return rsl;
    }
}