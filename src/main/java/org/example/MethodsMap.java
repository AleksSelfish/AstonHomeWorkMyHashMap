package org.example;

public interface MethodsMap<K, V> {

    void put(K key, V value);

    K get(K key);

    boolean remove(K key);

    void display();

    int size();

}
