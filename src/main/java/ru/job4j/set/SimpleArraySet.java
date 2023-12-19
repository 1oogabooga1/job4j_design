package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArraySet<T> implements SimpleSet<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean check = contains(value);
        if (!check) {
            set.add(value);
        }
        return !check;
    }

    @Override
    public boolean contains(T value) {
        boolean check = false;
        for (T t : set) {
            if (Objects.equals(t, value)) {
                check = true;
                break;
            }
        }
        return check;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleArraySet<?> that = (SimpleArraySet<?>) o;
        return Objects.equals(set, that.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }
}
