package ru.job4j.ood.lsp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.shop.Food;
import ru.job4j.ood.lsp.shop.Shop;
import ru.job4j.ood.lsp.shop.Store;

class ShopTest {
    @Test
    void whenPutThenGet() {
        Food food = new Food("Milk");
        Store shop = new Shop();
        shop.put(food);
        assertThat(shop.get("Milk")).isEqualTo(food);
    }

    @Test
    void testMultiplePutAndGet() {
        Food food1 = new Food("Milk");
        Food food2 = new Food("Bread");
        Store shop = new Shop();
        shop.put(food1);
        shop.put(food2);
        assertThat(shop.get("Milk")).isEqualTo(food1);
        assertThat(shop.get("Bread")).isEqualTo(food2);
    }

    @Test
    void testGetNonexistentFood() {
        Food food = new Food("Milk");
        Store shop = new Shop();
        shop.put(food);
        assertThat(shop.get("Bread")).isNull();
    }
}