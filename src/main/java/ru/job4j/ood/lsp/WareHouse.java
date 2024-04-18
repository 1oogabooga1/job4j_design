package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class WareHouse extends AbstractStore {
    private List<Food> wareHouse = new ArrayList<>();

    @Override
    public void put(Food food) {
            wareHouse.add(food);
    }

    @Override
    public Food get(String name) {
        return wareHouse.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public String getName() {
        return "WareHouse";
    }
}
