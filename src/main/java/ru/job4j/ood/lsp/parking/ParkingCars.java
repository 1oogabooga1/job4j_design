package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
        boolean rsl = false;
        int carSize = car.getCarSize();
        if (carSize != 0) {
            if (carSize > 1 && freeSpaceForHeavyCars() >= carSize) {
                heavyCars.add(car);
                sizeForHeavyCars -= carSize;
                rsl = true;
            }

            if (freeSpaceForLightCars() >= carSize && !rsl) {
                lightCars.add(car);
                sizeForLightCars -= carSize;
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Car get(String name) {
        return Stream
                .concat(heavyCars.stream(), lightCars.stream()).toList()
                .stream()
                .filter(c -> name.equals(c.getName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public int freeSpaceForLightCars() {
        return sizeForLightCars;
    }

    @Override
    public int freeSpaceForHeavyCars() {
        return sizeForHeavyCars;
    }
}
