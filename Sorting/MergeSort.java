package Sorting;

import java.lang.System;

public class MergeSort{

    // divide and conqure
    // T(n) = O( log n )

    // T(n) = O ( n log n ) in worst case

    private void merge(int[] arr, int start,  int end){
        int i = start;
        int mid = (start+end) / 2; // slice 1 array in halfs (left and right)
        int j = mid + 1;
        int[] arrayTemp = new int[end-start+1];

        for(int k = 0; k < arrayTemp.length; k++){
            // check the i < middle, where one array ends
            // check if the j where the second array starts pointer is greater then the end point of the array
            if(i <= mid && (j > end || (arr[i] <= arr[j]) )){
                // if n elem of left array is smaller then n elem of right array
                // then we will place our smaller elem at k of tempArray
                arrayTemp[k] = arr[i];
                i++;
            }else{
                arrayTemp[k] = arr[j];
                j++;
            }
        }

        // src, srcPosition, destination, destPost,  the number of array elements to be copied
        // since we are placing our sorted elements in temp array from 0 to end of the array
         // now we have to copy and replace all the sorted elements into to the original array
        System.arraycopy(arrayTemp, 0, arr, start, arrayTemp.length);
    }

    private void mergeSort(int[] arr, int start, int end){
        // check if start point of arr is less then end point of it
        // if so then slice it in half and sort the halves
        if(start < end){   // if start < end it means there are more then 2 elements else there is single element
            int middle = (start+end) / 2;
            // now here we will have 0 to mid will be sorted
            mergeSort(arr, start, middle);

            // now we want to sort from below mid to the end
            mergeSort(arr, middle+1, end);

            // now we have sliced them, next step is to merge them together
            // we are merging two halves into one, so we have to pass the 0 to mid and mid to and end
            merge(arr, start, end);

        }
    }

    public void sort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }

    public static void main(String... args){
        MergeSort sorter = new MergeSort();
        int[] a = {45, 22, 451, 16, 75, 84, 15, 54};
        sorter.sort(a);
        for(int i: a)System.out.print(i+" ");
    }

}
