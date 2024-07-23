package ru.job4j.ood.lsp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.shop.Food;
import ru.job4j.ood.lsp.shop.Shop;
import ru.job4j.ood.lsp.shop.Store;

import java.time.LocalDateTime;

class ShopTest {
    @Test
    void whenPutThenGet() {
        Food food = new Food("Milk", LocalDateTime.of(2024, 7, 28, 0, 0, 0),
                LocalDateTime.of(2024, 4, 17, 0, 0, 0), 100, 0);
        Store shop = new Shop();
        shop.put(food);
        assertThat(shop.get("Milk")).isEqualTo(food);
    }

    @Test
    void testMultiplePutAndGet() {
        Food food1 = new Food("Milk", LocalDateTime.of(2024, 7, 28, 0, 0, 0),
                LocalDateTime.of(2024, 3, 15, 0, 0, 0), 100, 0);
        Food food2 = new Food("Bread", LocalDateTime.of(2024, 7, 28, 0, 0, 0),
                LocalDateTime.of(2024, 3, 15, 0, 0, 0), 100, 0);
        Store shop = new Shop();
        shop.put(food1);
        shop.put(food2);
        assertThat(shop.get("Milk")).isEqualTo(food1);
        assertThat(shop.get("Bread")).isEqualTo(food2);
    }

    @Test
    void whenProductIsExpired() {
        Food food = new Food("Bread", LocalDateTime.of(2023, 4, 20, 0, 0, 0), LocalDateTime.of(2024, 3, 15, 0, 0, 0), 100, 0);
        Store shop = new Shop();
        shop.put(food);
        assertThat(shop.get("Bread")).isNull();
    }
}