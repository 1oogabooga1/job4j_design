package ru.job4j.ood.lsp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class TrashTest {
    @Test
    void whenPutThenGet() {
        Food food = new Food("Milk");
        Store trash = new Trash();
        trash.put(food);
        assertThat(trash.get("Milk")).isEqualTo(food);
    }
}