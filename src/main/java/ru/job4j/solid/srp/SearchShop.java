package ru.job4j.solid.srp;

public interface SearchShop<K> {
    Product search(K name);
    void add(K name);

    void delete(K name);

    void showAllProducts();

}
