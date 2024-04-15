package ru.job4j.ood.lsp;

import java.util.List;

public class Trash extends AbstractStore {
    List<Food> trash;

    @Override
    public void put(Food food) {
        trash.add(food);
    }
}
