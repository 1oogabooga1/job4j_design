package ru.job4j.solid.srp.breakPrincipe;

import java.util.List;

public class Groceries implements SearchShop<String> {
    private List<Product> products;

    @Override
    public Product search(String name) {
        Product pr = null;
        for (Product product : products) {
            if (name.equals(product.getName())) {
                pr = product;
            }
        }
        return pr;
    }

    @Override
    public void add(String name) {
        products.add(new Product(name));
    }

    @Override
    public void delete(String name) {
        products.removeIf(product -> product.getName().equals(name));
    }

    @Override
    public void showAllProducts() {
        Print print = new Print();
        for (Product product : products) {
            print.out(product.getName());
        }
    }
}
