package ru.job4j.ood.lsp;

import java.util.List;

public class WareHouse extends AbstractStore {
    List<Food> wareHouse;

    @Override
    public void put(Food food) {
            wareHouse.add(food);
    }
}
