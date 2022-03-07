
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


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

    private int index, size;
    private int data[];

    public MinHeap(int size) {
        this.index = -1;
        
        this.data = new int[size];

        for (int i = 0; i < size; i++) data[i] = Integer.MAX_VALUE;
        this.size = size;
    }

    public void insert(int item) {
        // normal insertion in linear way
        if (isFull()) {
            return;
        }
        else {
            data[++index] = item;

            // once the item is added, conver the unordered list to heap so that we get min/max element at root (on top)
            heapify(index);
        }

    }

    public void heapify(int i) {

        // index of parent node
        int parentIndex = (i - 1) / 2;

        // if index is not valid then return
        if (parentIndex < 0) return;

        // if parent node is greater than current node then swap
        if (data[parentIndex] != Integer.MAX_VALUE && data[i] < data[parentIndex]) {

            // if child at i is smaller then parent then swap
            swap(parentIndex, i);

            // if current node is greater than parent node then heapify again until parent node is greater than current node
            heapify(parentIndex);
        }

    }

    public int remove() {
        if (isEmpty()) return -1;

        int element = data[0];  // get root element
        data[0] = data[index];  // get the last element and repalce it with root element

        // set the last value of an array with MAX (treat as a NULL)
        data[index] = Integer.MAX_VALUE; 
    
        index--;
        
        // since we placed new element at top, we need to heapify again in order to get minimum value at the top
        heapify_bottom(0);

        return element;
    }

    private boolean isLeaf(int i) {
        int left_child = 2 * i + 1;
        int right_child = 2 * i + 2;
        if (left_child >= index && right_child >= index) return true;
        return data[left_child] == Integer.MAX_VALUE && data[right_child] == Integer.MAX_VALUE;
    }

    private void swap(int indexA, int indexB) {
        int temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    // top to bottom heapify
    private void heapify_bottom(int i) {
        // if given index is greater then number of items stored in list then return

        if (isLeaf(i) || isEmpty()) return; 

        // index's of child of parent node
        int left_child = (2 * i) + 1;
        int right_child = (2 * i) + 2;
        
        // if left child is not NULL and Left child is smaller then Right child as well Left child has smaller value then root then swap
        if (data[left_child] != Integer.MAX_VALUE && data[left_child] < data[right_child] && data[left_child] < data[i]) {
            swap(i, left_child);
            
            // heapify the left sub tree so that we bubble down the largest element to the bottom of the tree
            heapify_bottom(left_child);
        }else {
             
            // if right child is not NULL and Right child has smaller value then root then swap
            if (data[right_child] != Integer.MAX_VALUE && data[right_child] < data[i]) {
                swap(i, right_child);
                heapify_bottom(right_child);
            }
        }

    }


    // heapifies the unordered list 
    private void MIN_HEAP(int unordered_items []) {
        this.data = unordered_items;
        this.index = unordered_items.length - 1;
        // start heaping from bottom to top of the tree
        // go from right to left of internal nodes array

        int size = data.length;
        for(int i = (size / 2) - 1; i >= 0; i--) {
            
            // bubble up smaller item to the root
            heapify(i);

            // while swap there might be greater element that we need to bubble down 
            heapify_bottom(i);

        }
    }

    public boolean isFull() {
        return this.size - 1 == this.index;
    }

    public boolean isEmpty() {
        return index == -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public int getNSmallest(int n) {
        if (n < 1) return -1;
        n--;
        int i = 0;
        int elm = -1;
        while (!isEmpty()) {
            elm = remove();
            if (i == n) break;
            i++;
        }
        return elm;
    }

    public void getInternalNodes(){

        // formula to get internal nodes
        int start = 0;
        int stop = (index / 2) - 1;
        
        for (int i = start; i <= stop; i++) {
            System.out.println(data[i]);
        }
    }

    public void getLeaves() {
        int start = (index / 2);
        int stop = index;
        for (int i = start; i <= stop; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        MinHeap min = new MinHeap(5);
        int data [] = {7961, 19158, 67967, 60906, 84969, 43312, 34250, 49507, 10877, 23793};
        System.out.println(Arrays.toString(data));
        min.MIN_HEAP(data);
       
        System.out.println(min);
        while (!min.isEmpty()) {
            System.out.println(min.remove());
        }






        /* Test Case 
            Random random = new Random();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter how many test cases you would like to do: ");
            int tests = scanner.nextInt();
            System.out.println("How many elements you would like to store in a Heap: ");
            int size = scanner.nextInt();
            MinHeap minHeap = new MinHeap(size);
            for(int j = 0; j < tests; j++){
                for(int i = 0; i < size; i++) {
                    minHeap.insert(random.nextInt(1000));
                }
                System.out.println(minHeap);
                while (!minHeap.isEmpty()) System.out.println(minHeap.remove());
                System.out.println("===================Test " + (j+1) + " Completed ====================");
            }
            scanner.close();

        */

    }


}
