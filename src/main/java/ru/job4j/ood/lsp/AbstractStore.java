package ru.job4j.ood.lsp;

import java.util.List;
import java.util.Optional;

public abstract class AbstractStore implements Store {
    List<Food> allFood;

    @Override
    public Food get(Food food) {
       Optional<Food> o = allFood.stream().filter(f -> f.getName().equals(f.name)).findFirst();
       return o.get();
    }
}
