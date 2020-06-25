package com.dailyaccumulation.datastructure;

import com.thinkInJava.fourthchapter.pets.Individual;

import java.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    static final int SIZE = 997;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;

        if (buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()){
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }

        if (!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K, V> iPair : buckets[index]){
            if (iPair.getKey().equals(key)){
                return iPair.getValue();
            }
        }
        return null;
    }

    public Set<Map.Entry<K, V>> entrySet(){
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> buckt : buckets){
            if (buckt == null) continue;
            for (MapEntry<K, V> mapEntry : buckt){
                set.add(mapEntry);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.put("CAMEROON", "Yaounde");
        simpleHashMap.put("CONGO", "Brazzaville");
        simpleHashMap.put("CHAD", "N'djamena");
        System.out.println(simpleHashMap);
        System.out.println(simpleHashMap.get("CAMEROON"));
        System.out.println(simpleHashMap.entrySet());
    }
}
