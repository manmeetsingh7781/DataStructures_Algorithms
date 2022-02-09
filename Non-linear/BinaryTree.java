package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BinaryTree<T extends Number> {
    private Node<T> root;

    public BinaryTree() {
        System.out.println("Binary Tree is created");
    }

    public Node<T> getRoot() {
        return root;
    }

    protected void setRoot(Node<T> root) {
        this.root = root;
    }

    private boolean isLeaf(Node<T> aNode) {
        return aNode.getLeft() == null && aNode.getRight() == null;
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


    private Node<T> deleteHelper(Node<T> root, T item) {
        if (root != null) {
            if (root.getData().doubleValue() > item.doubleValue()) {
                root.setLeft(deleteHelper(root.getLeft(), item));
            } else if (root.getData().doubleValue() < item.doubleValue()) {
                root.setRight(deleteHelper(root.getRight(), item));
            } else if (root.getData().doubleValue() == item.doubleValue()) {
                // once we found the node to delete then start the deletion cases
                // 1st case: if node is leaf
                if (isLeaf(root)) {
                    return null;
                } else {

                    // 2nd case: if node has 1 child
                    if (root.getLeft() != null && root.getRight() == null) {
                        root = root.getLeft();
                    } else if (root.getLeft() == null && root.getRight() != null) {
                        root = root.getRight();
                    } else {
                        // 3rd case: if node has both child
                        // find deepest node from Right side of Root, replace the node to be remove with deepest value
                        // remove deepest node
                        Node<T> rightMost = rightMost(root.getLeft());


                        if (rightMost == null) {
                            rightMost = leftMost(root.getRight());
                        }

                        delete(rightMost.getData());
                        root.setData(rightMost.getData());

                    }
                }
            }
            return root;
        }
        return null;
    }


    public void delete(T item) {
        root = deleteHelper(root, item);
    }


    // find deepest leaf node on right on left sub tree
    private Node<T> rightMost(Node<T> root) {
        if (root == null) return null;

        if (isLeaf(root) || root.getRight() == null) {
            return root;
        }

        return rightMost(root.getRight());
    }

    // find deepest leaf node on left on right sub tree
    private Node<T> leftMost(Node<T> root) {
        if (root == null) return null;
        if (isLeaf(root) || root.getLeft() == null) {
            return root;
        }
        return leftMost(root.getLeft());
    }

    private Node<T> containsHelper(Node<T> root, T key) {
        if (root != null) {
            if (root.getData().doubleValue() == key.doubleValue()) {
                return root;
            } else if (root.getData().doubleValue() > key.doubleValue()) {
                return this.containsHelper(root.getLeft(), key);
            } else {
                return this.containsHelper(root.getRight(), key);
            }
        }
        return null;
    }

    protected Node<T> getNode(T key) {
        return containsHelper(root, key);
    }

    public boolean contains(T key) {
        return containsHelper(root, key) != null;
    }

    private void inOrder(Node<T> root) {
        if (root != null) {
            this.inOrder(root.getLeft());
            System.out.print(root.getData() + ", ");
            this.inOrder(root.getRight());
        }
    }


    public void printInorder() {
        this.inOrder(this.root);
        System.out.println();

    }

    private void preOrder(Node<T> root) {
        if (root != null) {
            System.out.print(root.getData() + ", ");
            this.preOrder(root.getLeft());
            this.preOrder(root.getRight());
        }
    }

    public void printPreOrder() {
        this.preOrder(this.root);
        System.out.println();
    }

    private void postOrder(Node<T> root) {
        if (root != null) {
            this.postOrder(root.getLeft());
            this.postOrder(root.getRight());
            System.out.print(root.getData() + ", ");
        }
    }

    private ArrayList<T> getListInOrderHelper(ArrayList<T> data, Node<T> root) {
        if (root != null) {
            getListInOrderHelper(data, root.getLeft());
            data.add(root.getData());
            getListInOrderHelper(data, root.getRight());
        }
        return data;
    }


    public ArrayList<T> getListInOrder() {
        return getListInOrderHelper(new ArrayList<>(), root);
    }


    private ArrayList<T> getListPreorderHelper(ArrayList<T> data, Node<T> root) {
        if (root != null) {
            data.add(root.getData());
            getListInOrderHelper(data, root.getLeft());
            getListInOrderHelper(data, root.getRight());
        }
        return data;
    }

    public ArrayList<T> getListPreorder() {
        return getListPreorderHelper(new ArrayList<>(), root);
    }


    private ArrayList<T> getListPostorderHelper(ArrayList<T> data, Node<T> root) {
        if (root != null) {
            getListInOrderHelper(data, root.getLeft());
            getListInOrderHelper(data, root.getRight());
            data.add(root.getData());
        }
        return data;
    }

    public ArrayList<T> getListPostorder() {
        return getListPostorderHelper(new ArrayList<>(), root);
    }

    public void printPostorder() {
        this.postOrder(this.root);
    }

    public void insert(T item) {
        this.root = this.insertHelper(this.root, item);
    }

    private double calculateSum(Node<T> root) {
        return root != null ? root.getData().doubleValue() + this.calculateSum(root.getLeft()) + this.calculateSum(root.getRight()) : 0.0D;
    }

    public double getSum() {
        return this.calculateSum(this.root);
    }

    protected int getHeight(Node<T> root) {
        if (root != null) {
            int left = this.getHeight(root.getLeft());
            int right = this.getHeight(root.getRight());
            return Math.max(left, right) + 1;
        } else {
            return 0;
        }
    }

    public int getHeight() {
        return this.getHeight(this.root);
    }

    private double maximum(Node<T> root) {
        if (root != null) {
            double max = root.getData().doubleValue();
            double left = this.maximum(root.getLeft());
            double right = this.maximum(root.getRight());
            if (max < left) {
                max = left;
            } else if (max < right) {
                max = right;
            }
            return max;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public double getMax() {
        return this.maximum(this.root);
    }

    private double minimum(Node<T> root) {
        if (root != null) {
            double min = root.getData().doubleValue();
            double left = this.minimum(root.getLeft());
            double right = this.minimum(root.getRight());
            if (min > left) {
                min = left;
            } else if (min > right) {
                min = right;
            }

            return min;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    private Node<T> invertHelper(Node<T> root) {
        if (root == null) {
            return null;
        }

        var temp = root.getLeft();

        root.setLeft(root.getRight());
        root.setRight(temp);

        invertHelper(root.getLeft());
        invertHelper(root.getRight());

        return root;
    }

    public void invert() {
        setRoot(invertHelper(root));
    }

    /**
     * Completely erases the binary tree, delete all its data
     */
    public void erase() {
        setRoot(null);
    }

    public double getMin() {
        return this.minimum(this.root);
    }

    public int getCount() {
        return this.getListInOrder().size();
    }

    public double getAverage() {
        return this.getSum() / (double) this.getCount();
    }
}