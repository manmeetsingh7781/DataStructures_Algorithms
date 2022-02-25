package com.company.Trees;


/**
 * Almost complete Binary Tree
    Insertion:
            # Insertion is done by level and from left to right order at each level and the last level is not fully filled always.
            # Contains 2^Level nodes at each level expect last level
            # At last level nodes should be filled from left to right

 * Properties of Heap
            # Tree based
            # Complete tree
            # Types of Heap are Min heap and Max heap

 * Min Heap: Complete binary tree in which root should always be smallest, and same goes for sub-trees
 * Max Heap: Complete binary tree in which root should always be largest, and same goes for sub-trees

 * A tree can be represented in the form of an array
 *      Usages:
 *              i starts from 0
 *             Parent Node at i index
 *             Left Child of Parent Node is -> 2 * i + 1
 *             Right Child of Parent Node is -> 2 * i + 2
 *
 *             index of child node at i index then the Parent of that child node is at Math.ciel( i / 2) - 1
 *
 * Representation:
 *                          1               Root: Level 0 -> 2^0 = 1 Node
*                        3     5                  Level 1 -> 2^1 = 2 Nodes
*                     6    7                      Level 2 -> 2^2 = 4 Nodes, but we have 2 nodes from Left to right Hence it's "Almost complete binary tree"
 *
 * */
public class MinHeap{


}