package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingCars implements Parking {
    private int sizeForLightCars;

    private int sizeForHeavyCars;
    private List<Car> lightCars = new ArrayList<>(sizeForLightCars);
    private List<Car> heavyCars = new ArrayList<>(sizeForHeavyCars);

    public ParkingCars(int sizeForHeavyCars, int sizeForLightCars) {
        this.sizeForHeavyCars = sizeForHeavyCars;
        this.sizeForLightCars = sizeForLightCars;
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
