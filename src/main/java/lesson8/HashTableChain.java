package lesson8;

import java.util.List;

public interface HashTableChain <K, V>{

    boolean put(K key, V value);

    V get(K key);

    V remove(K key);

    int size();

    boolean isEmpty();

    void display();

    interface LinkedHashEntry<K, V> {
        K getKey();
        V getValue();

        void setValue(V value);
    }
}
