package com.company.Trees;


import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Almost complete Binary Tree
 * Insertion:
 * # Insertion is done by level and from left to right order at each level and the last level is not fully filled always.
 * # Contains 2^Level nodes at each level expect last level
 * # At last level nodes should be filled from left to right
 * <p>
 * Properties of Heap
 * # Tree based
 * # Complete tree
 * # Types of Heap are Min heap and Max heap
 * <p>
 * Min Heap: Complete binary tree in which root should always be smallest, and same goes for sub-trees
 * Max Heap: Complete binary tree in which root should always be largest, and same goes for sub-trees
 * <p>
 * A tree can be represented in the form of an array
 * Usages:
 * i = root -> starts from 0
 * Parent Node at i index
 * Left Child of Parent Node is -> 2 * i + 1
 * Right Child of Parent Node is -> 2 * i + 2
 * <p>
 * index of child node at i index then the Parent of that child node is at Math.ciel( i / 2) - 1
 * <p>
 * Representation:
 * 1               Root: Level 0 -> 2^0 = 1 Node
 * 3     5                  Level 1 -> 2^1 = 2 Nodes
 * 6    7                      Level 2 -> 2^2 = 4 Nodes, but we have 2 nodes from Left to right Hence it's "Almost complete binary tree"
 */
public class MinHeap {

    private int index;
    private final int data[];
    private int size;

    public MinHeap(int size) {
        this.index = 0;
        this.data = new int[size];

        for (int i = 0; i < size; i++) data[i] = Integer.MIN_VALUE;
        this.size = size;
    }

    public void insert(int item) {

        if (data[index] == Integer.MIN_VALUE){
            data[index] = item;
        }else if (data[(2 * index) + 1] == Integer.MIN_VALUE){
            data[(2 * index) + 1] = item;
            System.out.println("Inserting Left");
        }else if (data[(2 * index) + 2] == Integer.MIN_VALUE){
            data[(2 * index) + 2] = item;
            System.out.println("inserting Right");
        }else {
            ++index;
            System.out.println("Calling another");
            insert(item);

        }
    }

    public boolean isFull() {
        return this.size == this.index - 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
       for (int i = 0; i < 10; i++) {
           minHeap.insert(i);
           System.out.println("\n");
       }

        System.out.println(minHeap);
    }
}