package ru.job4j.ood.lsp;

public interface Store {
    void put(Food food);

    Food get(Food food);
}
