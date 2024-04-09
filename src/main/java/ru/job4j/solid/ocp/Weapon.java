package ru.job4j.solid.ocp;

import java.util.List;

public class Weapon {
    private String type;
    private int damage;
    private int range;

    private List<Weapon> weapons;

    public Weapon(String type, int damage, int range) {
        this.type = type;
        this.range = range;
        this.damage = damage;
    }

    public void attack() {
        System.out.println("урон от удара мечом " + this.damage);
    }

    public List<Weapon> sort(List<Weapon> list) {
        return list.stream().sorted().toList();
    }
}
