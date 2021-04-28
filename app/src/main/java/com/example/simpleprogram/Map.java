package com.example.simpleprogram;

import java.lang.reflect.Array;
import java.util.ArrayList;

class Map<K,V>{
    //=====================================
    class Item<K,V>{
        K key;
        V value;
        Item<K,V> next;
        public Item(K key, V value) {
            this.key=key; this.value=value;
        }
    }
    //======================================

   public  ArrayList<Item<K,V>> list;
    private int currentSize;
    private int maxSize;
    public Map() {
        list = new ArrayList<Item<K,V>>();
        maxSize=1024;
        currentSize=0;
        for(int i=0; i<maxSize; i++) {
            list.add(null);
        }

    }

    private int generateIndex(K key) {
        int index = key.hashCode() % maxSize;
        if(index < 0)
            index *= -1;
        return index;
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }

    void add(K key, V value) {
        int index = generateIndex(key);
        Item<K,V> item = list.get(index);
        while(item != null) {
            if(item.key.equals(key)) {
                item.value=value; return;
            }
            item = item.next;
        }

        currentSize++;
        item = list.get(index);
        //Item<K,V> newNode = new Item<K,V>(key, value);
        list.set(index, new Item<K,V>(key,value));
    }

    V delete(K key) {
        int index = generateIndex(key);
        Item<K,V> item = list.get(index);
        Item<K,V> previous = null;
        while(item != null) {
            if(item.key.equals(key))
                break;
            previous=item;
            item=item.next;
        }
        if(item == null) {
            System.out.println("Cannot remove. "
                    + "There is no such thing as \'"+key
                    +"\" in the current model.");
            return null;
        }

        currentSize--;
        if(previous != null) {
            previous.next = item.next;
        } else {
            list.set(index, item.next);
        }
        System.out.println("### REMOVING VALUE \""+item.value+"\" AT KEY \""+item.key + "\" ###");
        return item.value;
    }

    V get(K key) {
        int index = generateIndex(key);
        Item<K,V> item = list.get(index);
        while(item != null) {
            if(item.key.equals(key))
                return item.value;
            item=item.next;
        }
        System.out.println("There is no such thing as \"" + key
                +"\" in the current model.");
        return null;
    }

    void print() {
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) != null)
                System.out.print(list.get(i).value+"... ");
        }
        System.out.println();
    }
    ArrayList<String> values(){
        ArrayList<String> toReturn = new ArrayList<>();
        for(int j=0; j<list.size(); j++){
            if(list.get(j) != null)
                toReturn.add(list.get(j).value.toString());
        ;
        }
        return toReturn;
    }

    ArrayList<String> keys(){
        ArrayList<String> toReturn = new ArrayList<>();
        for(int j=0; j<list.size(); j++){
            if(list.get(j) != null)
                toReturn.add(list.get(j).key.toString());
            ;
        }
        return toReturn;
    }

}