package ru.job4j.ood.lsp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.shop.Food;
import ru.job4j.ood.lsp.shop.Store;
import ru.job4j.ood.lsp.shop.Trash;

import java.time.LocalDateTime;

class TrashTest {
    @Test
    void whenPutThenGet() {
        Food food = new Food("Milk", LocalDateTime.of(2022, 4, 20, 0, 0, 0), LocalDateTime.of(2021, 3, 15, 0, 0, 0), 100, 0);
        Store trash = new Trash();
        trash.put(food);
        assertThat(trash.get("Milk")).isEqualTo(food);
    }

    @Test
    void testMultiplePutAndGet() {
        Food food1 = new Food("Milk", LocalDateTime.of(2022, 4, 20, 0, 0, 0), LocalDateTime.of(2021, 3, 15, 0, 0, 0), 100, 0);
        Food food2 = new Food("Bread", LocalDateTime.of(2020, 4, 20, 0, 0, 0), LocalDateTime.of(2019, 3, 15, 0, 0, 0), 100, 0);
        Store trash = new Trash();
        trash.put(food1);
        trash.put(food2);
        assertThat(trash.get("Milk")).isEqualTo(food1);
        assertThat(trash.get("Bread")).isEqualTo(food2);
    }

    @Test
    void testGetNonexistentFood() {
        Food food = new Food("Milk", LocalDateTime.of(2024, 4, 20, 0, 0, 0), LocalDateTime.of(2021, 3, 15, 0, 0, 0), 100, 0);
        Store trash = new Trash();
        trash.put(food);
        assertThat(trash.get("Bread")).isNull();
    }
}
