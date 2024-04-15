package ru.job4j.ood.lsp;

import java.util.List;

public class Shop extends AbstractStore {
    List<Food> shop;

    @Override
    public void put(Food food) {
        shop.add(food);
    }
}
