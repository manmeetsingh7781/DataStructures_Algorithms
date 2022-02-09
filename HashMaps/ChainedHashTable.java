package com.company.DynamicDS;

import java.util.*;



/**
 * Grows Dynamically without any load factor
 * Worst Scenario is when the size is small and the items are being added more
 * Worst case is O(n) because it will have to iterate N times to lookup, update, retrieval
 * <p>
 * The bast case is when we have the good hash function and we are filling the available spots and channing is very less
 */

public class ChainedHashTable<K, V> {

    private final Linked_List<Pair<K, V>>[] table;
    private final int table_size;

    public ChainedHashTable(int size) {
        this.table_size = size;
        this.table = new Linked_List[table_size];
    }


    protected void put(K key, V value) {

        int code = hashCode(key);
        // check if the spot is available to insert new pair, and check if hashCode is valid
        if (isHashValid(code)) {

            Pair<K, V> pair = new Pair<>(key, value);

            if (table[code] == null) {
                // if column is empty then make new LinkedList
                table[code] = new Linked_List<>();
                table[code].add(pair);
            } else {

                Optional<Node<Pair<K, V>>> head = table[code].getHead();
                Optional<Node<Pair<K, V>>> keyPosition = containsKey(head.get(), key);

                // if the value is not NUll then we have found the Key to place/append the item
                if (keyPosition.isPresent()) {

                    V items = keyPosition.get().getData().getValue();
                    Linked_List<V> dataSet = new Linked_List<>();

                    // if the value is in LinkedList then just assign it to dataSet else there is for sure scalar item then just add it to list
                    if (items instanceof Linked_List) {
                        dataSet = (Linked_List<V>) items;
                    } else {
                        dataSet.add(items);
                    }

                    // to avoid duplicates
                    if (!dataSet.contains(value)) {      // the T(n) of contains has O(log(n))
                        dataSet.add(value);     // O(1)
                        keyPosition.get().getData().setValue((V) dataSet);  // O(1)
                    }

                } else {
                    // if the node exists but key does not match then we have to simply chain it
                    table[code].add(pair);
                }
            }

        } else throw new ArrayIndexOutOfBoundsException();

    }



    // O(n)
    private Optional<Node<Pair<K, V>>> containsKey(Node<Pair<K, V>> head, K key) {
        Optional<Node<Pair<K, V>>> temp = Optional.ofNullable(head);
        while (temp.isPresent() && !temp.get().getData().getKey().equals(key)) {
            temp = Optional.ofNullable(temp.get().getNext());
        }
        return temp;
    }




    public void update(K key, V value) {
        // get the item
        int code = hashCode(key);

        if (isHashValid(code)) {

            // get the data we need
            Optional<Node<Pair<K, V>>> node = table[code].getHead();


            // flatMap: checks if node is valid
            // if so we are calling function containsKey -> Node
            // if Node is valid erase and update Data
            node.flatMap(pairNode -> containsKey(pairNode, key))
                    .ifPresent(containedItem -> {
                        containedItem.getData().setValue(null);  // erase the value
                        containedItem.getData().setValue(value);  // assign the new value
                    });

        }

    }


    private Node<Pair<K, V>> getNode(K key) {

        int code = hashCode(key);

        // if the hash is valid the proceed
        if (!isHashValid(code)) throw new ArrayIndexOutOfBoundsException();

        // so we can compare Number or String with the Chained Lists
        Object myKey;

        if (key instanceof Number) {
            myKey = ((Number) key).intValue();
        } else {
            myKey = key;
        }


        Optional<Linked_List<Pair<K, V>>> result = Optional.ofNullable(table[code]);

        // if the selected pair is valid return it
        if (result.isPresent()) {

            // there may be chained elements to the list so we will have to loop and find what we are looking for
            Node<Pair<K, V>> head = result.get().getHead().orElse(null);

            while (head != null) {
                // if we have chained list of other values loop through and find the one we need and return it
                if (head.getData().getKey() == myKey) {
                    return head;
                }

                head = head.getNext();
            }
        }
        return null;
    }


    public V get(K key) {
        return Optional.ofNullable(getNode(key)).map(pairNode->pairNode.getData().getValue()).orElse(null);
    }

    protected int hashCode(K key) {

        int code = 0;

        if (key instanceof String) code = ((String) key).length();
        if (key instanceof Number) code = ((Number) key).intValue();

        return code % table_size; // if the code is not generate then add up front
    }

    @Override
    public String toString() {
        return "tabel=" + Arrays.toString(table) + " size=" + table.length;

    }

    protected boolean isHashValid(int code) {
        return code >= 0 && code < table_size;
    }

}
