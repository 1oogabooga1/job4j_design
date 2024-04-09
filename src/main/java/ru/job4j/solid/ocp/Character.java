package ru.job4j.solid.ocp;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Character {

    Date date = new Date();

    List<Character> characters;
    Weapon weapon;
    String name;

    public Character(Weapon weapon, String name, Date date) {
        this.name = name;
        this.weapon = weapon;
        this.date = date;
    }

    public void attack() {
        this.weapon.attack();
    }

    public List<Character> sort(List<Character> list) {
        return list.stream().sorted().toList();
    }
}
