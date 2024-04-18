package ru.job4j.ood.lsp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.shop.Food;
import ru.job4j.ood.lsp.shop.Store;
import ru.job4j.ood.lsp.shop.Trash;

class TrashTest {
    @Test
    void whenPutThenGet() {
        Food food = new Food("Milk");
        Store trash = new Trash();
        trash.put(food);
        assertThat(trash.get("Milk")).isEqualTo(food);
    }

    @Test
    void testMultiplePutAndGet() {
        Food food1 = new Food("Milk");
        Food food2 = new Food("Bread");
        Store trash = new Trash();
        trash.put(food1);
        trash.put(food2);
        assertThat(trash.get("Milk")).isEqualTo(food1);
        assertThat(trash.get("Bread")).isEqualTo(food2);
    }

    @Test
    void testGetNonexistentFood() {
        Food food = new Food("Milk");
        Store trash = new Trash();
        trash.put(food);
        assertThat(trash.get("Bread")).isNull();
    }
}
