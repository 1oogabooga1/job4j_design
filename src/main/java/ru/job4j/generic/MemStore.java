package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        T find = findById(id);
        return storage.replace(id, find, model);
    }

    @Override
    public void delete(String id) {
        T find = findById(id);
        if (find != null) {
            storage.remove(find.getId());
        }
    }

    @Override
    public T findById(String id) {
        for (Map.Entry<String, T> k : storage.entrySet()) {
            if (k.getKey().equals(id)) {
                return k.getValue();
            }
        }
        return null;
    }
}
