package ru.job4j.template;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

@Disabled
class GeneratorRealisationTest {
    @Test
    void whenNameIsDmitrii() {
        GeneratorRealisation gen = new GeneratorRealisation();
        String template = "I'm ${name}";
        Map<String, String> args = Map.of("name", "Dmitrii");
        String expected = "I'm Dmitrii";
        assertThat(gen.produce(template, args)).isEqualTo(expected);
    }

    @Test
    void whenNameNotFound() {
        GeneratorRealisation gen = new GeneratorRealisation();
        String template = "I'm ${name}";
        Map<String, String> args = Map.of("age", "18");
        assertThatThrownBy(() -> gen.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenExtraArgsInMap() {
        GeneratorRealisation gen = new GeneratorRealisation();
        String template = "I'm ${name}";
        Map<String, String> args = Map.of("age", "18", "name", "Dmitrii");
        assertThatThrownBy(() -> gen.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }
}