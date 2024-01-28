package org.example;

import java.util.HashMap;

class Mian{
    public static void main(String[] args) {
        MyHashMap<String,Integer> array = new MyHashMap<>();
        array.put("1",1);
        array.put("2",1);
        array.put("3",1);
        array.put("4",1);
        System.out.println(array.size());
    }
}