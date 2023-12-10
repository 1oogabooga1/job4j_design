package ru.job4j.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class ModelTest {

    @Test
    void checkBoolean() {
        Model model = new Model(1, 5.255d, "name", true);
        boolean result = model.isCondition();
        assertThat(result).isTrue();
    }
}