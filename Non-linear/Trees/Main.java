package com.company.Trees;

public class Main {

    public static void main(String[] args) {
        MinHeap<Integer> tree = new MinHeap<>();
        tree.insert(10);
        tree.insert(0);
        tree.insert(20);
        tree.insert(-10);
        tree.insert(120);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.printInorder();
        tree.printPostorder();
        tree.printPreOrder();

    }
}
