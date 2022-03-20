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

    @Override
    public int remove() {


        // 0. check if tree is empty then return -1 else follow steps below 
        // 1. take out root item: Largest item in the tree
        // 2. replace root item with leaf node on left sub tree: last item in the array
        // 3. replace last item in the array NULL
        // 4. update index to index -= 1: Since we deleted one item
        // 5. Heapify from root to the bottom of tree by comparing parent with nodes  and swapping if needed

        // 0
        if (super.isEmpty()) return -1;

        // 1
        int largest_item = data[0];
    
        // 2
        data[0] = data[index];

        // 3
        data[index] = Integer.MIN_VALUE;
        
        // 4
        index--;

        // 5
        heapify_bottom(0);

        return largest_item;
    }


    private void heapify_bottom(int i) {

        if (isLeaf(i)) return;

        // compare ith node with it's children and swap accordingly

        int left_index = (2 * i) + 1;
        int right_index = (2 * i) + 2;


        // if parent has only 1 node

        if (left_index <= index && right_index > index) {
            if ( data[left_index] > data[i]){
                swap(left_index, i);
                heapify_bottom(left_index);
            }
        }else {
            
            // if parent has children

            if (data[left_index] > data[right_index] && data[left_index] > data[i]) {
                swap(left_index, i);
                heapify_bottom(left_index);
            }else {
                if (data[right_index] > data[i]) {
                    swap(right_index, i);
                    heapify_bottom(right_index);
                }
            }
        }



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