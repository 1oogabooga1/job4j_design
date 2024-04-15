package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.Objects;

public class Food {
    String name;
    LocalDateTime expiryDate;
    LocalDateTime createDate;
    double price;
    int discount;

    public Food(String name, LocalDateTime expiryDate, LocalDateTime createDate, double price, int discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public int getExpiredPercent() {
        int expirationPeriod = expiryDate.getDayOfMonth() - createDate.getDayOfMonth();
        int daysAfterCreation = LocalDateTime.now().getDayOfMonth() - createDate.getDayOfMonth();
        return daysAfterCreation / expirationPeriod * 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Food food)) {
            return false;
        }
        return Double.compare(getPrice(), food.getPrice()) == 0 && getDiscount() == food.getDiscount() && Objects.equals(getName(), food.getName()) && Objects.equals(getExpiryDate(), food.getExpiryDate()) && Objects.equals(getCreateDate(), food.getCreateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getExpiryDate(), getCreateDate(), getPrice(), getDiscount());
    }
}
