package ru.job4j.ood.lsp.shop;

import java.time.LocalDateTime;
import java.time.Period;

public class ExpiredPercent {

    public float getExpiredPercent(Food food) {
        Period betweenCreatedAndExpired = Period.between(food.getCreateDate().toLocalDate(), food.getExpiryDate().toLocalDate());
        Period betweenCreatedAndNow = Period.between(food.getCreateDate().toLocalDate(), LocalDateTime.now().toLocalDate());
        float first = betweenCreatedAndExpired.getDays()
                + betweenCreatedAndExpired.getMonths() * 10
                + betweenCreatedAndExpired.getYears() * 365;
        float second =  betweenCreatedAndNow.getDays()
                + betweenCreatedAndNow.getMonths() * 10
                + betweenCreatedAndNow.getYears() * 365;
        return second / first * 100;
    }
}
