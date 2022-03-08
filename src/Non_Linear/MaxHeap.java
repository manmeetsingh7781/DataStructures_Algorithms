package Non_Linear;

public class MaxHeap extends MinHeap {

    private int data[];
    public MaxHeap(int size){
        super(size);
        this.data = super.getData();
        for (int i = 0; i < size; i++) data[i] = Integer.MIN_VALUE;
    }



    

    public static void main(String[] args) {
       
    }

};