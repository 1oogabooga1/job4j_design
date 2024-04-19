package ru.job4j.solid.isp.first;

public class Cow implements Animals {

    @Override
    public void fly() {
        System.out.println("I cant fly");
    }

    @Override
    public void walk() {
        System.out.println("I can walk");
    }

    /**
     * Данный класс зависит от метода run(), хоть в нем и не нуждается
     * тк корова бегать не умеет. Данная ошибка ведет к нарушению принципа ISP
     */

    @Override
    public void run() {
        System.out.println("I cant run");
    }

    @Override
    public void eat() {
        System.out.println("I eat grass");
    }

    @Override
    public void sex() {
        System.out.println("I can be female or male");
    }
}
