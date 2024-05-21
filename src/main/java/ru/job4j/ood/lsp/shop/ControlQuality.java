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
            for (Store store : stores) {
                store.put(food);
            }
        }
    }

    public void resort() {
        for (Store store : stores) {
            distribution(store.getAll());
        }
    }
}
