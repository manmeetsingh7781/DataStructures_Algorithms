package Sorting;

public class QuickSort{

      // T(n) = O(n)
      // finds the smallest and biggest in the array and returns the index
      private int[] getIdx(int[] arr){
            int s_i = 0, b_i = 0;
            for(int i = 1; i < arr.length; i++){
                  if(arr[s_i] > arr[i]) s_i = i;
                  if (arr[b_i] < arr[i]) b_i = i;
            }
            int[] res = {s_i, b_i};
            return res;
      }

      public static void print(String... s){
            for(String st: s) {System.out.println(st);}
      }

      private void swap(int[] a, int i, int i2){
            int temp = a[i];
            a[i] = a[i2];
            a[i2] = temp;
      }

      private int partation(int [] a, int start, int end){
            // Pivot picks the last element of the input array
            int pivot = a[end];
            int x = start-1;
            // process the array from left-right in a single pass using the variable i
            for(int i = start; i < end; i++){
                  // loop through the array

                  // if the current element of the array is smaller than the pivot, x++ and swapped
                  if(a[i] < pivot){
                        x++; // incremented
                        // swapped
                        swap(a, x, i);
                  }
            }

            // by the loop ends the x must be pointing to the larger value then the pivot or same as that.
            // now we swap them
            x++;
            swap(a, x, end);
            return x;

      }

      private void sortHelper(int low, int high, int[] arr){
            if(low < high){
                  int p = partation(arr, low, high);
                  sortHelper(low, p-1, arr);
                  sortHelper(p+1, high, arr);
            }

                  // a {10, 16, 8, 12, 15, 6, 3, 7, 5} = 9 = > last INT_MAX
                  /*
                  pivot = 10
                  i = 0; (Search for elements that are greater then arr[0] = 10)
                  j = end of arr at INT_MAX ( search for elements that are smaller then pivot)
                   so i and j can compare and swap the number

                  i will stop at INT_MAX
                  j will stop at 0


                  i: increment i until you find greater element then pivot
                  j: decrement j unitl you find the smaller then pivot
                  j-- if arr[j] <= pivot if yes swap them
                  i++ if pivot is greter then i

                  if i > j then we have found the pivot position
                  j is where pivot is
                  swap the j with the pivot location


            */
      }

      // divide and conqure
      public void sort(int[] arr){
            int low = 0;
            int high = arr.length-1;
            this.sortHelper(low, high, arr);

      }

      public static void main(String... args){
            int[] a = {4, 5, 33, 17, 3, 21, 1, 16};
            QuickSort s = new QuickSort();
            s.sort(a);
            for(int i: a) System.out.print(i+", ");



      }
}
