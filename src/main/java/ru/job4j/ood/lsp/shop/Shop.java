package ru.job4j.ood.lsp.shop;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {
    List<Food> shop = new ArrayList<>();

    @Override
    public void put(Food food) {
        float expiredPercent = ep.getExpiredPercent(food);
        if (expiredPercent > 25 && expiredPercent < 75) {
            shop.add(food);
        }
        if (expiredPercent > 75 && expiredPercent < 100) {
            food.setPrice(food.getPrice() - (food.getPrice() * 0.2));
            food.setDiscount(20);
            shop.add(food);
        }
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
