package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {
    List<Food> shop = new ArrayList<>();

    @Override
    public void put(Food food) {
        shop.add(food);
    }

    @Override
    public Food get(String name) {
        return shop.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public String getName() {
        return "Shop";
    }
}
