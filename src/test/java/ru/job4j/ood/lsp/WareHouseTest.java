package ru.job4j.ood.lsp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.shop.Food;
import ru.job4j.ood.lsp.shop.Store;
import ru.job4j.ood.lsp.shop.WareHouse;

import java.time.LocalDateTime;

class WareHouseTest {

    @Test
    void whenPutThenGet() {
        Food food = new Food("Milk", LocalDateTime.of(2024, 4, 25, 0, 0, 0), LocalDateTime.of(2024, 4, 18, 0, 0, 0), 100, 0);
        Store wareHouse = new WareHouse();
        wareHouse.put(food);
        assertThat(wareHouse.get("Milk")).isEqualTo(food);
    }

    @Test
    void whenGetNonExistentItem() {
        Store wareHouse = new WareHouse();
        assertThat(wareHouse.get("Banana")).isNull();
    }

    @Test
    void testPutMultipleAndGetCorrectly() {
        Food food1 = new Food("Apple", LocalDateTime.of(2024, 4, 25, 0, 0, 0),
                LocalDateTime.of(2024, 4, 18, 0, 0, 0), 100, 0);
        Food food2 = new Food("Orange", LocalDateTime.of(2024, 4, 30, 0, 0, 0),
                LocalDateTime.of(2024, 4, 18, 0, 0, 0), 100, 0);
        Store wareHouse = new WareHouse();
        wareHouse.put(food1);
        wareHouse.put(food2);
        assertThat(wareHouse.get("Apple")).isEqualTo(food1);
        assertThat(wareHouse.get("Orange")).isEqualTo(food2);
    }
}