package ru.job4j.ood.lsp.shop;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {
    List<Food> trash = new ArrayList<>();

    @Override
    public void put(Food food) {
        float expiredPercent = ep.getExpiredPercent(food);
        if (expiredPercent >= 100) {
            trash.add(food);
        }
    }

    @Override
    public Food get(String name) {
        return  trash.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public String getName() {
        return "Trash";
    }
}
