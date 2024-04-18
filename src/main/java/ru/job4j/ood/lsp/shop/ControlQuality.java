package ru.job4j.ood.lsp.shop;

import java.util.List;

public class ControlQuality {
   private List<Store> stores;

   private ExpiredPercent ep;

    public ControlQuality(List<Store> stores, ExpiredPercent ep) {
        this.stores = stores;
        this.ep = ep;
    }

    public void distribution(List<Food> list) {
        for (Food food : list) {
            float expiredPercent = ep.getExpiredPercent(food);
            if (expiredPercent < 25) {
                getStore("WareHouse").put(food);
            }
            if (expiredPercent > 25 && ep.getExpiredPercent(food) < 75) {
                getStore("Shop").put(food);
            }
            if (expiredPercent > 75 && ep.getExpiredPercent(food) < 100) {
                food.setPrice(food.getPrice() - (food.getPrice() * 0.2));
                food.setDiscount(20);
                getStore("Shop").put(food);
            }
            if (expiredPercent >= 100) {
                getStore("Trash").put(food);
            }
        }
    }

    private Store getStore(String name) {
        return stores.stream().filter(s -> s.getName().equals(name)).findFirst().get();
    }

}
