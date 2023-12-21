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
        int index = indexFor(hash(Objects.hashCode(key)));
        boolean check = table[index] == null;
        if (check) {
            table[index] = new MapEntry(key, value);
            count++;
            modCount++;
        }
        if ((float) count / capacity >= LOAD_FACTOR) {
            expand();
            index = indexFor(hash(Objects.hashCode(key)));
            count--;
            modCount--;
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
                int index = getIndex(entry.key);
                newTable[index] = entry;
            }
        }
        table = newTable;
    }


    private int getIndex(K key) {
        int hashCode = Objects.hashCode(key);
        int hash = hash(hashCode);
        int index = indexFor(hash);
        return index;
    }


    @Override
    public V get(K key) {
        int index = indexFor(hash(Objects.hashCode(key)));
        if (key == null && table[index] != null) {
           if (table[index].value.equals("0")) {
               return null;
           } else {
               return table[index].value;
           }
       }
        if (table[index] != null && table[index].key != null) {
            if (table[index].key.hashCode() == key.hashCode()
                    && Objects.equals(table[index].key, key)) {
                return table[index].value;
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(Objects.hashCode(key)));
        if (key == null && table[index] != null) {
           table[index] = null;
           modCount++;
           count--;
           return true;
        }
        if (table[index] != null && table[index].key != null) {
            if (table[index].key.hashCode() == key.hashCode()
            && Objects.equals(table[index].key, key)) {
                table[index] = null;
                modCount++;
                count--;
                return true;
        }
    }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
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

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
