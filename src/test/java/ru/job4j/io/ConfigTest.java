package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithCommentIsNull() {
        String path = "data/pair_with_comment.properties";
        Config con = new Config(path);
        con.load();
        assertThat(con.value("thirdName")).isNull();
    }

    @Test
    void whenPairWithCommentHasValue() {
        String path = "data/pair_with_comment.properties";
        Config con = new Config(path);
        con.load();
        assertThat(con.value("secondName")).isEqualTo("Vasya Vasenkov");
    }

    @Test
    void whenWithoutKeyThenThrowsIllegalArgumentException() {
        String path = "data/pair_without_key.properties";
        Config con = new Config(path);
        assertThrows(IllegalArgumentException.class,
                con::load);
    }

    @Test
    void whenWithoutValueThenThrowsIllegalArgumentException() {
        String path = "data/pair_without_value.properties";
        Config con = new Config(path);
        assertThrows(IllegalArgumentException.class,
                con::load);
    }

    @Test
    void whenWithoutEquallyThenThrowsIllegalArgumentException() {
        String path = "data/pair_without_equally.properties";
        Config con = new Config(path);
        assertThrows(IllegalArgumentException.class,
                con::load);
    }

    @Test
    void whenOnlyEquallyThenThrowsIllegalArgumentException() {
        String path = "data/pair_with_only_equally.properties";
        Config con = new Config(path);
        assertThrows(IllegalArgumentException.class,
                con::load);
    }

    @Test
    void whenValueWithEquallyComment() {
        String path = "./data/pair_with_value_with_equally.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr=");
    }
}