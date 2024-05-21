package ru.job4j.ood.lsp.shop;

import java.util.List;

public interface Store {
    void put(Food food);

    Food get(String name);

    String getName();

    List<Food> getAll();
}
