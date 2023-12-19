package ru.job4j.map;

import java.util.*;

import static java.util.Calendar.NOVEMBER;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar birthday = new GregorianCalendar(2005, NOVEMBER, 10);
        User first = new User("Dmitrii", 0, birthday);
        User second = new User("Dmitrii", 0, birthday);
        Map<User, Object> map = new HashMap<>(15);
        map.put(first, new Object());
        map.put(second, new Object());
        int hashCode1 = first.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int bucket1 = hash1 & 15;
        int hashCode2 = second.hashCode();
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int bucket2 = hash2 & 15;
        System.out.println(map);
    }
}
