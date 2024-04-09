package ru.job4j.solid.ocp;

public class Fight {

    public static void main(String[] args) {
        Weapon sword = new Weapon("sword", 15, 2);
        Character character = new Character(sword, "Dmitrii");
        character.attack();
    }
}
