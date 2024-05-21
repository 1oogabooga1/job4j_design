package ru.job4j.ood.lsp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.shop.*;

import java.time.LocalDateTime;
import java.util.List;

class ControlQualityTest {
    @Test
    void whenLessThan25PercentThenPutInWareHouse() {
        Food milk = new Food("Milk", LocalDateTime.of(2024, 4, 25, 0, 0, 0), LocalDateTime.now(), 100, 0);
        Store wareHouse = new WareHouse();
        Store trash = new Trash();
        Store shop = new Shop();
        List<Store> stores = List.of(wareHouse, trash, shop);
        List<Food> food = List.of(milk);
        ExpiredPercent ep = new ExpiredPercent();
        ControlQuality cq = new ControlQuality(stores, ep);
        cq.distribution(food);
        assertThat(wareHouse.get("Milk")).isEqualTo(milk);
    }

    @Test
    void whenMoreThan25PercentAndLessThan75ThenPutInShop() {
        Food milk = new Food("Milk", LocalDateTime.of(2024, 5, 25, 0, 0, 0), LocalDateTime.of(2024, 3, 15, 0, 0, 0), 100, 0);
        Store wareHouse = new WareHouse();
        Store trash = new Trash();
        Store shop = new Shop();
        List<Store> stores = List.of(wareHouse, trash, shop);
        List<Food> food = List.of(milk);
        ExpiredPercent ep = new ExpiredPercent();
        ControlQuality cq = new ControlQuality(stores, ep);
        cq.distribution(food);
        assertThat(shop.get("Milk")).isEqualTo(milk);
    }

    @Test
    void whenMoreThan75ThenPutInShopWithDiscount() {
        Food milk = new Food("Milk", LocalDateTime.of(2024, 5, 23, 0, 0, 0), LocalDateTime.of(2024, 3, 15, 0, 0, 0), 100, 0);
        Store wareHouse = new WareHouse();
        Store trash = new Trash();
        Store shop = new Shop();
        List<Store> stores = List.of(wareHouse, trash, shop);
        List<Food> food = List.of(milk);
        ExpiredPercent ep = new ExpiredPercent();
        ControlQuality cq = new ControlQuality(stores, ep);
        cq.distribution(food);
        assertThat(shop.get("Milk")).isEqualTo(milk);
        assertThat(shop.get("Milk").getPrice()).isEqualTo(80);
        assertThat(shop.get("Milk").getDiscount()).isEqualTo(20);
    }

    @Test
    void whenMoreThan100ThenPutInTrash() {
        Food milk = new Food("Milk", LocalDateTime.of(2024, 3, 20, 0, 0, 0), LocalDateTime.of(2024, 3, 15, 0, 0, 0), 100, 0);
        Store wareHouse = new WareHouse();
        Store trash = new Trash();
        Store shop = new Shop();
        List<Store> stores = List.of(wareHouse, trash, shop);
        List<Food> food = List.of(milk);
        ExpiredPercent ep = new ExpiredPercent();
        ControlQuality cq = new ControlQuality(stores, ep);
        cq.distribution(food);
        assertThat(trash.get("Milk")).isEqualTo(milk);
    }
}