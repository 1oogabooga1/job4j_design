package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {
    List<Food> trash = new ArrayList<>();

    @Override
    public void put(Food food) {
        trash.add(food);
    }

    @Override
    public Food get(String name) {
        return trash.stream().filter(f -> f.getName().equals(name)).findFirst().get();
    }

    @Override
    public String getName() {
        return "Trash";
    }
}