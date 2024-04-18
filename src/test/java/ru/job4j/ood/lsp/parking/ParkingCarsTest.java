package ru.job4j.ood.lsp.parking;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class ParkingCarsTest {
    @Test
    void whenPutLightCar() {
        Car car = new Car("Toyota", 1);
        ParkingCars pc = new ParkingCars(2, 10);
        assertThat(pc.put(car)).isTrue();
        assertThat(pc.freeSpaceForLightCars()).isEqualTo(1);
        assertThat(pc.freeSpaceForHeavyCars()).isEqualTo(10);
        assertThat(pc.get("Toyota")).isEqualTo(car);
    }

    @Test
    void whenPutHeavyCar() {
        Car car = new Car("Kamaz", 10);
        Parking pc = new ParkingCars(10, 15);
        assertThat(pc.put(car)).isTrue();
        assertThat(pc.freeSpaceForHeavyCars()).isEqualTo(5);
        assertThat(pc.freeSpaceForLightCars()).isEqualTo(10);
        assertThat(pc.get("Kamaz")).isEqualTo(car);
    }

    @Test
    void whenNoFreeSpaceForHeavyCars() {
        Car car = new Car("Kamaz", 10);
        Parking pc = new ParkingCars(15, 8);
        assertThat(pc.put(car)).isTrue();
        assertThat(pc.freeSpaceForLightCars()).isEqualTo(5);
        assertThat(pc.freeSpaceForHeavyCars()).isEqualTo(8);
        assertThat(pc.get("Kamaz")).isEqualTo(car);
    }

    @Test
    void whenPutHeavyCarsAndLightCars() {
        Car heavyCar = new Car("Kamaz", 10);
        Car firstLightCar = new Car("Toyota", 1);
        Car secodnLightCar = new Car("Mercedes", 1);
        Parking pc = new ParkingCars(2, 10);
        assertThat(pc.put(heavyCar)).isTrue();
        assertThat(pc.put(firstLightCar)).isTrue();
        assertThat(pc.put(secodnLightCar)).isTrue();
        assertThat(pc.freeSpaceForLightCars()).isNull();
        assertThat(pc.freeSpaceForHeavyCars()).isNull();
        assertThat(pc.get("Kamaz")).isEqualTo(heavyCar);
        assertThat(pc.get("Toyota")).isEqualTo(firstLightCar);
        assertThat(pc.get("Mercedes")).isEqualTo(secodnLightCar);
    }

    @Test
    void whenNoFreeSpaceAtAll() {
        Car car = new Car("Toyota", 1);
        Car heavyCar = new Car("Kamaz", 10);
        Parking pc = new ParkingCars(0, 0);
        assertThat(pc.put(car)).isFalse();
        assertThat(pc.put(heavyCar)).isFalse();
    }

    @Test
    void whenGetNonExistedCar() {
        Parking pc = new ParkingCars(10, 10);
        assertThatThrownBy(() -> pc.get("Smth"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenInvalidCarSize() {
        Car car = new Car("Smth", 0);
        Parking pc = new ParkingCars(10, 10);
        assertThat(pc.put(car)).isFalse();
    }
}