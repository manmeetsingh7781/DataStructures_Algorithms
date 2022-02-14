//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

public class Node<T extends Number> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T item) {
        data = item;
    }
    public Node(T item, Node<T> left, Node<T> right) {
        data = item;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
