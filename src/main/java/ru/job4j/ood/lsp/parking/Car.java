package ru.job4j.ood.lsp.parking;

public class Car {
    private String name;
    private int carSize;

    public Car(String name, int carSize) {
        this.name = name;
        this.carSize = carSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarSize() {
        return carSize;
    }

    public void setCarSize(int carSize) {
        this.carSize = carSize;
    }
}
