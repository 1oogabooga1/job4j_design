package ru.job4j.solid.ocp;

public class Character {
    Weapon weapon;
    String name;

    public Character (Weapon weapon, String name) {
        this.name = name;
        this.weapon = weapon;
    }

    public void attack() {
        this.weapon.attack();
    }
}
