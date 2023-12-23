package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean check = table[getIndex(key)] == null;
        if (check) {
            table[getIndex(key)] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        return check;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        capacity = capacity * 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                newTable[getIndex(entry.key)] = entry;
            }
        }
        table = newTable;
    }


    private int getIndex(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }


    @Override
    public V get(K key) {
        V result = null;
        if (match(key)) {
            result = table[getIndex(key)].value;
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean check = false;
        if (match(key)) {
                table[getIndex(key)] = null;
                modCount++;
                count--;
                check = true;
    }
        return check;
    }

    private boolean match(K key) {
        return table[getIndex(key)] != null && Objects.hashCode(table[getIndex(key)].key) == Objects.hashCode(key)
                && Objects.equals(table[getIndex(key)].key, key);
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int index;

            private int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < capacity && table[index] == null) {
                    index++;
                }
                return index < capacity;
            }

            @Override
            public K next() {
               if (!hasNext()) {
                   throw new NoSuchElementException();
               }
               return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
