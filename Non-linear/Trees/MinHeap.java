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
        this.index = -1;
        this.data = new int[size];

        for (int i = 0; i < size; i++) data[i] = Integer.MIN_VALUE;
        this.size = size;
    }

    public void insert(int item) {
        // normal insertion in linear way
        if (isFull()) return;
        data[++index] = item;
        heapify(index);
    }

    public void heapify(int index) {

        // index of parent node
        int parentIndex = (index - 1) / 2;

        // if index is not valid then return
        if (parentIndex < 0) return;

        // if parent node is greater than current node then swap
        if (data[parentIndex] != Integer.MIN_VALUE && data[index] < data[parentIndex]) {
            // swap data[parentIndex] and data[index]
            int temp = data[parentIndex];
            data[parentIndex] = data[index];
            data[index] = temp;

            // if current node is greater than parent node then heapify again until parent node is greater than current node
            heapify(parentIndex);
        }

    }

    public int remove() {
        if (isEmpty()) return -1;

        int element = data[0];

        return element;
    }

    public boolean isFull() {
        return this.size == this.index - 1;
    }

    public boolean isEmpty() {
        return index == -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(1);
        System.out.println(minHeap);


        System.out.println("Removing element: " + minHeap.remove());

        System.out.println(minHeap);
    }
}