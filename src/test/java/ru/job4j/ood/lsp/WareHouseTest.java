package ru.job4j.ood.lsp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class WareHouseTest {

    @Test
    void whenPutThenGet() {
        Food food = new Food("Milk");
        Store wareHouse = new WareHouse();
        wareHouse.put(food);
        assertThat(wareHouse.get("Milk")).isEqualTo(food);
    }

}