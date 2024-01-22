package org.example;

public class MyHashMap<K, V> implements MethodsMap {
    private final float LOAD_FACTOR = 0.75f;
    private int capacity = 1;
    private Entry<K, V>[] table;

    static class Entry<K, V> {
        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        K key;
        V value;
        Entry<K, V> next;

    }

    public MyHashMap() {
        table = new Entry[capacity];

    }

    private int hash(K key) { // Создаем хэш ключа
        return Math.abs(key.hashCode()) % capacity;
    }


    @Override
    public void put(Object newKey, Object data) { // Добовление ключ ,значение
        if (newKey == null)
            return;    //не позволяет сделать null ключом

        //считаем хэш код
        int hash = hash((K) newKey);
        //create new entry.
        Entry<K, V> newEntry = new Entry<K, V>((K) newKey, (V) data, null);

        //если местоположение таблицы не содержит какой-либо записи, сохраните запись там
        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) { //мы достигли последней записи бакета
                if (current.key.equals(newKey)) {
                    if (previous == null) {  //нод вставляет в первый бакет
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    @Override
    public Object get(Object key) {
        int hash = hash((K) key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //возврощает значение по ключу
            }
            return null;   //возврощает нулл если ключа нет
        }
    }


    @Override
    public boolean remove(Object deleteKey) {

        int hash = hash((K) deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) { //достигли последнего нода бакета
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {  // удалить первый нод входа
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    @Override
    public void display() {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    System.out.print("{" + entry.key + ":" + entry.value + "}" + " ");
                    entry = entry.next;
                }
            }
        }

    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    entry = entry.next;
                    counter++;

                }
            }
        }
        return counter;

    }


}
