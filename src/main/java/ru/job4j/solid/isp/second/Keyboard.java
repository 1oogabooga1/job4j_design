package ru.job4j.solid.isp.second;

public class Keyboard implements Devices {
    /**
     * Данный класс зависит от методов, в которых не нуждается
     * Это ведет к нарушению принципа ISP
     */
    @Override
    public void getInternetConnection() {
        System.out.println("Impossible");
    }

    @Override
    public void makePhoto() {
        System.out.println("impossible");
    }

    @Override
    public void recordVideo() {
        System.out.println("impossimple");
    }

    @Override
    public void text() {
        System.out.println("I can text, because i am a keyboard");
    }

    @Override
    public void turnLightsOn() {
        System.out.println("I have RGB lights");
    }
}
