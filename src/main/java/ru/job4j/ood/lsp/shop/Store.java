package ru.job4j.ood.lsp.shop;

public interface Store {
    void put(Food food);

    Food get(String name);

    String getName();
}
