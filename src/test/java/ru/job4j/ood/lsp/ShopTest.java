package ru.job4j.ood.lsp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class ShopTest {
    @Test
    void whenPutThenGet() {
        Food food = new Food("Milk");
        Store shop = new Shop();
        shop.put(food);
        assertThat(shop.get("Milk")).isEqualTo(food);
    }
}