package ru.job4j.question;

import java.util.*;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info rsl = new Info(0, 0, 0);
        Map<Integer, User> prev = new HashMap<>();
        previous.forEach(user -> prev.put(user.getId(), user));
        int changed = 0;
        int added = 0;
        for (User currentUser : current) {
            User prevUser = prev.get(currentUser.getId());
            if (prevUser != null) {
                if (!prevUser.equals(currentUser)) {
                    changed++;
                }
                prev.remove(currentUser.getId());
            } else {
                added++;
            }
        }
        rsl.setDeleted(prev.size());
        rsl.setAdded(added);
        rsl.setChanged(changed);
        return rsl;
    }
}