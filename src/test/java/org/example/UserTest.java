package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class UserTest {
    @Test
    void сheckSizeMapTest(){
        MyHashMap<String,Integer> array = new MyHashMap<>();
        array.put("1",1);
        Assertions.assertEquals(1,array.size());

    }
@Test
    void сheckRemoveFromHashMapTest(){
        MyHashMap<String,Integer> array = new MyHashMap<>();
        array.put("1",1);
        array.remove("1");
        Assertions.assertEquals(0,array.size());
    }

    @Test
    void сheckPutInHashMapKeyValueTest(){
        MyHashMap<String,Integer> array = new MyHashMap<>();
        array.put("1",1);
        array.put("2",2);
        Assertions.assertEquals(2,array.size());
    }
    @Test
    void checkGetKeyFromHashMapTest(){
        MyHashMap<String,Integer> array = new MyHashMap<>();
        array.put("1",1);
        Assertions.assertEquals(1,array.get("1"));
    }
    @Test
    void checkGetHashcodeForKeyTest(){
        MyHashMap<String,Integer> array = new MyHashMap<>();
        array.put("1",1);
        Assertions.assertTrue(array.hashCode() >= 0);
    }
}
