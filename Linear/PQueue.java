package com.company;


import java.util.Arrays;

// Also a Min heap
public class PQueue {

    private int length;
    int[] pq;
    private final int size;
    private int p;


    public PQueue(int size) {
        length = -1;
        p = 0;
        this.size = size;
        this.pq = new int[size];
        Arrays.fill(pq, Integer.MIN_VALUE);
    }

    private int getPosition(int item) {

        if (length > 0) {

            int i = 0;
            while (i < length && item >= pq[i]) {
                i++;
            }
            return i;
        }
        return 0;
    }

    public boolean isFull() {
        return length == size - 1;
    }

    public void add(int item) {
        if (!isFull()) {
            ++length;
            int pos = getPosition(item);
            if (pq[pos] != Integer.MIN_VALUE) {
                shiftPQ(pos);
            }
            pq[pos] = item;
        }
    }

    // shift from to the end of list (length)
    private void shiftPQ(int from) {
        int l = length;
        while (l > from) {
            pq[l] = pq[l - 1];
            l--;
        }
    }


    public int poll() {
        int item = pq[p];
        p++;
        return item;
    }

}
