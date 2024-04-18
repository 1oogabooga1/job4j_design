package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingCars implements Parking {
    private int size;
    private List<Car> lightCars = new ArrayList<>(size);
    private List<Car> heavyCars = new ArrayList<>(size);

    public ParkingCars(int size, List<Car> lightCars, List<Car> heavyCars) {
        this.size = size;
        this.lightCars = lightCars;
        this.heavyCars = heavyCars;
    }

    @Override
    public boolean put(Car car) {
        return false;
    }

    @Override
    public Car get(Car car) {
        return null;
    }
}
