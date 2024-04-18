package ru.job4j.ood.lsp.parking;

public interface Parking {

    boolean put(Car car);

    Car get(String name);

    int freeSpaceForLightCars();

    int freeSpaceForHeavyCars();
}

