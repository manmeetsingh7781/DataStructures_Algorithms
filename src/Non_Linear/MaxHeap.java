package Non_Linear;


/**
 * Max heap: Parent is greater then child
 * Heapify(): After the insertion is done which is in the last index of an array then bubbling up to where it blongs => Bottom to Root (Top) 
 * Heapify_bottom(): After deletion, the root element is removed and replaced with last item from an array during this process there's a chance that we dont have heap anymore so to fix this
 *                  we bubble down the element we just replaced at a root then bubble down to where it belongs => Root (Top) to Bottom
 *
 * MAX_HEAP(int data[]) : takes an unordered list and converts it to Max Heap by using Heapify() and Heapify_bottom() on it's internal nodes from Right to Left order
 * Internal Nodes: from 0 to N / 2 - 1 => [0, N/2 - 1]
 * Children Nodes: from N / 2 to N - 1 => [N/2, N-1]
 */
public class MaxHeap extends MinHeap {

    private int data[];

    public MaxHeap(int size){
        super(size);
        this.data = super.getData();            // this.data is pointing to the same array as super.data
        for (int i = 0; i < size; i++) data[i] = Integer.MIN_VALUE;
    }


    // process of bubbling up the last inserted value to where it blongs in the Heap   
    private void heapify(){

    }


    public static void main(String[] args) {
       System.out.println("Max heap");
    }

};