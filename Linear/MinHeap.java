package com.company;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

/* Balanced Tree based Heap or Array based Heaps
    There are two types of Heap: Min and Max
    Max-Heap: Where child node's value is less then or equals to (<=) its parent node value
    Min-Heap: Where child node's value is greater then or equals to (>=) its parent node value



    Expression:
        To access the Parent of Node (n) => n / 2
        To access left child of Node (n) => n * 2
        To access Right child of Node (n) => n * 2 + 1

* */
public class MinHeap {

    private int[] heap;
    private int index = 1;

    public MinHeap(int size) {
        heap = new int[size];
    }
    /**
     * Use an array to hold the data
     * Store the root in position 1
     *  we won't use index 0 for this implementation
     *
     * For any node in position i
     *  it's left child (if any) is in position 2 * i
     *  it's right child (if any) is in position 2 * i + 1
     *  it's parent (if any) is in position i / 2
     *      use integer division
     * **/


    /**
     * Insertion into a min heap
     * Place the new element in the next available position in the array
     * Compare the new element with its parent, if the new element is smaller then swap it with it's parent
     **/
    public void insert(int item) {
        heap[index] = item;
        heapify(index);
        index++;
    }

    private void heapify(int i) {

        if (i == 1) i += 1;

        int parent = i / 2;
        int left = 2 * parent;
        int right = left + 1;

        if (heap[left] != 0 && heap[left] <= heap[parent]) {
            int temp  = heap[parent];
            heap[parent] = heap[left];
            heap[left] = temp;
        }else {
            if (heap[right] != 0) {
                int temp = heap[parent];
                heap[parent] = heap[right];
                heap[right] = temp;
            }
        }

    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "heap=" + Arrays.toString(heap) +
                '}';
    }
}
/*
*
    private Node<T> insertHelper(Node<T> root, T item) {
        if (root == null) {
            root = new Node<>(item);
        } else {
            if (root.getLeft() == null) root.setLeft(insertHelper(root.getLeft(), item));
            else if (root.getRight() == null) root.setRight(insertHelper(root.getRight(), item));
            else {
                // check balance and insert which side is lighter
                int rootBf = getBalanceFactor();
                System.out.println("BF " + rootBf);
                // means right heavy, insert in left sub tree
                if (rootBf <= 0) {
                    root.setLeft(insertHelper(root.getLeft(), item));
                } else {
                    // insert in right sub tree
                    root.setRight(insertHelper(root.getRight(), item));
                }
            }

            // if left child is less then parent swap it
            if (root.getLeft() != null) {
                var leftData = root.getLeft().getData();
                if (leftData.doubleValue() < root.getData().doubleValue()) {
                    // swap left with root )
                    root.getLeft().setData(root.getData());
                    root.setData(leftData);
                }
            }


            // if right child is less then parent swap it
            if (root.getRight() != null) {
                var rightData = root.getRight().getData();
                if (rightData.doubleValue() < root.getData().doubleValue()) {
                    // swap right with root )
                    root.getRight().setData(root.getData());
                    root.setData(rightData);
                }
            }


        }
        return root;
    }

* */