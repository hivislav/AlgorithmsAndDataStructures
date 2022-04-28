package lesson8;

import java.util.LinkedList;
import java.util.List;

public class HashTableImplChain<K, V> implements HashTableChain<K, V>{
    private final LinkedItem<K, V>[] data;
    private final LinkedItem<K, V> emptyItem;

    private int size;

    static class LinkedItem<K, V> implements LinkedHashEntry<K, V> {
        private final K key;
        private V value;
        LinkedList<LinkedItem<K, V>> itemsList;
        private LinkedItem<K, V> next;

        LinkedItem(K key, V value) {
            this.key = key;
            this.value = value;
            itemsList = new LinkedList<LinkedItem<K, V>>();
        }

        private List<LinkedItem<K, V>> getItemsList() {
            return itemsList;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        public LinkedItem<K, V> getNext() {
            return next;
        }

        public void setNext(LinkedItem<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return String.format("key: %s -> value: %s", key, value);
        }
    }

    public HashTableImplChain(int initialCapacity) {
        this.data = new LinkedItem[initialCapacity * 2];
        emptyItem = new LinkedItem<>(null, null);
    }

    public HashTableImplChain() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int indexFromHashFunc = hashFunc(key);

        while (data[indexFromHashFunc] != null && data[indexFromHashFunc] != emptyItem) {
            if (isKeyEquals(data[indexFromHashFunc], key)) {
                data[indexFromHashFunc].itemsList.add(new LinkedItem<>(key, value));
                return true;
            }
        }
        data[indexFromHashFunc] = new LinkedItem<>(key, value);
        size++;
        return true;
    }

    private int getStepLinear() {
        return 1;
    }

    private boolean isKeyEquals(LinkedItem<K,V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        return (item.getKey() == null) ? (key == null) : (item.getKey().equals(key));
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);

        return index == -1 ? null : data[index].getValue();
    }

    private int indexOf(K key) {
        int indexFromHashFunc = hashFunc(key);

        int count = 0;
        while (count++ < data.length) {
            if (data[indexFromHashFunc] == null) {
                break;
            }
            if (isKeyEquals(data[indexFromHashFunc], key)) {
                return indexFromHashFunc;
            }
            indexFromHashFunc += getStepLinear();
            indexFromHashFunc %= data.length;
        }
        return -1;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }

        if (data[index].itemsList.isEmpty()) {
            data[index].itemsList.removeFirst();
        }
        else {
            LinkedItem<K, V> removed = data[index];
            data[index] = emptyItem;
            return removed.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                sb.append(String.format("%s = [%s], %s%n", i, data[i], data[i].itemsList.toString()));
            } else {
                sb.append(String.format("%s = [%s]%n", i, data[i]));
            }
        }
        return sb.toString();
    }
}
