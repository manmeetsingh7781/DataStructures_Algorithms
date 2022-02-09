package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class AVLTree<T extends Number> extends BinaryTree<T> {

    public int getBalanceFactor() {
        return super.getHeight(getRoot().getLeft()) - super.getHeight(getRoot().getRight());
    }

    private int getBalanceFactor(Node<T> root) {
        /*
         * Calculate height of Left tree of Root and then Right tree of root
         * Once its done Subtract Left Height - Right Height
         * */
        if (root == null) return 0;
        return getHeight(root.getLeft()) - getHeight(root.getRight());
    }

    public boolean isBalanced() {
        if (getRoot() == null) return false;
        int balance = getBalanceFactor();
        return balance >= -1 && balance <= 1;
    }

    private @NotNull
    Node<T> LLRotation(Node<T> root) {

        // Left Left insertion: Right Rotations are performed when Root has BF of 2 (indicating Left side Heavy)
        // and Root->Left BF is 1 (indicating Left sub is also Left heavy)
        // LL Rotation

        // backup root
        var temp = new Node<>(root.getData());
        temp.setRight(root.getRight());

        // make roots left as root
        root = root.getLeft();

            /*
            if root have any data on right, copy it and set it to temp's left
                Since the node we are moving has children, they must go in order: Left child must be inserted into Left Subtree and Right into Right Subtree
            */
        var rootR = root.getRight();

        temp.setLeft(rootR);
        root.setRight(temp);
        return root;
    }


    private Node<T> LRRotation(Node<T> root) {
         /*
            LR Rotation
            Left - Right Rotation: Need Right and then Left Rotation
            Root is Positive (left heavy) and Root left sub child is Negative (Right heavy)
            if left root has BF of 2 (left heavy) and its left sub child has bf of -1 (right heavy)
        */

        // backup root and its Right child
        var rootTemp = new Node<>(root.getData());
        rootTemp.setRight(root.getRight());

        // cache the node that we want to rotate, and its children
        var rightSubOfLeft = root.getLeft().getRight();

        // instead of rotation just replace the data with node that we wanted to rotate
        root.setData(rightSubOfLeft.getData());
        root.setRight(rootTemp);


        // finally insert the remaining children on node that we wanted to move into the tree
        // left child goes into left side of tree and right goes into right side of tree
        root.getLeft().setRight(rightSubOfLeft.getLeft());
        root.getRight().setLeft(rightSubOfLeft.getRight());
        return root;
    }


    private Node<T> RLRotation(Node<T> root) {
          /*
            RL Rotation
            Right - Left Rotation: Left and then Right Rotation needs to be performed
            if right root has BF of -2 (right heavy) and its right sub child has BF of 1 (left heavy)
         */

        // backup root and its children
        var rootTemp = new Node<>(root.getData());
        rootTemp.setLeft(root.getLeft());

        // get the node that we want to rotate, with this we get access to its children nodes too
        var leftSubOfRight = root.getRight().getLeft();

        // instead of rotation just replace the data with node that we wanted to rotate
        root.setData(leftSubOfRight.getData());

        // rotate the root by setting the left that we just backed up
        root.setLeft(rootTemp);

        // finally insert the remaining children on node that we wanted to move into the tree
        // left child goes into left side of tree and right goes into right side of tree
        root.getLeft().setRight(leftSubOfRight.getLeft());
        root.getRight().setLeft(leftSubOfRight.getRight());
        return root;
    }


    private Node<T> RRRotation(Node<T> root) {
        /*
            RR Rotation
            Right Right Insertion :
            Need Left Rotations, performed when Root has BF of -2 (right heavy) and Root->Right BF is -1 (Right heavy)
             */
        // backup root
        var temp = new Node<>(root.getData());
        temp.setLeft(root.getLeft());

        // make roots right as root
        root = root.getRight();

        // if root have any data on right, copy it
        var rootR = root.getLeft();

        // set left of root->Right node to parent (original) node
        temp.setRight(rootR);

        // finally set the left node of what we just rotated
        root.setLeft(temp);
        return root;
    }

    /**
     * RR rotation, left heavy rotate to right
     * Root -> Left -> Left
     * <p>
     * LL rotation, right heavy rotate to left
     * Root -> Right -> Right
     * <p>
     * LR rotation, left right heavy
     * perform left rotation
     * perform right rotation
     * Root -> Left -> Right
     * <p>
     * RL rotation, right left heavy
     * perform right rotation
     * perform left rotation
     * Root -> Right -> Left
     **/
    protected Node<T> balance(Node<T> root) {


        if (root == null) return null;

        // calculate the Balance factor of Root Node
        int rootBF = getBalanceFactor(root);

        // calculate the Balance factor of Left Node of Root Node
        int leftSubTreeBf = getBalanceFactor(root.getLeft());

        // calculate the Balance factor of Right Node of Root Node
        int rightSubTreeBf = getBalanceFactor(root.getRight());

        if (rootBF == 2 && leftSubTreeBf == 1) {
            root = LLRotation(root);
        } else if (rootBF == 2 && leftSubTreeBf == -1) {
            root = LRRotation(root);
        } else if (rootBF == 2 && leftSubTreeBf == 0) {
            root = LLRotation(root);
        } else if (rootBF == -2 && rightSubTreeBf == -1) {
            root = RRRotation(root);
        } else if (rootBF == -2 && rightSubTreeBf == 1) {
            root = RLRotation(root);
        } else if (rootBF == -2 && rightSubTreeBf == 0) {
            root = RRRotation(root);
        }
        // iterate though tree and balance subtrees
        root.setLeft(balance(root.getLeft()));
        root.setRight(balance(root.getRight()));

        return root;
    }

    @Override
    public void insert(T item) {
        super.insert(item);
        setRoot(balance(getRoot()));
    }


    @Override
    public void delete(T item) {
        super.delete(item);
        setRoot(balance(getRoot()));
    }

    public ArrayList<T> toMinHeap() {
        return getListInOrder();
    }
}