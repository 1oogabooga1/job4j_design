package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIfEvenNumbers() {
        ListUtils.removeIf(input, n -> n % 2 == 0);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenRemoveIfNotEvenNumbers() {
        ListUtils.removeIf(input, n -> n % 2 != 0);
        assertThat(input).hasSize(0);
    }

    @Test
    void whenReplaceIfLessThanTwo() {
        ListUtils.addAfter(input, 0, 7);
        ListUtils.replaceIf(input, n -> n < 2, 5);
        assertThat(input).hasSize(3).containsSequence(5, 7, 3);
    }

    @Test
    void whenReplaceIfMoreThanZero() {
        ListUtils.addAfter(input, 0, 7);
        ListUtils.replaceIf(input, n -> n > 0, 5);
        assertThat(input).hasSize(3).containsSequence(5, 5, 5);
    }

    @Test
    void whenRemoveAll() {
        List<Integer> elements = List.of(1, 2, 3, 4, 5, 6);
        ListUtils.removeAll(input, elements);
        assertThat(input).hasSize(0);
    }
}