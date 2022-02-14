package com.company.Trees;

import com.company.Node;


public class MinHeap<T extends Number> extends AVLTree<T> {


    public MinHeap() {
        super();
        super.setRoot(null);
    }

    public MinHeap(T item) {
        super.setRoot(new Node<T>(item));
    }

    private Node<T> hepify(Node<T> root, T item) {
        return null;
    }

    private Node<T> insertHelper(Node<T> root, T item) {
        if (root == null) {
            root = new Node<T>(item);
        } else if (root.getData().doubleValue() == item.doubleValue()) {
            return root;
        } else if (root.getData().doubleValue() > item.doubleValue()) {
            root.setLeft(this.insertHelper(root.getLeft(), item));
        } else {
            root.setRight(this.insertHelper(root.getRight(), item));
        }
        return root;
    }


    public void insert(T item) {
        super.setRoot(insertHelper(super.getRoot(), item));
    }

}