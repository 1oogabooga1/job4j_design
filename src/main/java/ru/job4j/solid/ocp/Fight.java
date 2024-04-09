package ru.job4j.solid.ocp;

import java.sql.Date;

public class Fight {

    public static void main(String[] args) {
        Weapon sword = new Weapon("sword", 15, 2);
        Character character = new Character(sword, "Dmitrii", Date.valueOf("08.04.2024"));
        character.attack();
    }

}
