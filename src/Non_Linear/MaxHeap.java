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
 * Parent Node: i - 1 / 2
 * Left Child: (2 * i) + 1
 * Right Child: (2 * i) + 2
 */
public class MaxHeap extends MinHeap {

    private int data[];
    private int index;

    public MaxHeap(int size){
        super(size);
        this.data = super.getData();            // this.data is pointing to the same array as super.data
        for (int i = 0; i < size; i++) data[i] = Integer.MIN_VALUE;
        this.index = -1;
        super.setSize(this.data.length);
    }


    public void insert(int item) {
        if (super.isFull()) return;
        data[++index] = item;
        heapify(index);
    } 

    // process of bubbling up the last inserted value to where it blongs in the Heap   
    private void heapify(int i){
        
        // compare ith node with its parent, if parent is smaller then swap
        int parent_index = (i - 1) / 2 ;

        // parent index exceed array then return
        if (parent_index < 0) return;

        // check if parent is smaller then it's child then swap
        if (data[parent_index] < data[i]) {
            super.swap(parent_index,i);

            // bubble up from parent and check upper level of tree
            heapify(parent_index);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int remove() {
        return data[0];
    }

    public static void main(String[] args) {
       
        MaxHeap heap = new MaxHeap(10);
        heap.insert(10);
        heap.insert(5);
        heap.insert(50);
        heap.insert(60);
        heap.insert(0);
        heap.insert(1);
        heap.insert(1010);
        System.out.println(heap);
        System.out.println(heap.remove());
    }

};