package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.time.Period;

public class ExpiredPercent {

    public float getExpiredPercent(Food food) {
        float first = Period.between(food.getCreateDate().toLocalDate(), food.getExpiryDate().toLocalDate()).getDays()
                + Period.between(food.getCreateDate().toLocalDate(), food.getExpiryDate().toLocalDate()).getMonths() * 10;
        float second =  Period.between(food.getCreateDate().toLocalDate(), LocalDateTime.now().toLocalDate()).getDays()
                + Period.between(food.getCreateDate().toLocalDate(), LocalDateTime.now().toLocalDate()).getMonths() * 10;
        return second / first * 100;
    }
}
