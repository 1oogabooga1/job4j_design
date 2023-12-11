package ru.job4j.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkTolist() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).first().isEqualTo("first");
        assertThat(list).last().isEqualTo("five");
        assertThat(list).element(3).isNotNull().isEqualTo("four");
    }

    @Test
    void checkToSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).isNotEmpty()
                .hasSize(5)
                .contains("second")
                .containsOnly("second", "three", "first", "five", "four")
                .containsExactlyInAnyOrder("second", "three", "first", "five", "four")
                .containsAnyOf("one", "two", "first")
                .doesNotContain("six", "seven");
    }

    @Test
    void checkToMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<Integer, String> map = Map.of(1, "First", 2, "Second",
                3, "Third",
                4, "Four",
                5, "Five");
        assertThat(map).hasSize(5)
                .containsKeys(4, 5, 3)
                .containsValues("Five", "Four", "Third")
                .containsEntry(1, "First")
                .doesNotContainKey(0)
                .doesNotContainValue("Zero");
    }
}