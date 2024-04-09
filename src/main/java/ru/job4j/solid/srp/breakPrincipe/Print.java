package ru.job4j.solid.srp.breakPrincipe;

public class Print implements Output {
    @Override
    public void out(String text) {
        System.out.println(text);
    }
}
