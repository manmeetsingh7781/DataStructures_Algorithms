package com.company.DynamicDS;


import java.util.Arrays;
import java.util.Optional;

/*
Has load factor, if the table is full the factor is 1
Dealing with Collisions with Open Addressing
I will be using Linear Probing or Quadratic Probing
* */
public class OpenAddressingHashTable<K, V> extends ChainedHashTable<K, V> {

    private int length = 0;
    private final Pair<K, V>[] table;

    public OpenAddressingHashTable(int size) {
        super(size);
        table = new Pair[size];
    }


    public void put(K key, V value) {
        int code = linearProbing(key, false);

        if (isHashValid(code)) {

            // if we are trying to add new Pair check if spot is available else throw error
            if (table[code] == null && length < table.length) {

                table[code] = new Pair<>(key, value);
                length++;

            } else if (findKeySlot(key, code)) {

                // if key is already in the table, then append it
                V items = table[code].getValue();
                Linked_List<V> linkedList = new Linked_List<>();

                if (items instanceof Linked_List) {
                    linkedList = (Linked_List<V>) items;
                } else {
                    linkedList.add(items);
                }

                if (!linkedList.contains(value)) {
                    linkedList.add(value);
                    table[code].setValue((V) linkedList);
                }
            } else throw new ArrayIndexOutOfBoundsException();

        }

    }

    public void delete(K key) {
        int hash = linearProbing(key, true);
        if (isHashValid(hash) && table[hash] != null) {
            table[hash] = null;
            length--;
        }
    }

    // T(n) = O(n/2) => O(n)

    /**
     * ƒ(n) = n/2 + 16
     * lower bound = Omega(16)
     * upper bound = n + 16
     * // goal is to find the next empty index if the index is not empty
     **/
    private int linearProbing(K key, boolean onlyNeedItem) {
        int code = super.hashCode(key);

        int i = 0, pre_code = code - 1, size = table.length;

        if (pre_code < 0) pre_code = size - 1;

        // in case size is too small to slice
        if (size < 2) {
            return lookForSlot(key, code) ? code : -1;
        } else {
            while (i < size / 2) {

                if (onlyNeedItem) {

                    // this is for if we only need the Pair that is in the Array
                    if (findKeySlot(key, code)) return code;
                    if (findKeySlot(key, pre_code)) return pre_code;

                } else {

                    // we are searching for empty lot or either already exist key so we can append to it
                    if (lookForSlot(key, code)) return code;
                    if (lookForSlot(key, pre_code)) return pre_code;
                }

                code = (code + 1) % size; // going circular
                pre_code = Math.abs((pre_code - 1) % size);
                i++;
            }
        }

        return -1;
    }

    //https://www.khanacademy.org/computing/computer-science/algorithms/asymptotic-notation/a/asymptotic-notation

    // this function check if slot @ i is empty or if not is there a key that matches if so return true/false
    private boolean lookForSlot(K key, int i) {
        return table[i % table.length] == null || table[i % table.length].getKey().equals(key);
    }

    private boolean findKeySlot(K key, int i) {
        return table[i] != null && table[i % table.length].getKey().equals(key);
    }


    public V get(K key) {
        return Optional.ofNullable(getPair(key)).map(Pair::getValue).orElse(null);
    }

    private Pair<K, V> getPair(K key) {
        int code = linearProbing(key, true);
        if (isHashValid(code) && table[code] != null) {
            return table[code].getKey().equals(key) ? table[code] : null;
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(table);
    }

}
