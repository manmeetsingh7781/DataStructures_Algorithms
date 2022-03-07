public class MaxHeap {

    private int index, size;
    private final int data[];

    public MaxHeap(int size){
        this.index = -1;
        this.data = new int[size];
        for (int i = 0; i < size; i++) data[i] = Integer.MIN_VALUE;
        this.size = size;
    }


    public static void main(String[] args) {
        System.out.println("Max Heap");
    }

};