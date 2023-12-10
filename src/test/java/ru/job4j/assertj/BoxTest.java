package ru.job4j.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import org.junit.jupiter.api.Test;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 8);
        assertThat(box.whatsThis()).isEqualTo("Cube");
    }

    @Test
    void whenVerticesEqualsFour() {
        Box box = new Box(4, 4);
        assertThat(box.getNumberOfVertices()).isEqualTo(4);
    }

    @Test
    void whenVerticesEqualsZero() {
        Box box = new Box(0, 10);
        assertThat(box.getNumberOfVertices()).isZero();
    }

    @Test
    void whenExist() {
        Box box = new Box(8, 8);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void whenDoesntExist() {
        Box box = new Box(0, 0);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void whenAreaEqualsTwentySeven() {
        Box box = new Box(4, 4);
        assertThat(box.getArea()).isEqualTo(27.7D, withPrecision(0.1d));
    }

    @Test
    void whenAreaEqualsThreeHundredEightyFour() {
        Box box = new Box(8, 8);
        assertThat(box.getArea()).isEqualTo(384);
    }
}