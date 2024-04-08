package ru.job4j.solid.srp;

public class Print implements Output {
    @Override
    public void out(String text) {
        System.out.println(text);
    }
}
