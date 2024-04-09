package ru.job4j.solid.ocp;

public class Weapon {
    private String type;
    private int damage;
    private int range;

    public Weapon (String type, int damage, int range) {
        this.type = type;
        this.range = range;
        this.damage = damage;
    }

    public void attack() {
        System.out.println("урон от удара мечом " + this.damage);
    }
}
